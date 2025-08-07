package exception;

/**
 * 게임 관련 예외를 처리하는 기본 예외 클래스
 */
public class GameException extends Exception {
    
    /**
     * 기본 생성자
     */
    public GameException() {
        super("게임 실행 중 오류가 발생했습니다.");
    }
    
    /**
     * 메시지를 지정하는 생성자
     * @param message 예외 메시지
     */
    public GameException(String message) {
        super(message);
    }
    
    /**
     * 원인 예외를 지정하는 생성자
     * @param cause 원인 예외
     */
    public GameException(Throwable cause) {
        super("게임 실행 중 오류가 발생했습니다.", cause);
    }
    
    /**
     * 메시지와 원인 예외를 지정하는 생성자
     * @param message 예외 메시지
     * @param cause 원인 예외
     */
    public GameException(String message, Throwable cause) {
        super(message, cause);
    }
}