package jdbc.sec05;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteMain {

  public static void main(String[] args) {
    // where 조건절 이용 특정 레코드(튜플)만 삭제 되도록 질의 구성
    Connection conn = null;
    PreparedStatement pstmt = null;
    DBConnect dbConnect = new DBConnect();

    Scanner sc = new Scanner(System.in);

    String bookNo;
    System.out.println("도서 정보 삭제");
    System.out.print("삭제할 도서 번호 입력 : ");
    bookNo = sc.nextLine();
    try {
      conn = dbConnect.getConnection();

      String sql = "DELETE FROM books WHERE bookno = ?";
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, bookNo);
      pstmt.executeUpdate();

      System.out.println("도서 정보 삭제 성공");
    } catch (SQLException e) {
      System.out.println("도서 정보 삭제 실패");

      e.printStackTrace();
    } finally {
      DBConnect.close(conn, pstmt);
    }
    sc.close();
  }

}
