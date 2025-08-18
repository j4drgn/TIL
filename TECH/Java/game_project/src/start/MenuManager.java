package start;

import java.util.InputMismatchException;
import java.util.Scanner;
import user.UserDTO;

/**
 * 메뉴 표시 및 관리를 담당하는 클래스
 */
public class MenuManager {
    
    private static final String WELCOME_MESSAGE = "\n게임에 오신 것을 환영합니다!^^";
    private static final String DIVIDER = "**************************************";
    private static final String SUB_DIVIDER = "----------------------------------------";
    
    /**
     * 로그인 메뉴를 표시하고 사용자 선택을 반환
     * @param scanner 입력 스캐너
     * @return 사용자 선택
     * @throws InputMismatchException 잘못된 입력 시 예외 발생
     */
    public static int displayLoginMenu(Scanner scanner) throws InputMismatchException {
        System.out.println(WELCOME_MESSAGE);
        System.out.println(DIVIDER);
        System.out.println("로그인 메뉴");
        System.out.println(SUB_DIVIDER);
        System.out.println("1. 로그인");
        System.out.println("2. 회원가입");
        System.out.println("3. 종료");
        System.out.println(SUB_DIVIDER);
        System.out.print("메뉴 번호 입력: ");
        return scanner.nextInt();
    }
    
    /**
     * 메인 메뉴를 표시하고 사용자 선택을 반환
     * @param scanner 입력 스캐너
     * @param currentUser 현재 로그인된 사용자
     * @return 사용자 선택
     * @throws InputMismatchException 잘못된 입력 시 예외 발생
     */
    public static int displayMainMenu(Scanner scanner, UserDTO currentUser) throws InputMismatchException {
        System.out.println(WELCOME_MESSAGE);
        System.out.println(DIVIDER);
        System.out.println(currentUser.getName() + "님 환영합니다!");
        System.out.println("메뉴");
        System.out.println(SUB_DIVIDER);
        System.out.println("1. 애플리케이션 정보");
        System.out.println("2. 가위바위보 게임");
        System.out.println("3. 숫자 알아맞히기 게임");
        System.out.println("4. 회원 정보 수정");
        System.out.println("5. 회원 탈퇴");
        System.out.println("6. 로그아웃");
        System.out.println("7. 종료");
        System.out.println(SUB_DIVIDER);
        System.out.print("메뉴 번호 입력: ");
        return scanner.nextInt();
    }
    
    /**
     * 사용자 키 입력을 기다림
     * @param scanner 입력 스캐너
     */
    public static void waitForKeyPress(Scanner scanner) {
        scanner.nextLine(); // 버퍼 비우기
        System.out.println("\n계속하려면 아무 키나 누르세요...");
        scanner.nextLine();
    }
    
    /**
     * 입력 버퍼 비우기
     * @param scanner 입력 스캐너
     */
    public static void clearInputBuffer(Scanner scanner) {
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }
    }
}