package game;

import java.util.Scanner;

/**
 * 게임 관련 유틸리티 클래스
 * 
 * 이 클래스는 게임 간에 공통으로 사용되는 유틸리티 메소드들을 제공합니다.
 * 모든 메소드는 정적(static)으로 구현되어 있어 인스턴스 생성 없이 사용할 수 있습니다.
 * 
 * 주요 기능:
 * - 사용자 입력 처리 (계속 여부 확인, 입력 버퍼 관리)
 * - 값 유효성 검증 (범위 확인)
 * - 화면 출력 유틸리티 (구분선 출력)
 */
public class GameUtils {
    
    /** 기본 구분선 길이 */
    private static final int DEFAULT_DIVIDER_LENGTH = 40;
    
    /**
     * 게임 계속 진행 여부 확인
     * 
     * 사용자에게 게임을 계속할지 물어보고 응답을 받습니다.
     * 'y' 또는 'Y' 입력 시 true를 반환합니다.
     * 
     * @param scanner 사용자 입력을 위한 Scanner 객체
     * @param message 사용자에게 표시할 메시지
     * @return 계속 진행 여부 (true: 계속, false: 종료)
     */
    public static boolean askToContinue(Scanner scanner, String message) {
        System.out.print(message);
        String continueGame = scanner.next();
        return continueGame.equalsIgnoreCase("y");
    }
    
    /**
     * 입력 버퍼 비우기
     * 
     * Scanner 객체의 입력 버퍼에 남아있는 내용을 비웁니다.
     * nextInt(), nextDouble() 등의 메소드 호출 후 nextLine()을 호출할 때
     * 발생할 수 있는 문제를 방지하기 위해 사용합니다.
     * 
     * @param scanner 입력 버퍼를 비울 Scanner 객체
     */
    public static void clearInputBuffer(Scanner scanner) {
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }
    }
    
    /**
     * 범위 내 숫자인지 확인
     * 
     * 주어진 값이 최소값과 최대값 사이에 있는지 확인합니다.
     * 최소값과 최대값을 포함합니다.
     * 
     * @param value 확인할 값
     * @param min 최소값 (포함)
     * @param max 최대값 (포함)
     * @return 범위 내 여부 (true: 범위 내, false: 범위 외)
     */
    public static boolean isInRange(int value, int min, int max) {
        return value >= min && value <= max;
    }
    
    /**
     * 구분선 출력
     * 
     * 지정된 길이의 구분선('-' 문자)을 화면에 출력합니다.
     * StringBuilder를 사용하여 효율적으로 문자열을 생성합니다.
     * 
     * @param length 구분선 길이
     */
    public static void printDivider(int length) {
        StringBuilder divider = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            divider.append('-');
        }
        System.out.println(divider.toString());
    }
    
    /**
     * 기본 구분선 출력
     * 
     * 기본 길이(40자)의 구분선을 화면에 출력합니다.
     * 매개변수 없이 간편하게 구분선을 출력할 수 있습니다.
     */
    public static void printDivider() {
        printDivider(DEFAULT_DIVIDER_LENGTH);
    }
}