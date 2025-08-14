package jdbc.sec04;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * 도서 관리 프로그램 메인 클래스
 * BOOK 테이블에 대한 CRUD 작업 테스트
 */
public class BookMain {
    
    public static void main(String[] args) {
        // BookDAO 객체 생성
        BookDAO dao = new BookDAO();
        
        try {
            System.out.println("===== BOOK 테이블 CRUD 테스트 =====");
            
            // 현재 날짜 가져오기
            Date currentDate = new Date();
            
            // 1. INSERT 테스트
            System.out.println("\n1. 도서 정보 등록 테스트");
            BookDTO book1 = new BookDTO("B001", "자바 프로그래밍", "홍길동", "한빛미디어", 25000, currentDate);
            dao.insertBook(book1);
            
            // 2. SELECT 테스트 (전체 조회)
            System.out.println("\n2. 전체 도서 정보 조회 테스트");
            ArrayList<BookDTO> bookList = dao.selectAllBooks();
            displayBooks(bookList);
            
            // 3. SELECT 테스트 (개별 조회)
            System.out.println("\n3. 개별 도서 정보 조회 테스트");
            BookDTO foundBook = dao.selectBookByNo("B001");
            if (foundBook != null) {
                displayBook(foundBook);
            } else {
                System.out.println("도서를 찾을 수 없습니다.");
            }
            
            // 4. UPDATE 테스트
            System.out.println("\n4. 도서 정보 수정 테스트");
            foundBook.setBookPrice(30000);
            foundBook.setBookPublisher("영진출판사");
            dao.updateBook(foundBook);
            
            // 수정 결과 확인
            System.out.println("\n수정 후 도서 정보:");
            BookDTO updatedBook = dao.selectBookByNo("B001");
            if (updatedBook != null) {
                displayBook(updatedBook);
            }
            
            // 5. DELETE 테스트
            System.out.println("\n5. 도서 정보 삭제 테스트");
            dao.deleteBook("B001");
            
            // 삭제 결과 확인
            System.out.println("\n삭제 후 전체 도서 목록:");
            bookList = dao.selectAllBooks();
            displayBooks(bookList);
            
        } catch (Exception e) {
            System.out.println("테스트 중 오류 발생!");
            e.printStackTrace();
        } finally {
            // 데이터베이스 연결 종료
            dao.closeConnection();
            System.out.println("\n데이터베이스 연결 종료");
        }
    }
    
    /**
     * 도서 목록을 출력하는 메소드
     */
    private static void displayBooks(ArrayList<BookDTO> books) {
        if (books.isEmpty()) {
            System.out.println("도서 정보가 없습니다.");
            return;
        }
        
        System.out.println("도서번호\t도서명\t\t저자\t출판사\t\t가격\t출판일");
        System.out.println("--------------------------------------------------------");
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        for (BookDTO book : books) {
            System.out.printf("%s\t%s\t%s\t%s\t%d\t%s\n",
                    book.getBookNo(),
                    book.getBookName(),
                    book.getBookAuthor(),
                    book.getBookPublisher(),
                    book.getBookPrice(),
                    dateFormat.format(book.getBookDate()));
        }
    }
    
    /**
     * 개별 도서 정보를 출력하는 메소드
     */
    private static void displayBook(BookDTO book) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("도서번호: " + book.getBookNo());
        System.out.println("도서명: " + book.getBookName());
        System.out.println("저자: " + book.getBookAuthor());
        System.out.println("출판사: " + book.getBookPublisher());
        System.out.println("가격: " + book.getBookPrice());
        System.out.println("출판일: " + dateFormat.format(book.getBookDate()));
    }
}
