package exception;

/**
 * 입력 유효성 검증 관련 예외 클래스
 */
public class InputValidationException extends GameException {
    
    /**
     * 기본 생성자
     */
    public InputValidationException() {
        super("입력값이 유효하지 않습니다.");
    }
    
    /**
     * 메시지를 지정하는 생성자
     * @param message 예외 메시지
     */
    public InputValidationException(String message) {
        super(message);
    }
    
    /**
     * 숫자 범위 오류 예외
     */
    public static class NumberRangeException extends InputValidationException {
        public NumberRangeException(int min, int max) {
            super(min + "부터 " + max + " 사이의 숫자를 입력해주세요.");
        }
    }
    
    /**
     * 입력 타입 오류 예외
     */
    public static class InputTypeException extends InputValidationException {
        public InputTypeException() {
            super("잘못된 입력 타입입니다.");
        }
        
        public InputTypeException(String expectedType) {
            super("잘못된 입력 타입입니다. " + expectedType + " 형식으로 입력해주세요.");
        }
    }
    
    /**
     * 필수 입력 누락 예외
     */
    public static class RequiredInputException extends InputValidationException {
        public RequiredInputException(String fieldName) {
            super(fieldName + "은(는) 필수 입력 항목입니다.");
        }
    }
}