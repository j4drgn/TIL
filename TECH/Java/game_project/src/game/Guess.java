package game;

import exception.GameException;
import exception.InputValidationException;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 * 숫자 맞추기 게임 클래스
 * 
 * Game 추상 클래스를 상속받아 숫자 맞추기 게임의 구체적인 로직을 구현합니다.
 * 컴퓨터가 생각한 1~10 사이의 숫자를 사용자가 맞추는 게임입니다.
 * 
 * 주요 기능:
 * - 난수 생성 및 사용자 입력 처리
 * - 정답 여부 판단 및 힌트 제공
 * - 시도 횟수 추적 및 힌트 제공
 * - 게임 반복 및 종료 처리
 */
public class Guess extends Game {
    /** 최소 숫자 범위 */
    private static final int MIN_NUMBER = 1;
    
    /** 최대 숫자 범위 */
    private static final int MAX_NUMBER = 10;
    
    /** 힌트 제공 전 최대 시도 횟수 */
    private static final int MAX_ATTEMPTS_BEFORE_HINT = 5;
    
    /**
     * 숫자 맞추기 게임 생성자
     * 
     * 부모 클래스인 Game의 생성자를 호출하여 게임 이름과 설명을 초기화합니다.
     */
    public Guess() {
        super("숫자 알아맞히기 게임", "어떤 숫자일까요? 맞아 맞혀보세요^^ (" + MIN_NUMBER + " ~ " + MAX_NUMBER + ")");
    }
    
    /**
     * 게임 실행 로직 구현
     * 
     * 숫자 맞추기 게임의 주요 로직을 구현합니다:
     * 1. 컴퓨터가 1~10 사이의 난수 생성
     * 2. 사용자에게 숫자 입력 요청
     * 3. 정답 여부 판단 및 힌트 제공
     * 4. 시도 횟수 추적 및 게임 계속 여부 확인
     * 
     * @param scanner 사용자 입력을 위한 Scanner 객체
     * @throws GameException 게임 실행 중 오류 발생 시
     */
    @Override
    protected void runGame(Scanner scanner) throws GameException {
        // 난수 생성기 초기화
        Random random = new Random();
        // 컴퓨터가 생각한 숫자 생성
        int targetNumber = generateRandomNumber(random);
        // 사용자 시도 횟수 초기화
        int attempts = 0;
        // 게임 진행 상태
        boolean playing = true;
        
        // 게임 메인 루프
        while (playing) {
            try {
                // 사용자 입력 요청
                System.out.print("숫자 입력: ");
                int guess = getUserGuess(scanner);
                // 시도 횟수 증가
                attempts++;
                
                // 구분선 출력
                GameUtils.printDivider();
                
                if (guess == targetNumber) {
                    // 정답을 맞춘 경우
                    playing = handleCorrectGuess(scanner, targetNumber, attempts);
                    if (playing) {
                        // 새 게임 시작 시 새로운 난수 생성 및 시도 횟수 초기화
                        targetNumber = generateRandomNumber(random);
                        attempts = 0;
                    }
                } else {
                    // 오답인 경우
                    playing = handleIncorrectGuess(targetNumber, guess);
                    
                    // 최대 시도 횟수 이상 시도한 경우 힌트 제공
                    if (playing && attempts >= MAX_ATTEMPTS_BEFORE_HINT) {
                        playing = offerHint(scanner, targetNumber);
                        if (playing) {
                            // 새 게임 시작 시 새로운 난수 생성 및 시도 횟수 초기화
                            targetNumber = generateRandomNumber(random);
                            attempts = 0;
                        }
                    }
                }
            } catch (InputValidationException e) {
                // 입력값 유효성 검증 실패 시 처리
                System.out.println(e.getMessage());
            } catch (InputMismatchException e) {
                // 입력 타입 오류 시 처리
                System.out.println("잘못된 입력입니다. 숫자를 입력해주세요.");
                GameUtils.clearInputBuffer(scanner);
            } catch (Exception e) {
                // 기타 예외 발생 시 GameException으로 래핑하여 상위로 전달
                throw new GameException("숫자 맞추기 게임 실행 중 오류가 발생했습니다: " + e.getMessage());
            }
        }
        
        // 게임 종료 처리
        endGame();
    }
    
