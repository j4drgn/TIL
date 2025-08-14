package jdbc.sec04;

// JDBC 관련 라이브러리 임포트
import java.sql.Connection;     // DB 연결을 위한 인터페이스
import java.sql.DriverManager;  // DB 드라이버 관리 클래스

/**
 * 상품 테이블 관련 데이터베이스 연결 클래스
 */
public class PrdDBConn {

  /**
   * 데이터베이스 연결을 수행하고 Connection 객체를 반환하는 메소드
   * @return Connection 데이터베이스 연결 객체
   */
  public Connection getConnection() {
    // Connection 객체 초기화
    Connection conn = null;

    try {
      // 데이터베이스 연결 정보 설정
      String url = "jdbc:oracle:thin:@localhost:1521:XE";  // Oracle DB 연결 URL
      String user = "SQL_USER";  // 데이터베이스 사용자 이름
      String pwd = "1234";       // 데이터베이스 비밀번호

      // DriverManager를 통해 데이터베이스 연결 시도
      conn = DriverManager.getConnection(url, user, pwd);
      // 연결 상태 확인 및 메시지 출력
      if (conn != null) {
        System.out.println("DB 연결 성공!");
      } else {
        System.out.println("DB 연결 실패!");
      }

    } catch (Exception e) {
      // 연결 실패 시 예외 처리
      System.out.println("연결 실패 예외 발생");
      e.printStackTrace();
    }
    // 연결된 Connection 객체 반환
    return conn;
  }

}
