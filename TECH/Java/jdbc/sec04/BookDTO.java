package jdbc.sec04;

import java.util.Date;

/**
 * 도서 정보를 담는 Data Transfer Object 클래스
 */
public class BookDTO {
    // 필드 정의
    private String bookNo;       // 도서 번호
    private String bookName;     // 도서명
    private String bookAuthor;   // 저자
    private String bookPublisher;// 출판사
    private int bookPrice;       // 가격
    private Date bookDate;       // 출판일
    
    // 기본 생성자
    public BookDTO() {
    }
    
    // 모든 필드를 초기화하는 생성자
    public BookDTO(String bookNo, String bookName, String bookAuthor, String bookPublisher, int bookPrice, Date bookDate) {
        this.bookNo = bookNo;
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.bookPublisher = bookPublisher;
        this.bookPrice = bookPrice;
        this.bookDate = bookDate;
    }
    
    // Getter와 Setter 메소드
    public String getBookNo() {
        return bookNo;
    }
    
    public void setBookNo(String bookNo) {
        this.bookNo = bookNo;
    }
    
    public String getBookName() {
        return bookName;
    }
    
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
    
    public String getBookAuthor() {
        return bookAuthor;
    }
    
    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }
    
    public String getBookPublisher() {
        return bookPublisher;
    }
    
    public void setBookPublisher(String bookPublisher) {
        this.bookPublisher = bookPublisher;
    }
    
    public int getBookPrice() {
        return bookPrice;
    }
    
    public void setBookPrice(int bookPrice) {
        this.bookPrice = bookPrice;
    }
    
    public Date getBookDate() {
        return bookDate;
    }
    
    public void setBookDate(Date bookDate) {
        this.bookDate = bookDate;
    }
}