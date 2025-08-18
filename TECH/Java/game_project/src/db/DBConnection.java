package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 데이터베이스 연결을 관리하는 클래스
 */
public class DBConnection {
    // 데이터베이스 연결 정보
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String USER = "PROJECTDB";
    private static final String PASSWORD = "1234";
    
    // 싱글톤 인스턴스
    private static DBConnection instance;
    
    // private 생성자
    private DBConnection() {
        try {
            // JDBC 드라이버 로드
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            System.out.println("Oracle JDBC 드라이버를 찾을 수 없습니다: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    // 인스턴스 반환 메소드
    public static DBConnection getInstance() {
        if (instance == null) {
            instance = new DBConnection();
        }
        return instance;
    }
    
    // 데이터베이스 연결 제공
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
    
    // 리소스 정리 메소드
    public static void closeResources(Connection conn, AutoCloseable stmt, AutoCloseable rs) {
        // ResultSet 닫기
        if (rs != null) {
            try {
                rs.close();
            } catch (Exception e) {
                System.out.println("ResultSet 닫기 실패: " + e.getMessage());
            }
        }
        
        // Statement 닫기
        if (stmt != null) {
            try {
                stmt.close();
            } catch (Exception e) {
                System.out.println("Statement 닫기 실패: " + e.getMessage());
            }
        }
        
        // Connection 닫기
        if (conn != null) {
            try {
                if (!conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException e) {
                System.out.println("Connection 닫기 실패: " + e.getMessage());
            }
        }
    }
}