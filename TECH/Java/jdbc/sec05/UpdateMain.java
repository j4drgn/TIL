package jdbc.sec05;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateMain {

  public static void main(String[] args) {
    //Update 기능은 질의문에 모든 컬럼에 대한 update가 진행되도록 구성
    // 특정 튜플에 대해서 update가 진행되도록 구성 where 조건절 사용
    DBConnect dbConnect = new DBConnect();
    Connection conn = dbConnect.getConnection();
    PreparedStatement pstmt = null;

    Scanner sc = new Scanner(System.in);

    // 수정 data 입력 - 모든 컬럼 데이터 입력
    System.out.println("도서 정보 수정");
    System.out.print("수정할 도서번호 입력 : ");
    String bookNo = sc.nextLine();

    System.out.print("도서명 입력 : ");
    String bookName = sc.nextLine();

    System.out.print("도서저자 입력 : ");
    String bookAuthor = sc.nextLine();

    System.out.print("도서가격 입력 : ");
    int bookPrice = sc.nextInt();
    sc.nextLine();

    System.out.print("발행일 입력 : ");
    String bookDate = sc.nextLine();

    System.out.print("도서재고 입력 : ");
    int bookStock = sc.nextInt();

    sc.nextLine();

    System.out.print("출판사번호 입력 : ");
    String pubNo = sc.nextLine();

    try {
      String sql = "update book set bookname=?, bookauthor=?, bookprice=?, bookdate=?, bookstock=?, pubno=? where bookno=?";
      pstmt = conn.prepareStatement(sql);

      pstmt.setString(1, bookName);
      pstmt.setString(2, bookAuthor);
      pstmt.setInt(3, bookPrice);
      pstmt.setString(4, bookDate);
      pstmt.setInt(5, bookStock);
      pstmt.setString(6, pubNo);
      pstmt.setString(7, bookNo);

      //수정된 행의 수의 정수로 반환 - 필요시에는 저장
      //필요 없으면 저장하지 않아도 됌.
      int result = pstmt.executeUpdate(); //질의 중 오류발생하면 데이터베이스 오류(catch)에서 해결)

      System.out.println("도서 정보 수정 성공");

      pstmt.close();
      conn.close();
      sc.close();
    } catch (SQLException e) {
      e.printStackTrace();
      System.out.println("도서 정보 수정 실패");

    } finally {
      DBConnect.close(conn, pstmt);
    }
  }

}
