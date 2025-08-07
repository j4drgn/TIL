package game;

import exception.GameException;
import java.util.Scanner;

/**
 * 게임의 기본 기능을 정의하는 추상 클래스
 * 
 * 이 추상 클래스는 GameInterface를 구현하고 모든 게임에 공통적인 기능을 제공합니다.
 * 템플릿 메소드 패턴을 사용하여 게임의 기본 흐름을 정의하고,
 * 하위 클래스에서 구체적인 게임 로직을 구현할 수 있도록 합니다.
 * 
 * 주요 기능:
 * - 게임 정보 관리 (이름, 설명)
 * - 게임 실행 흐름 제어 (시작, 진행, 종료)
 * - 사용자 입력 처리 공통 기능
 */
public abstract class Game implements GameInterface {
    /** 게임 이름 */
    protected String gameName;
    
    /** 게임 설명 */
    protected String gameDescription;
    
    /** 구분선 길이 */
    protected static final int DIVIDER_LENGTH = 40;
    
    /**
     * 게임 생성자
     * 
     * 게임 이름과 설명을 초기화합니다.
     * 
     * @param gameName 게임 이름
     * @param gameDescription 게임 설명
     */
    public Game(String gameName, String gameDescription) {
        this.gameName = gameName;
        this.gameDescription = gameDescription;
    }
    
    /**
     * 게임 이름 반환 (인터페이스 구현)
     * 
     * @return 게임 이름
     */
    @Override
    public String getGameName() {
        return gameName;
    }
    
    /**
     * 게임 설명 반환 (인터페이스 구현)
     * 
     * @return 게임 설명
     */
    @Override
    public String getGameDescription() {
        return gameDescription;
    }
    
    /**
     * 게임 실행 (인터페이스 구현)
     * 
     * 템플릿 메소드 패턴을 사용하여 게임의 기본 흐름을 정의합니다.
     * 1. 게임 정보 표시
     * 2. 게임 실행 로직 호출 (하위 클래스에서 구현)
     * 
     * @param scanner 사용자 입력을 위한 Scanner 객체
     * @throws GameException 게임 실행 중 오류 발생 시
     */
    @Override
    public void play(Scanner scanner) throws GameException {
        // 게임 정보 표시
        displayGameInfo();
        // 게임 실행 (하위 클래스에서 구현)
        runGame(scanner);
    }
    
    /**
     * 게임 정보 표시
     * 
     * 게임 이름과 설명을 화면에 출력합니다.
     */
    protected void displayGameInfo() {
        System.out.println("**************************************");
        System.out.println(gameName);
        GameUtils.printDivider(); // 구분선 출력
        System.out.println(gameDescription);
        System.out.println("**************************************");
    }
    
    /**
     * 게임 실행 로직 (각 게임에서 구현)
     * 
     * 각 게임의 고유한 실행 로직을 구현하는 추상 메소드입니다.
     * 하위 클래스에서 반드시 구현해야 합니다.
     * 
     * @param scanner 사용자 입력을 위한 Scanner 객체
     * @throws GameException 게임 실행 중 오류 발생 시
     */
    protected abstract void runGame(Scanner scanner) throws GameException;
    
    /**
     * 게임 종료 처리
     * 
     * 게임 종료 메시지를 출력하고 메뉴로 돌아갑니다.
     */
    protected void endGame() {
        System.out.println("게임을 종료합니다.");
        System.out.println("메뉴로 돌아갑니다.");
    }
    
    /**
     * 게임 계속 진행 여부 확인
     * 
     * 사용자에게 게임을 계속할지 묻고 응답을 받습니다.
     * GameUtils 클래스의 공통 기능을 활용합니다.
     * 
     * @param scanner 사용자 입력을 위한 Scanner 객체
     * @param message 사용자에게 표시할 메시지
     * @return 계속 진행 여부 (true: 계속, false: 종료)
     */
    protected boolean askToContinue(Scanner scanner, String message) {
        return GameUtils.askToContinue(scanner, message);
    }
}