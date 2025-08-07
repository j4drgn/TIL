package exception;

/**
 * 사용자 관련 예외를 처리하는 예외 클래스
 */
public class UserException extends GameException {
    
    /**
     * 기본 생성자
     */
    public UserException() {
        super("사용자 처리 중 오류가 발생했습니다.");
    }
    
    /**
     * 메시지를 지정하는 생성자
     * @param message 예외 메시지
     */
    public UserException(String message) {
        super(message);
    }
    
    /**
     * 원인 예외를 지정하는 생성자
     * @param cause 원인 예외
     */
    public UserException(Throwable cause) {
        super("사용자 처리 중 오류가 발생했습니다.", cause);
    }
    
    /**
     * 메시지와 원인 예외를 지정하는 생성자
     * @param message 예외 메시지
     * @param cause 원인 예외
     */
    public UserException(String message, Throwable cause) {
        super(message, cause);
    }
    
    /**
     * 로그인 실패 예외
     */
    public static class LoginFailedException extends UserException {
        public LoginFailedException() {
            super("로그인에 실패했습니다. 아이디 또는 비밀번호를 확인해주세요.");
        }
    }
    
    /**
     * 회원가입 실패 예외
     */
    public static class RegistrationFailedException extends UserException {
        public RegistrationFailedException() {
            super("회원가입에 실패했습니다.");
        }
        
        public RegistrationFailedException(String message) {
            super(message);
        }
    }
    
    /**
     * 중복 ID 예외
     */
    public static class DuplicateIdException extends UserException {
        public DuplicateIdException() {
            super("이미 사용 중인 아이디입니다.");
        }
    }
    
    /**
     * 필수 입력 누락 예외
     */
    public static class RequiredFieldMissingException extends UserException {
        public RequiredFieldMissingException(String fieldName) {
            super(fieldName + "은(는) 필수 입력 항목입니다.");
        }
    }
}