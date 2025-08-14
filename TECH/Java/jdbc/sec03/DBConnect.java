package jdbc.sec03;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {

  //데이터 베이스 연결 후
  //connection 객체를 반환하는 메소드
  public Connection getConnection() {
    Connection conn = null;

    try {
      String url = "jdbc:oracle:thin:@localhost:1521:XE";
      String user = "USER_SELECT";
      String pwd = "1234";

      conn = DriverManager.getConnection(url, user, pwd);
      if (conn != null) {
        System.out.println("DB연결 성공!");

      } else {
        System.out.println("DB연결 실패!");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return conn;
  }

}
