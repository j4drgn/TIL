package jdbc.sec04;

// JDBC 관련 라이브러리 임포트
import java.sql.Connection;  // DB 연결을 위한 인터페이스
import java.sql.ResultSet;   // SQL 쿼리 결과를 저장하는 객체
import java.sql.Statement;   // SQL 쿼리를 실행하기 위한 객체

/**
 * 상품 정보를 조회하는 메인 클래스
 */
public class ProductMain {

  public static void main(String[] args) {
    // DB 연결 객체 생성
    PrdDBConn prdDBConn = new PrdDBConn();
    // DB 연결 수행
    Connection conn = prdDBConn.getConnection();
    // SQL 문을 실행하기 위한 객체 선언
    Statement stmt = null;
    // 쿼리 결과를 저장할 객체 선언
    ResultSet rs = null;

    try {
      // Statement 객체 생성
      stmt = conn.createStatement();
      // 상품 테이블의 모든 데이터를 상품번호 순으로 조회하는 SQL 쿼리
      String sql = "select * from product order by PRDNO";
      // 쿼리 실행 및 결과 저장
      rs = stmt.executeQuery(sql);

      // 조회 결과 출력 시작
      System.out.println("-------------전체 상품 정보 조회-------------");
      System.out.println("상품번호 \t 상품명 \t\t 가격 \t 재고 \t 카테고리 \t 상태 \t 등록일");
      // ResultSet에서 다음 행이 있는 동안 반복
      while (rs.next()) {
        // 각 컬럼의 데이터 추출
        String productNo = rs.getString("PRDNO");       // 상품번호
        String productName = rs.getString("PRDNAME");   // 상품명
        int productPrice = rs.getInt("PRDPRICE");       // 상품가격
        String productMaker = rs.getString("PRDMAKER"); // 제조사
        String productColor = rs.getString("PRDCOLOR"); // 색상
        String ctgNo = rs.getString("CTGNO");           // 카테고리 번호
        
        // 한 행씩 형식에 맞게 출력
        // %-10s: 왼쪽 정렬된 문자열(10자리), %6d: 오른쪽 정렬된 정수(6자리)
        System.out.format("%-10s\t %-20s\t %6d \t %-10s\t %-10s\t %-10s\n",
            productNo, productName, productPrice, productMaker, productColor, ctgNo);
      }
    } catch (Exception e) {
      // 예외 발생 시 스택 트레이스 출력
      e.printStackTrace();
    } finally {
      try {
        // 사용한 자원 해제 (역순으로 해제)
        if (rs != null) {
          rs.close();  // ResultSet 자원 해제
        }
        if (stmt != null) {
          stmt.close();  // Statement 자원 해제
        }
        if (conn != null) {
          conn.close();  // Connection 자원 해제
        }
      } catch (Exception e) {
        // 자원 해제 중 예외 발생 시 스택 트레이스 출력
        e.printStackTrace();
      }
    }
  }
}


