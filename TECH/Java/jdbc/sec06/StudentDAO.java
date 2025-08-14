package jdbc.sec06;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


//CRUD 기능 구현 클래스 - CRUD interface 구현
public class StudentDAO implements IStudentDAO {

  public Connection conn = null;
  PreparedStatement pstmt = null;
  ResultSet rs = null;

  StudentDTO dto;
  StudentDTO std;
  ArrayList<StudentDTO> stdList = null;

  //생성자에서 DB연결
  public StudentDAO() {
    conn = DBConnect.getConnection();
  }

  @Override
  public void insertStudent(StudentDTO dto) {
    //학생 정보 입력
    try {
      String sql = "insert into student(stdNo, stdName, stdYear, stdbirth, dptNo) values(?,?,?,?,?)";
      pstmt = conn.prepareStatement(sql);
      //저장될 학생 정보는 dto 매개변수로 전달
      pstmt.setString(1, dto.getStdNo());
      pstmt.setString(2, dto.getStdName());
      pstmt.setInt(3, dto.getStdYear());
      pstmt.setDate(4, new java.sql.Date(dto.getStdBirth().getTime()));
      pstmt.setString(5, dto.getDptNo());

      int result = pstmt.executeUpdate();

      if (result > 0) {
        System.out.println("학생 등록 성공!");
      } else {
        System.out.println("학생 등록 실패!");
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      DBConnect.close(pstmt);
    }
  }

  @Override
  public ArrayList<StudentDTO> getALLStudents() {
    //모든 학생 정보 조회
    stdList = new ArrayList<StudentDTO>();
    try {
      String sql = "select * from student order by stdNo";
      pstmt = conn.prepareStatement(sql);
      rs = pstmt.executeQuery();

      while (rs.next()) {
        String stdNoVal = rs.getString("stdNo");
        String stdName = rs.getString("stdName");
        int stdYear = rs.getInt("stdYear");
        Date stdBirth = rs.getDate("stdbirth");
        String deptNoVal = rs.getString("dptNo");
        // 각 컬럼의 정보를 dto로 구성
        std = new StudentDTO(stdNoVal, stdName, stdYear, stdBirth, deptNoVal);

        //arraylist에 추가
        stdList.add(std);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      DBConnect.close(pstmt);
    }
    return stdList;
  }

  @Override
  public StudentDTO detailStudent(String stdNo) {
    //1명 학생정보 조회
    try {
      String sql = "select * from student where stdNo = ?";
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, stdNo);
      rs = pstmt.executeQuery();
      
      //기본키로 조회 진행 -> 조회되지 않거나 한명 학생 정보가 나옴
      if (rs.next()) {
        String stdNoVal = rs.getString("stdNo");
        String stdName = rs.getString("stdName");
        int stdYear = rs.getInt("stdYear");
        Date stdBirth = rs.getDate("stdbirth");
        String deptNo = rs.getString("dptNo");
        // 각 컬럼의 정보를 dto로 구성
        std = new StudentDTO(stdNoVal, stdName, stdYear, stdBirth, deptNo);
        return std;
      } else {
        System.out.println("해당 학번의 학생이 존재하지 않습니다.");
        return null;
      }
    } catch (SQLException e) {
      System.out.println("오류발생");
      e.printStackTrace();
      return null;
    } finally {
      DBConnect.close(pstmt, rs);
    }
  }

  @Override
  public void deleteStudent(String stdNo) {
    //1명 학생 정보 삭제
    try {
      //삭제 쿼리
      String sql = "delete from student where stdNo = ?";
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, stdNo);

      int result = pstmt.executeUpdate();
      
      if (result > 0) {
        System.out.println("학생 정보 삭제 성공");
      } else {
        System.out.println("학생 정보 삭제 실패");
      }
    } catch (SQLException e) {
      System.out.println("학생 정보 삭제 실패, 오류 발생");
      e.printStackTrace();
    } finally {
      DBConnect.close(pstmt);
    }
  }

  @Override
  public void updateStudent(StudentDTO dto) {
    //한명 학생 정보 수정 - 모든 컬럼값 전달
    try {
      String sql = "update student set stdName = ?, stdYear=?," +
          "stdbirth=?, dptNo=? where stdNo=?";
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, dto.getStdName());
      pstmt.setInt(2, dto.getStdYear());
      pstmt.setDate(3, new java.sql.Date(dto.getStdBirth().getTime()));
      pstmt.setString(4, dto.getDptNo());
      pstmt.setString(5, dto.getStdNo());

      int result = pstmt.executeUpdate();

      if (result > 0) {
        System.out.println("학생 정보 수정 성공");
      } else {
        System.out.println("학생 정보 수정 실패");
      }

    } catch (SQLException e) {
      System.out.println("학생 정보 수정 실패, 오류 발생");
      e.printStackTrace();
    } finally {
      DBConnect.close(pstmt);
    }
  }

  @Override
  public ArrayList<StudentDTO> searchStudent(String deptNo) {
    // 특정 과에 소속된 학생 조회
    stdList = new ArrayList<StudentDTO>();
    try {
      String sql = "select * from student where dptNo = ?";
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, deptNo);
      rs = pstmt.executeQuery();

      while (rs.next()) {
        String stdNoVal = rs.getString("stdNo");
        String stdName = rs.getString("stdName");
        int stdYear = rs.getInt("stdYear");
        Date stdBirth = rs.getDate("stdbirth");
        String deptNoVal = rs.getString("dptNo");
        // 각 컬럼의 정보를 dto로 구성
        std = new StudentDTO(stdNoVal, stdName, stdYear, stdBirth, deptNoVal);

        //arraylist에 추가
        stdList.add(std);
      }
    } catch (SQLException e) {
      System.out.println("정보 조회 오류");
      e.printStackTrace();
    } finally {
      DBConnect.close(pstmt, rs);
    }

    return stdList;
  }
  
  // 학과명을 통한 학생 조회 기능 추가
  public ArrayList<StudentDTO> searchStudentByDeptName(String deptName) {
    // 특정 과명에 소속된 학생 조회
    stdList = new ArrayList<StudentDTO>();
    try {
      String sql = "select s.* from student s, department d " +
                   "where s.dptNo = d.dptNo and d.dptName = ?";
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, deptName);
      rs = pstmt.executeQuery();

      while (rs.next()) {
        String stdNoVal = rs.getString("stdNo");
        String stdName = rs.getString("stdName");
        int stdYear = rs.getInt("stdYear");
        Date stdBirth = rs.getDate("stdbirth");
        String deptNoVal = rs.getString("dptNo");
        // 각 컬럼의 정보를 dto로 구성
        std = new StudentDTO(stdNoVal, stdName, stdYear, stdBirth, deptNoVal);

        //arraylist에 추가
        stdList.add(std);
      }
    } catch (SQLException e) {
      System.out.println("학과명 조회 오류");
      e.printStackTrace();
    } finally {
      DBConnect.close(pstmt, rs);
    }

    return stdList;
  }
}