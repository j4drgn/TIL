package start;

import exception.GameException;
import exception.SystemException;
import game.GameFactory;
import game.GameInterface;
import info.AppInfo;
import user.UserDAO;
import user.UserDAOImpl;
import user.UserDTO;
import user.UserSession;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 애플리케이션의 시작점과 메인 로직을 담당하는 클래스
 * 
 * 이 클래스는 프로그램의 진입점으로, 사용자 인터페이스와 전체 애플리케이션 흐름을 관리합니다.
 * 주요 기능:
 * - 시스템 초기화 (DAO, 세션 등)
 * - 메뉴 표시 및 사용자 입력 처리
 * - 예외 처리 및 오류 관리
 * - 게임 실행 및 사용자 관리 기능 연결
 */
public class AppStart {
    /** 사용자 데이터 접근 객체 */
    private static UserDAO userDAO;
    
    /** 사용자 세션 관리 객체 */
    private static UserSession userSession;
    
    /** 시스템 초기화 최대 재시도 횟수 */
    private static final int MAX_RETRY_COUNT = 3;
    
    /**
     * 애플리케이션 진입점
     * 
     * 프로그램의 메인 루프를 실행하고 전체 흐름을 제어합니다.
     * 시스템 초기화, 메뉴 표시, 사용자 입력 처리, 예외 처리 등을 담당합니다.
     * 
     * @param args 명령행 인자 (사용하지 않음)
     */
    public static void main(String[] args) {
        // 스캐너 객체 생성 (사용자 입력용)
        Scanner scanner = new Scanner(System.in);
        // 애플리케이션 정보 객체 생성
        AppInfo appInfo = new AppInfo();
        
        try {
            // 시스템 초기화 (DAO, 세션 등)
            initializeSystem();
            
            // 메인 프로그램 루프
            while (true) {
                try {
                    int choice;
                    
                    // 로그인 상태에 따라 다른 메뉴 표시
                    if (!userSession.isLoggedIn()) {
                        // 로그인되지 않은 상태 - 로그인 메뉴 표시
                        choice = MenuManager.displayLoginMenu(scanner);
                        if (processLoginMenuChoice(scanner, choice)) {
                            scanner.close();
                            return; // 종료 선택 시 프로그램 종료
                        }
                    } else {
                        // 로그인된 상태 - 메인 메뉴 표시
                        UserDTO currentUser = userSession.getCurrentUser();
                        choice = MenuManager.displayMainMenu(scanner, currentUser);
                        if (processMainMenuChoice(scanner, choice, appInfo)) {
                            scanner.close();
                            return; // 종료 선택 시 프로그램 종료
                        }
                    }
                } catch (InputMismatchException e) {
                    // 입력 타입 오류 처리 (예: 문자 입력 시)
                    System.out.println("잘못된 입력입니다. 숫자를 입력해주세요.");
                    MenuManager.clearInputBuffer(scanner);
                } catch (GameException e) {
                    // 게임 관련 예외 처리
                    System.out.println("게임 실행 중 오류가 발생했습니다: " + e.getMessage());
                    MenuManager.clearInputBuffer(scanner);
                } catch (SystemException.SessionTimeoutException e) {
                    // 세션 타임아웃 예외 처리
                    System.out.println(e.getMessage());
                    System.out.println("다시 로그인해주세요.");
                } catch (Exception e) {
                    // 기타 예외 처리
                    System.out.println("오류가 발생했습니다: " + e.getMessage());
                    e.printStackTrace(); // 디버깅을 위해 스택 트레이스 출력
                    MenuManager.clearInputBuffer(scanner);
                }
            }
        } catch (SystemException.OutOfMemoryException e) {
            // 메모리 부족 예외 처리
            System.out.println("시스템 리소스 부족: " + e.getMessage());
            System.out.println("프로그램을 종료합니다.");
        } catch (Exception e) {
            // 심각한 시스템 오류 처리
            System.out.println("심각한 오류가 발생했습니다: " + e.getMessage());
            e.printStackTrace(); // 디버깅을 위해 스택 트레이스 출력
            System.out.println("프로그램을 종료합니다.");
        } finally {
            // 리소스 정리
            scanner.close();
        }
    }
    
