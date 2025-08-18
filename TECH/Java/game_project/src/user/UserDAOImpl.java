package user;

import db.DBConnection;
import exception.UserException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 사용자 정보를 데이터베이스에 저장하고 관리하는 클래스
 */
public class UserDAOImpl implements UserDAO {
    // 싱글톤 인스턴스
    private static UserDAOImpl instance;
    
    // private 생성자
    private UserDAOImpl() {
    }
    
    // 인스턴스 반환 메소드
    public static UserDAOImpl getInstance() {
        if (instance == null) {
            instance = new UserDAOImpl();
        }
        return instance;
    }

    // 사용자 정보 저장
    @Override
    public boolean saveUser(UserDTO user) throws UserException {
        // 필수 필드 검증
        if (user == null) {
            throw new UserException("사용자 정보가 없습니다.");
        }
        
        if (user.getId() == null || user.getId().trim().isEmpty()) {
            throw new UserException.RequiredFieldMissingException("아이디");
        }
        
        if (user.getPassword() == null || user.getPassword().trim().isEmpty()) {
            throw new UserException.RequiredFieldMissingException("비밀번호");
        }
        
        if (user.getName() == null || user.getName().trim().isEmpty()) {
            throw new UserException.RequiredFieldMissingException("이름");
        }
        
        // ID 중복 확인
        if (findUserById(user.getId()) != null) {
            throw new UserException.DuplicateIdException();
        }
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try {
            // DB 연결
            conn = DBConnection.getInstance().getConnection();
            
            // SQL 쿼리 작성 및 실행
            String sql = "INSERT INTO users (username, password, name) VALUES (?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getId());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, user.getName());
            
            int result = pstmt.executeUpdate();
            return result > 0;
        } catch (SQLException e) {
            // 예외 발생 시 처리
            throw new UserException.RegistrationFailedException("DB 오류: " + e.getMessage());
        } finally {
            // 리소스 정리
            DBConnection.closeResources(conn, pstmt, null);
        }
    }

    // 사용자 ID로 사용자 정보 조회
    @Override
    public UserDTO findUserById(String id) {
        // ID 유효성 검사
        if (id == null || id.trim().isEmpty()) {
            return null;
        }
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try {
            // DB 연결
            conn = DBConnection.getInstance().getConnection();
            
            // SQL 쿼리 작성 및 실행
            String sql = "SELECT * FROM users WHERE username = ? AND status = 'A'";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();
            
            // 결과 처리
            if (rs.next()) {
                UserDTO user = new UserDTO();
                user.setId(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setName(rs.getString("name"));
                return user;
            }
        } catch (SQLException e) {
            // 예외 출력
            System.out.println("사용자 조회 중 오류 발생: " + e.getMessage());
        } finally {
            // 리소스 정리
            DBConnection.closeResources(conn, pstmt, rs);
        }
        
        return null;
    }

    // 로그인 처리
    @Override
    public UserDTO login(String id, String password) throws UserException {
        // 입력값 검증
        if (id == null || id.trim().isEmpty()) {
            throw new UserException.RequiredFieldMissingException("아이디");
        }
        
        if (password == null || password.trim().isEmpty()) {
            throw new UserException.RequiredFieldMissingException("비밀번호");
        }
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try {
            // DB 연결
            conn = DBConnection.getInstance().getConnection();
            
            // SQL 쿼리 작성 및 실행
            String sql = "SELECT * FROM users WHERE username = ? AND password = ? AND status = 'A'";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            pstmt.setString(2, password);
            rs = pstmt.executeQuery();
            
            // 결과 처리
            if (rs.next()) {
                UserDTO user = new UserDTO();
                user.setId(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setName(rs.getString("name"));
                return user;
            } else {
                throw new UserException.LoginFailedException();
            }
        } catch (SQLException e) {
            // 예외 발생 시 처리
            throw new UserException("로그인 처리 중 DB 오류: " + e.getMessage());
        } finally {
            // 리소스 정리
            DBConnection.closeResources(conn, pstmt, rs);
        }
    }

    // 모든 사용자 목록 조회
    @Override
    public List<UserDTO> getAllUsers() {
        List<UserDTO> userList = new ArrayList<>();
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try {
            // DB 연결
            conn = DBConnection.getInstance().getConnection();
            
            // SQL 쿼리 작성 및 실행
            String sql = "SELECT * FROM users WHERE status = 'A' ORDER BY id";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            
            // 결과 처리
            while (rs.next()) {
                UserDTO user = new UserDTO();
                user.setId(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setName(rs.getString("name"));
                userList.add(user);
            }
        } catch (SQLException e) {
            // 예외 출력
            System.out.println("사용자 목록 조회 중 오류 발생: " + e.getMessage());
        } finally {
            // 리소스 정리
            DBConnection.closeResources(conn, pstmt, rs);
        }
        
        return userList;
    }
    
    // 사용자 정보 수정
    @Override
    public boolean updateUser(UserDTO user) throws UserException {
        // 입력값 검증
        if (user == null) {
            throw new UserException("사용자 정보가 없습니다.");
        }
        
        if (user.getId() == null || user.getId().trim().isEmpty()) {
            throw new UserException.RequiredFieldMissingException("아이디");
        }
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try {
            // DB 연결
            conn = DBConnection.getInstance().getConnection();
            
            // 비밀번호만 변경
            if (user.getPassword() != null && !user.getPassword().trim().isEmpty()) {
                String sql = "UPDATE users SET password = ? WHERE username = ?";
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, user.getPassword());
                pstmt.setString(2, user.getId());
                
                System.out.println("비밀번호 변경: " + user.getPassword());
            } else {
                // 변경할 내용이 없음
                System.out.println("변경할 내용이 없습니다.");
                return false;
            }
            
            int result = pstmt.executeUpdate();
            return result > 0;
        } catch (SQLException e) {
            // 예외 출력 및 전달
            System.out.println("사용자 정보 수정 중 오류 발생: " + e.getMessage());
            throw new UserException("사용자 정보 수정 중 오류 발생: " + e.getMessage());
        } finally {
            // 리소스 정리
            DBConnection.closeResources(conn, pstmt, null);
        }
    }
    
    // 회원 탈퇴 처리
    @Override
    public boolean withdrawUser(String id) throws UserException {
        // 입력값 검증
        if (id == null || id.trim().isEmpty()) {
            throw new UserException.RequiredFieldMissingException("아이디");
        }
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try {
            // DB 연결
            conn = DBConnection.getInstance().getConnection();
            
            // SQL 쿼리 작성 및 실행
            String sql = "UPDATE users SET status = 'D' WHERE username = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            
            int result = pstmt.executeUpdate();
            return result > 0;
        } catch (SQLException e) {
            // 예외 발생 시 처리
            throw new UserException("회원 탈퇴 처리 중 오류 발생: " + e.getMessage());
        } finally {
            // 리소스 정리
            DBConnection.closeResources(conn, pstmt, null);
        }
    }
}