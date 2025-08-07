package game;

/**
 * 게임 객체를 생성하는 팩토리 클래스
 * 게임 생성을 중앙화하여 관리
 */
public class GameFactory {
    
    /**
     * 게임 타입 열거형
     */
    public enum GameType {
        GABABO,
        GUESS
    }
    
    /**
     * 게임 객체 생성
     * @param type 생성할 게임 타입
     * @return 생성된 게임 객체
     * @throws IllegalArgumentException 지원하지 않는 게임 타입인 경우
     */
    public static GameInterface createGame(GameType type) {
        switch (type) {
            case GABABO:
                return new GaBaBo();
            case GUESS:
                return new Guess();
            default:
                throw new IllegalArgumentException("지원하지 않는 게임 타입입니다: " + type);
        }
    }
    
    /**
     * 게임 이름으로 게임 객체 생성
     * @param gameName 게임 이름
     * @return 생성된 게임 객체
     * @throws IllegalArgumentException 지원하지 않는 게임 이름인 경우
     */
    public static GameInterface createGameByName(String gameName) {
        if (gameName == null || gameName.trim().isEmpty()) {
            throw new IllegalArgumentException("게임 이름이 유효하지 않습니다.");
        }
        
        if (gameName.equalsIgnoreCase("가위바위보") || 
            gameName.equalsIgnoreCase("가위바위보 게임") ||
            gameName.equalsIgnoreCase("gababo")) {
            return new GaBaBo();
        } else if (gameName.equalsIgnoreCase("숫자 알아맞히기") || 
                   gameName.equalsIgnoreCase("숫자 알아맞히기 게임") ||
                   gameName.equalsIgnoreCase("guess")) {
            return new Guess();
        } else {
            throw new IllegalArgumentException("지원하지 않는 게임 이름입니다: " + gameName);
        }
    }
}