    /**
     * 시스템 초기화
     * 
     * UserDAO와 UserSession 객체를 초기화합니다.
     * 초기화 실패 시 최대 MAX_RETRY_COUNT 횟수만큼 재시도합니다.
     * 
     * @throws SystemException 시스템 초기화 실패 시 발생
     */
    private static void initializeSystem() throws SystemException {
        int retryCount = 0;
        boolean initialized = false;
        
        // 초기화 성공할 때까지 또는 최대 재시도 횟수에 도달할 때까지 반복
        while (!initialized && retryCount < MAX_RETRY_COUNT) {
            try {
                // DAO 및 세션 객체 초기화
                userDAO = UserDAOImpl.getInstance();
                userSession = UserSession.getInstance();
                initialized = true;
            } catch (Exception e) {
                // 초기화 실패 시 재시도 횟수 증가
                retryCount++;
                if (retryCount >= MAX_RETRY_COUNT) {
                    // 최대 재시도 횟수 초과 시 예외 발생
                    throw new SystemException("시스템 초기화 실패: " + e.getMessage(), e);
                }
                try {
                    // 1초 대기 후 재시도
                    Thread.sleep(1000);
                } catch (InterruptedException ie) {
                    // 인터럽트 발생 시 처리
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
    
    /**
     * 로그인 메뉴 선택 처리
     * 
     * 로그인 메뉴에서 사용자가 선택한 옵션에 따라 적절한 처리를 수행합니다.
     * 1: 로그인, 2: 회원가입, 3: 종료
     * 
     * @param scanner 사용자 입력을 위한 Scanner 객체
     * @param choice 사용자가 선택한 메뉴 번호
     * @return 프로그램 종료 여부 (true: 종료, false: 계속 실행)
     */
    private static boolean processLoginMenuChoice(Scanner scanner, int choice) {
        switch (choice) {
            case 1: // 로그인
                // UserManager를 통해 로그인 처리
                UserManager.login(scanner, userDAO, userSession);
                break;
            case 2: // 회원가입
                // UserManager를 통해 회원가입 처리
                UserManager.register(scanner, userDAO);
                break;
            case 3: // 종료
                System.out.println("프로그램을 종료합니다!");
                return true; // 프로그램 종료 신호 반환
            default: // 잘못된 선택
                System.out.println("잘못된 선택입니다. 다시 선택해주세요.");
                break;
        }
        return false; // 프로그램 계속 실행
    }
    
    /**
     * 메인 메뉴 선택 처리
     * 
     * 메인 메뉴에서 사용자가 선택한 옵션에 따라 적절한 처리를 수행합니다.
     * 
     * @param scanner 사용자 입력을 위한 Scanner 객체
     * @param choice 사용자가 선택한 메뉴 번호
     * @param appInfo 애플리케이션 정보 객체
     * @return 프로그램 종료 여부 (true: 종료, false: 계속 실행)
     * @throws GameException 게임 실행 중 오류 발생 시
     * @throws SystemException 시스템 관련 오류 발생 시
     */
    private static boolean processMainMenuChoice(Scanner scanner, int choice, AppInfo appInfo) 
            throws GameException, SystemException {
        switch (choice) {
            case 1: // 애플리케이션 정보
                // 애플리케이션 정보 표시
                appInfo.showAppInfo();
                // 사용자 키 입력 대기
                MenuManager.waitForKeyPress(scanner);
                break;
            case 2: // 가위바위보 게임
                // 가위바위보 게임 실행
                playGame(scanner, GameFactory.GameType.GABABO);
                break;
            case 3: // 숫자 알아맞히기 게임
                // 숫자 맞추기 게임 실행
                playGame(scanner, GameFactory.GameType.GUESS);
                break;
            case 4: // 회원 정보 수정
                // 회원 정보 수정 처리
                UserManager.updateUserInfo(scanner, userDAO, userSession);
                break;
            case 5: // 회원 탈퇴
                // 회원 탈퇴 처리
                if (UserManager.withdrawUser(scanner, userDAO, userSession)) {
                    System.out.println("회원 탈퇴가 완료되었습니다.");
                }
                break;
            case 6: // 로그아웃
                // 로그아웃 처리
                handleLogout();
                break;
            case 7: // 종료
                System.out.println("프로그램을 종료합니다!");
                return true; // 프로그램 종료 신호 반환
            default: // 잘못된 선택
                System.out.println("잘못된 선택입니다. 다시 선택해주세요.");
                break;
        }
        return false; // 프로그램 계속 실행
    }
    
    /**
     * 로그아웃 처리
     * 
     * 현재 로그인된 사용자의 로그아웃을 처리합니다.
     * 로그아웃 성공 메시지를 출력합니다.
     * 
     * @throws SystemException 세션 관련 오류 발생 시
     */
    private static void handleLogout() throws SystemException {
        // 현재 로그인된 사용자 이름 가져오기
        String userName = userSession.getCurrentUser().getName();
        // 로그아웃 처리
        userSession.logout();
        // 로그아웃 메시지 출력
        System.out.println(userName + "님, 로그아웃 되었습니다.");
    }
    
    /**
     * 게임 실행
     * 
     * 선택한 게임 타입에 따라 게임 객체를 생성하고 실행합니다.
     * GameFactory를 통해 게임 객체를 생성하고 play 메소드를 호출합니다.
     * 
     * @param scanner 사용자 입력을 위한 Scanner 객체
     * @param gameType 실행할 게임 타입 (GABABO, GUESS)
     * @throws GameException 게임 실행 중 오류 발생 시
     */
    private static void playGame(Scanner scanner, GameFactory.GameType gameType) throws GameException {
        // 게임 팩토리를 통해 게임 객체 생성
        GameInterface game = GameFactory.createGame(gameType);
        // 게임 실행
        game.play(scanner);
    }
}