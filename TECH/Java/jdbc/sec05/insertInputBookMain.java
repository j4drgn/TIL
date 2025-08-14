package jdbc.sec05;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class insertInputBookMain {

  public static void main(String[] args) {
    // DB연결 및 필요객체 생성
    DBConnect dbConnect = new DBConnect();
    Connection conn = dbConnect.getConnection();
    PreparedStatement pstmt = null;

    Scanner sc = new Scanner(System.in);

    try {
      System.out.println("도서 번호 입력 : ");
      String bookNO = sc.nextLine();
      System.out.println("도서 명 입력 :");
      String bookName = sc.nextLine();
      System.out.println("도서 저자 입력 :");
      String bookAuthor = sc.nextLine();
      System.out.println("도서 가격 입력 :");
      int bookPrice = sc.nextInt(); //값을 입력하고 ENTER 신호 들어오면 입력된 값만 정수 처리 반환
      // 다음 입력은 처리 되지않고 남아있는 enter가 입력 값으로 들어가게 됨
      sc.nextLine(); // 남아있는 enter 신호를 제거하기 위해 추가
      System.out.println("출판일 :");
      String bookDate = sc.nextLine();
      System.out.println("도서 재고 입력");
      int bookStock = sc.nextInt();
      //처리되지 않은 enter 처리
      sc.nextLine();
      System.out.println("출판사 번호 입력 : ");
      String pubNo = sc.nextLine();

      String sql = "insert into book values(?,?,?,?,?,?,?)";
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, bookNO);
      pstmt.setString(2, bookName);
      pstmt.setString(3, bookAuthor);
      pstmt.setInt(4, bookPrice);
      pstmt.setString(5, bookDate);
      pstmt.setInt(6, bookStock);
      pstmt.setString(7, pubNo);

      int result = pstmt.executeUpdate();

      if (result > 0) {
        System.out.println("도서 등록 성공");
      } else {
        System.out.println("도서 등록 실패");
      }
//      pstmt.close();
//      conn.close();
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      //리소스 반환 진행 - 객체 자원 반환 처리 static method 통해서 진행
      DBConnect.close(conn, pstmt);
    }
    sc.close();
  }
}