    /**
     * 사용자 입력 받기
     * 
     * 사용자로부터 1-10 사이의 숫자를 입력받고 유효성을 검증합니다.
     * 유효하지 않은 입력이나 범위를 벗어난 값에 대해 예외를 발생시킵니다.
     * 
     * @param scanner 사용자 입력을 위한 Scanner 객체
     * @return 사용자가 입력한 숫자 (1-10)
     * @throws InputValidationException 유효하지 않은 입력값일 경우
     */
    private int getUserGuess(Scanner scanner) throws InputValidationException {
        try {
            // 사용자 입력 받기
            int guess = scanner.nextInt();
            
            // 입력값 범위 검증
            if (!GameUtils.isInRange(guess, MIN_NUMBER, MAX_NUMBER)) {
                throw new InputValidationException.NumberRangeException(MIN_NUMBER, MAX_NUMBER);
            }
            
            return guess;
        } catch (InputMismatchException e) {
            // 입력 버퍼 비우기
            GameUtils.clearInputBuffer(scanner);
            // 숫자가 아닌 값 입력 시 예외 발생
            throw new InputValidationException.InputTypeException("숫자");
        }
    }
    
    /**
     * 1부터 10까지의 난수 생성
     * 
     * MIN_NUMBER부터 MAX_NUMBER 사이의 난수를 생성합니다.
     * 
     * @param random 난수 생성기
     * @return 생성된 난수 (1-10)
     */
    private int generateRandomNumber(Random random) {
        // 0부터 MAX_NUMBER-1 사이의 난수에 MIN_NUMBER를 더하여 반환
        return random.nextInt(MAX_NUMBER) + MIN_NUMBER;
    }
    
    /**
     * 정답을 맞췄을 때 처리
     * 
     * 사용자가 정답을 맞췄을 때의 처리를 담당합니다.
     * 축하 메시지 출력 및 게임 계속 여부를 확인합니다.
     * 
     * @param scanner 사용자 입력을 위한 Scanner 객체
     * @param targetNumber 정답 숫자
     * @param attempts 시도 횟수
     * @return 게임 계속 진행 여부 (true: 계속, false: 종료)
     */
    private boolean handleCorrectGuess(Scanner scanner, int targetNumber, int attempts) {
        // 정답 메시지 출력
        System.out.println("정답입니다! " + attempts + "번 만에 맞추셨습니다!");
        System.out.println("나의 숫자는 " + targetNumber + "입니다");
        System.out.println("**************************************");
        
        // 게임 계속 여부 확인
        boolean continueGame = askToContinue(scanner, "다시 하시겠습니까? (y/n): ");
        
        // 게임을 계속하는 경우 새 게임 안내 메시지 출력
        if (continueGame) {
            GameUtils.printDivider();
            System.out.println("새로운 숫자를 생각했습니다. 맞혀보세요! (" + MIN_NUMBER + " ~ " + MAX_NUMBER + ")");
            GameUtils.printDivider();
        }
        
        return continueGame;
    }
    
    /**
     * 오답일 때 처리
     * 
     * 사용자가 오답을 입력했을 때의 처리를 담당합니다.
     * 입력값과 정답을 비교하여 적절한 힌트를 제공합니다.
     * 
     * @param targetNumber 정답 숫자
     * @param guess 사용자 입력값
     * @return 게임 계속 진행 여부 (항상 true 반환)
     */
    private boolean handleIncorrectGuess(int targetNumber, int guess) {
        // 입력값과 정답 비교하여 힌트 생성
        String hint = guess > targetNumber ? "더 작은 숫자입니다." : "더 큰 숫자입니다.";
        // 힌트 메시지 출력
        System.out.println("아닙니다. " + hint + " 다시 맞혀보세요.");
        // 게임 계속 진행
        return true;
    }
    
    /**
     * 힌트 제공 여부 확인
     * 
     * 최대 시도 횟수 이상 시도했을 때 정답을 보여줄지 확인합니다.
     * 사용자가 정답 보기를 원하면 정답을 공개하고 게임 계속 여부를 확인합니다.
     * 
     * @param scanner 사용자 입력을 위한 Scanner 객체
     * @param targetNumber 정답 숫자
     * @return 게임 계속 진행 여부
     */
    private boolean offerHint(Scanner scanner, int targetNumber) {
        // 힌트 제공 여부 확인
        System.out.print(MAX_ATTEMPTS_BEFORE_HINT + "번 이상 시도하셨습니다. 정답을 보시겠습니까? (y/n): ");
        String showAnswer = scanner.next();
        
        // 사용자가 정답 보기를 원하는 경우
        if (showAnswer.equalsIgnoreCase("y")) {
            // 정답 공개
            System.out.println("정답은 " + targetNumber + "입니다.");
            
            // 게임 계속 여부 확인
            boolean continueGame = askToContinue(scanner, "다시 하시겠습니까? (y/n): ");
            
            // 게임을 계속하는 경우 새 게임 안내 메시지 출력
            if (continueGame) {
                GameUtils.printDivider();
                System.out.println("새로운 숫자를 생각했습니다. 맞혀보세요! (" + MIN_NUMBER + " ~ " + MAX_NUMBER + ")");
                GameUtils.printDivider();
            }
            
            return continueGame;
        }
        
        // 정답 보기를 원하지 않는 경우 게임 계속 진행
        return true;
    }
}
