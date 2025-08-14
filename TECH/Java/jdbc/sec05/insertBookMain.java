package jdbc.sec05;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class insertBookMain {

  public static void main(String[] args) {
    DBConnect dbConnect = new DBConnect();
    Connection conn = dbConnect.getConnection();
    PreparedStatement pstmt = null;

    String bookNo = "1020";
    String bookName = "알고리즘 2";
    String bookAuthor = "김철수";
    int bookPrice = 25000;
    String bookDate = "2024-05-07";
    int bookStock = 10;
    String pubNo = "1";

    try {
      //insert 쿼리문 작성
      //열의 value 자리에 '?'(placeholder)로 지정 - 바인딩변수
      String sql = "insert into book values(?,?,?,?,?,?,?)";

      //prepareStatement 객체 생성 시 바인딩 될 쿼리 구문 전달
      pstmt = conn.prepareStatement(sql);

      //바인딩될 data 준비되면, 실제값을 바인딩
      //prepareStatement.setXXX(idx, 값) -> 해당 위치 idx(?의 순서값)에 값을 바인딩
      //XXX는 바인딩될 실제값의 타입

      pstmt.setString(1, bookNo);
      pstmt.setString(2, bookName);
      pstmt.setString(3, bookAuthor);
      pstmt.setInt(4, bookPrice);
      pstmt.setString(5, bookDate);
      pstmt.setInt(6, bookStock);
      pstmt.setString(7, pubNo);

      //쿼리문 실행
      //insert, update, delete : pstmt.executeUpdate()
      //insert문은 반환되는 결과가 수행된 횟수 : 저장된 행 수 반환
      //필요없으면 저장하지 않아도 됌
      int reuslt = pstmt.executeUpdate();

      if (reuslt > 0) {
        System.out.println("도서 등록 성공");
      } else {
        System.out.println("도서 등록 실패");
      }

      //리소스 반환
      pstmt.close();
      conn.close();
      
    } catch (SQLException e) {
      e.printStackTrace();
    }

  }

}
