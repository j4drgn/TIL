package jdbc.sec05;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnect {

  //데이터 베이스 연결 후
  //connection 객체를 반환하는 메소드
  public static Connection getConnection() {
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

  //자원반한 메소드 : close()
  //static으로 구성, 반환되는 자원에 따라 다르게 사용하도록 메소드 오버로딩

  //1. connection, preparedStatement, Resultset 자원 3개 반환
  public static void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
    try {
      if (rs != null) {
        rs.close();
        rs = null;
      }
      if (pstmt != null) {
        pstmt.close();
        pstmt = null;
      }
      if (conn != null) {
        conn.close();
        conn = null;
      }
    } catch (SQLException ex) {
      ex.printStackTrace();
    }
  }

  //2. connection, preparedStatement 자원 2 반환
  public static void close(Connection conn, PreparedStatement pstmt) {
    try {
      if (pstmt != null) {
        pstmt.close();
        pstmt = null;
      }
      if (conn != null) {
        conn.close();
        conn = null;
      }
    } catch (SQLException ex) {
      ex.printStackTrace();
    }
  }

  //3. connection 자원 1 반환
  public static void close(Connection conn) {
    try {
      if (conn != null) {
        conn.close();
        conn = null;
      }
    } catch (SQLException ex) {
      ex.printStackTrace();
    }
  }
}
