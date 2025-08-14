package jdbc.sec05;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SelectMain {

  public static void main(String[] args) {
    //조건절이 있는 select 쿼리 실행 예제
    // DB 연결
    DBConnect dbCon = new DBConnect();
    Connection con = dbCon.getConnection();
//    Statement stmt = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    Scanner sc = new Scanner(System.in);

    try {

      // Statement 객체 사용 예시
      // System.out.print("조회할 도서번호 입력 : ");
      // String no = sc.nextLine();
      // String sql = "select * from book where bookno='" + no + "'";
      // stmt = con.createStatement();
      // Statement 객체는 실행할 질의어가 executeXXX메소드에 전달 되기 이전에 전부 완성되어 있어야 함
      // 고정값이 아닌 변동값이면 쿼리 구성이 복잡해 짐(문자열 연결이 복잡함)
      // rs = stmt.executeQuery(sql);

      String sql = "select * from user where bookno=?";
      pstmt = con.prepareStatement(sql);

      System.out.println("조회할 도서 번호 입력");
      String no = sc.nextLine();

      pstmt.setString(1, no);

      rs = pstmt.executeQuery();

      while (rs.next()) {
        String bookNo = rs.getString(1);
        String bookName = rs.getString(2);
        int bookStock = rs.getInt(6);

        System.out.format("%-10s \t %-20s\t %3d \n", bookNo, bookName, bookStock);
      }

    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      DBConnect.close(con, pstmt, rs);
    }
  }

}
