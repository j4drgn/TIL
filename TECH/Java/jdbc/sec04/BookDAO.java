package jdbc.sec04;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * 도서 데이터 액세스 객체(DAO) 클래스
 * BOOK 테이블에 대한 기본 CRUD 작업 수행
 */
public class BookDAO {
    
    // 필드
    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;
    
    // 생성자
    public BookDAO() {
        // 데이터베이스 연결
        try {
            // PrdDBConn 클래스 재사용
            PrdDBConn dbConn = new PrdDBConn();
            conn = dbConn.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * 새로운 도서 정보를 추가하는 메소드
     */
    public void insertBook(BookDTO book) {
        try {
            String sql = "INSERT INTO BOOK VALUES(?, ?, ?, ?, ?, ?)";
            
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, book.getBookNo());
            pstmt.setString(2, book.getBookName());
            pstmt.setString(3, book.getBookAuthor());
            pstmt.setString(4, book.getBookPublisher());
            pstmt.setInt(5, book.getBookPrice());
            pstmt.setDate(6, new Date(book.getBookDate().getTime()));
            
            int result = pstmt.executeUpdate();
            if (result > 0) {
                System.out.println("도서 등록 성공!");
            } else {
                System.out.println("도서 등록 실패!");
            }
            
        } catch (SQLException e) {
            System.out.println("도서 등록 실패!");
            e.printStackTrace();
        } finally {
            close();
        }
    }
    
    /**
     * 모든 도서 정보를 조회하는 메소드
     */
    public ArrayList<BookDTO> selectAllBooks() {
        ArrayList<BookDTO> bookList = new ArrayList<>();
        
        try {
            String sql = "SELECT * FROM BOOK ORDER BY bookNo";
            
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            
            while (rs.next()) {
                BookDTO book = new BookDTO();
                book.setBookNo(rs.getString("bookNo"));
                book.setBookName(rs.getString("bookName"));
                book.setBookAuthor(rs.getString("bookAuthor"));
                book.setBookPublisher(rs.getString("bookPublisher"));
                book.setBookPrice(rs.getInt("bookPrice"));
                book.setBookDate(rs.getDate("bookDate"));
                
                bookList.add(book);
            }
            
        } catch (SQLException e) {
            System.out.println("도서 조회 실패!");
            e.printStackTrace();
        } finally {
            close();
        }
        
        return bookList;
    }
    
    /**
     * 도서 번호로 특정 도서 정보를 조회하는 메소드
     */
    public BookDTO selectBookByNo(String bookNo) {
        BookDTO book = null;
        
        try {
            String sql = "SELECT * FROM BOOK WHERE bookNo = ?";
            
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, bookNo);
            rs = pstmt.executeQuery();
            
            if (rs.next()) {
                book = new BookDTO();
                book.setBookNo(rs.getString("bookNo"));
                book.setBookName(rs.getString("bookName"));
                book.setBookAuthor(rs.getString("bookAuthor"));
                book.setBookPublisher(rs.getString("bookPublisher"));
                book.setBookPrice(rs.getInt("bookPrice"));
                book.setBookDate(rs.getDate("bookDate"));
            }
            
        } catch (SQLException e) {
            System.out.println("도서 조회 실패!");
            e.printStackTrace();
        } finally {
            close();
        }
        
        return book;
    }
    
    /**
     * 도서 정보를 수정하는 메소드
     */
    public void updateBook(BookDTO book) {
        try {
            String sql = "UPDATE BOOK SET bookName=?, bookAuthor=?, bookPublisher=?, "
                    + "bookPrice=?, bookDate=? WHERE bookNo=?";
            
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, book.getBookName());
            pstmt.setString(2, book.getBookAuthor());
            pstmt.setString(3, book.getBookPublisher());
            pstmt.setInt(4, book.getBookPrice());
            pstmt.setDate(5, new Date(book.getBookDate().getTime()));
            pstmt.setString(6, book.getBookNo());
            
            int result = pstmt.executeUpdate();
            if (result > 0) {
                System.out.println("도서 정보 수정 성공!");
            } else {
                System.out.println("도서 정보 수정 실패!");
            }
            
        } catch (SQLException e) {
            System.out.println("도서 정보 수정 실패!");
            e.printStackTrace();
        } finally {
            close();
        }
    }
    
    /**
     * 도서 정보를 삭제하는 메소드
     */
    public void deleteBook(String bookNo) {
        try {
            String sql = "DELETE FROM BOOK WHERE bookNo=?";
            
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, bookNo);
            
            int result = pstmt.executeUpdate();
            if (result > 0) {
                System.out.println("도서 삭제 성공!");
            } else {
                System.out.println("도서 삭제 실패!");
            }
            
        } catch (SQLException e) {
            System.out.println("도서 삭제 실패!");
            e.printStackTrace();
        } finally {
            close();
        }
    }
    
    /**
     * 자원을 해제하는 메소드
     */
    private void close() {
        try {
            if (rs != null) rs.close();
            if (pstmt != null) pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * 데이터베이스 연결을 종료하는 메소드
     */
    public void closeConnection() {
        try {
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}