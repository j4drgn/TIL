package exception;

/**
 * 시스템 관련 예외 클래스
 */
public class SystemException extends Exception {
    
    /**
     * 기본 생성자
     */
    public SystemException() {
        super("시스템 오류가 발생했습니다.");
    }
    
    /**
     * 메시지를 지정하는 생성자
     * @param message 예외 메시지
     */
    public SystemException(String message) {
        super(message);
    }
    
    /**
     * 메시지와 원인을 지정하는 생성자
     * @param message 예외 메시지
     * @param cause 원인 예외
     */
    public SystemException(String message, Throwable cause) {
        super(message, cause);
    }
    
    /**
     * 메모리 부족 예외
     */
    public static class OutOfMemoryException extends SystemException {
        public OutOfMemoryException() {
            super("메모리가 부족합니다.");
        }
        
        public OutOfMemoryException(String message) {
            super(message);
        }
    }
    
    /**
     * 파일 시스템 예외
     */
    public static class FileSystemException extends SystemException {
        public FileSystemException(String message) {
            super("파일 시스템 오류: " + message);
        }
    }
    
    /**
     * 세션 타임아웃 예외
     */
    public static class SessionTimeoutException extends SystemException {
        public SessionTimeoutException() {
            super("세션이 만료되었습니다. 다시 로그인해주세요.");
        }
    }
}