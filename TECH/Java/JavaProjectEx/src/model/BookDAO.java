package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Vector;
import util.DBConnect;

public class BookDAO implements IBookDAO {

  @Override
  public Vector<BookDTO> getAllBook() throws Exception {
    Vector<BookDTO> list = new Vector<>();
    Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    try {
      con = DBConnect.getConnection();
      String sql = "SELECT * FROM book ORDER BY bookno";
      pstmt = con.prepareStatement(sql);
      rs = pstmt.executeQuery();

      while (rs.next()) {
        BookDTO dto = new BookDTO();
        dto.setBookNo(rs.getString("bookno"));
        dto.setBookName(rs.getString("bookname"));
        dto.setBookAuthor(rs.getString("bookauthor"));
        dto.setBookPrice(rs.getInt("bookprice"));
        
        // 날짜 형식 변환 (yyyy-MM-dd 형식으로)
        java.sql.Date sqlDate = rs.getDate("bookdate");
        if (sqlDate != null) {
          SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
          dto.setBookDate(sdf.format(sqlDate));
        } else {
          dto.setBookDate("");
        }
        
        dto.setBookStock(rs.getInt("bookstock"));
        dto.setPubNo(rs.getString("pubno"));

        list.add(dto);
      }
    } catch (Exception e) {
      throw e;
    } finally {
      DBConnect.close(con, pstmt, rs);
    }

    return list;
  }

  @Override
  public boolean insert(BookDTO dto) throws Exception {
    //한권 도서 정보 저장
    Connection con = null;
    PreparedStatement pstmt = null;
    try {
      con = DBConnect.getConnection();
      pstmt = con.prepareStatement(
          "insert into book values(?, ?, ?, ?, ?, ?, ?)"
      );
      pstmt.setString(1, dto.getBookNo());
      pstmt.setString(2, dto.getBookName());
      pstmt.setString(3, dto.getBookAuthor());
      pstmt.setInt(4, dto.getBookPrice());
      // 날짜 형식 변환 (String -> java.sql.Date)
      try {
        java.sql.Date sqlDate = java.sql.Date.valueOf(dto.getBookDate());
        pstmt.setDate(5, sqlDate);
      } catch (Exception e) {
        // 날짜 형식이 잘못된 경우 현재 날짜 사용
        pstmt.setDate(5, new java.sql.Date(System.currentTimeMillis()));
      }
      pstmt.setInt(6, dto.getBookStock());
      pstmt.setString(7, dto.getPubNo());

      int result = pstmt.executeUpdate();
      if (result == 0) {
        return false;
      }
    } catch (Exception e) {
//      e.printStackTrace();
      throw e; //호출한 쪽에서 예외처리하도록 예외를 인위적으로 발생 전달받은 Exception 객체 떠넘김(end-user에게 전달)
    } finally {
      DBConnect.close(con);
    }
    return true;
  }

  @Override
  public boolean update(BookDTO dto) throws Exception {
    Connection con = null;
    PreparedStatement pstmt = null;
    try {
      con = DBConnect.getConnection();
      pstmt = con.prepareStatement(
          "UPDATE book SET bookname=?, bookauthor=?, bookprice=?, bookdate=?, bookstock=?, pubno=? WHERE bookno=?"
      );
      pstmt.setString(1, dto.getBookName());
      pstmt.setString(2, dto.getBookAuthor());
      pstmt.setInt(3, dto.getBookPrice());
      // 날짜 형식 변환 (String -> java.sql.Date)
      try {
        java.sql.Date sqlDate = java.sql.Date.valueOf(dto.getBookDate());
        pstmt.setDate(4, sqlDate);
      } catch (Exception e) {
        // 날짜 형식이 잘못된 경우 현재 날짜 사용
        pstmt.setDate(4, new java.sql.Date(System.currentTimeMillis()));
      }
      pstmt.setInt(5, dto.getBookStock());
      pstmt.setString(6, dto.getPubNo());
      pstmt.setString(7, dto.getBookNo());

      int result = pstmt.executeUpdate();
      if (result == 0) {
        return false;
      }
    } catch (Exception e) {
      throw e;
    } finally {
      DBConnect.close(con, pstmt);
    }
    return true;
  }

  @Override
  public boolean delete(BookDTO dto) throws Exception {
    // dto의 bookNo 필드에 저장된 도서번호의 도서 삭제
    Connection con = null;
    PreparedStatement pstmt = null;

    try {
      con = DBConnect.getConnection();
      String sql = "DELETE FROM book WHERE bookno=?";
      pstmt = con.prepareStatement(sql);
      pstmt.setString(1, dto.getBookNo());

      int result = pstmt.executeUpdate();

      if (result == 0) {
        return false;
      }
    } catch (Exception e) {
      throw e;
    } finally {
      DBConnect.close(con, pstmt);
    }

    return true;
  }
}
