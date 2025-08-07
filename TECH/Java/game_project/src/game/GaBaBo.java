package game;

import exception.GameException;
import exception.InputValidationException;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 * 가위바위보 게임
 * 
 * Game 추상 클래스 상속해서 가위바위보 게임 만든 클래스
 * 
 * 기능:
 * - 사용자 입력 받기
 * - 컴퓨터 랜덤 선택
 * - 승패 결정
 * - 게임 반복/종료
 */
public class GaBaBo extends Game {
    // 가위바위보 선택지
    private static final String[] CHOICES = {"가위", "바위", "보"};
    
    // 최소 번호
    private static final int MIN_CHOICE = 1;
    
    // 최대 번호
    private static final int MAX_CHOICE = 3;
    
    /**
     * 가위바위보 게임 생성자
     */
    public GaBaBo() {
        super("가위바위보 게임", "가위 바위 보 게임입니다.");
    }
    
    /**
     * 게임 실행 로직 구현
     * 
     * 가위바위보 게임의 주요 로직을 구현합니다:
     * 1. 사용자에게 선택지 표시 및 입력 요청
     * 2. 컴퓨터 선택 생성
     * 3. 양측 선택 표시 및 승패 결정
     * 4. 게임 계속 여부 확인
     * 
     * @param scanner 사용자 입력을 위한 Scanner 객체
     * @throws GameException 게임 실행 중 오류 발생 시
     */
    @Override
    protected void runGame(Scanner scanner) throws GameException {
        boolean playing = true;
        Random random = new Random();
        
        while (playing) {
            try {
                // 게임 선택지 안내
                System.out.println("가위 바위 보 게임: 1. 가위, 2. 바위, 3. 보");
                System.out.println("=========================");
                
                // 사용자 선택 입력 받기
                System.out.print("번호 입력: ");
                int userChoice = getUserChoice(scanner);
                
                // 사용자와 컴퓨터의 선택 결정
                String userHand = CHOICES[userChoice - 1];
                String computerHand = getComputerHand(random);
                
                // 선택 결과 표시 및 승패 결정
                displayChoices(userHand, computerHand);
                determineWinner(userHand, computerHand);
                
                // 게임 계속 진행 여부 확인
                playing = askToContinue(scanner, "계속하시겠습니까? (y/n): ");
            } catch (InputValidationException e) {
                // 입력값 유효성 검증 실패 시 처리
                System.out.println(e.getMessage());
            } catch (InputMismatchException e) {
                // 입력 타입 오류 시 처리
                System.out.println("잘못된 입력입니다. 숫자를 입력해주세요.");
                GameUtils.clearInputBuffer(scanner);
            } catch (Exception e) {
                // 기타 예외 발생 시 GameException으로 래핑하여 상위로 전달
                throw new GameException("가위바위보 게임 실행 중 오류가 발생했습니다: " + e.getMessage());
            }
        }
        
        // 게임 종료 처리
        endGame();
    }
    
    /**
     * 사용자 선택 입력 받기
     * 
     * 사용자로부터 1-3 사이의 숫자를 입력받고 유효성을 검증합니다.
     * 유효하지 않은 입력이나 범위를 벗어난 값에 대해 예외를 발생시킵니다.
     * 
     * @param scanner 사용자 입력을 위한 Scanner 객체
     * @return 사용자 선택 번호 (1-3)
     * @throws InputValidationException 유효하지 않은 입력값일 경우
     * @throws InputMismatchException 숫자가 아닌 값을 입력한 경우
     */
    private int getUserChoice(Scanner scanner) throws InputValidationException, InputMismatchException {
        int userChoice;
        try {
            // 사용자 입력 받기
            userChoice = scanner.nextInt();
            
            // 입력값 범위 검증
            if (!GameUtils.isInRange(userChoice, MIN_CHOICE, MAX_CHOICE)) {
                throw new InputValidationException.NumberRangeException(MIN_CHOICE, MAX_CHOICE);
            }
            
            return userChoice;
        } catch (InputMismatchException e) {
            // 숫자가 아닌 값 입력 시 예외 발생
            throw new InputValidationException.InputTypeException("숫자");
        }
    }
    
    /**
     * 컴퓨터의 선택 생성
     * 
     * 컴퓨터가 무작위로 가위, 바위, 보 중 하나를 선택합니다.
     * 
     * @param random 난수 생성기
     * @return 컴퓨터의 선택 (가위, 바위, 보 중 하나)
     */
    private String getComputerHand(Random random) {
        // 0부터 CHOICES.length-1 사이의 난수 생성 후 해당 인덱스의 선택지 반환
        return CHOICES[random.nextInt(CHOICES.length)];
    }
    
    /**
     * 사용자와 컴퓨터의 선택 표시
     * 
     * 사용자와 컴퓨터가 각각 선택한 결과를 화면에 출력합니다.
     * 
     * @param userHand 사용자 선택 (가위, 바위, 보 중 하나)
     * @param computerHand 컴퓨터 선택 (가위, 바위, 보 중 하나)
     */
    private void displayChoices(String userHand, String computerHand) {
        System.out.println("당신의 선택: " + userHand);
        System.out.println("컴퓨터의 선택: " + computerHand);
    }
    
    /**
     * 승패를 결정하고 결과를 출력
     * 
     * 가위바위보 규칙에 따라 사용자와 컴퓨터의 선택을 비교하여 승패를 결정하고,
     * 결과를 화면에 출력합니다.
     * 
     * 승패 규칙:
     * - 같은 것을 선택한 경우: 비김
     * - 가위 vs 보, 바위 vs 가위, 보 vs 바위: 사용자 승리
     * - 그 외의 경우: 컴퓨터 승리
     * 
     * @param userHand 사용자 선택 (가위, 바위, 보 중 하나)
     * @param computerHand 컴퓨터 선택 (가위, 바위, 보 중 하나)
     */
    private void determineWinner(String userHand, String computerHand) {
        if (userHand.equals(computerHand)) {
            // 같은 것을 선택한 경우: 비김
            System.out.println("비겼습니다!");
        } else if ((userHand.equals("가위") && computerHand.equals("보")) || 
                   (userHand.equals("바위") && computerHand.equals("가위")) || 
                   (userHand.equals("보") && computerHand.equals("바위"))) {
            // 사용자가 이기는 경우
            System.out.println("당신이 이겼습니다!");
        } else {
            // 컴퓨터가 이기는 경우
            System.out.println("컴퓨터가 이겼습니다!");
        }
    }
}
