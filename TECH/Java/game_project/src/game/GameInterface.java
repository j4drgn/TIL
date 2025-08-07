package game;

import exception.GameException;
import java.util.Scanner;

/**
 * 게임의 기본 인터페이스
 * 모든 게임은 이 인터페이스를 구현해야 함
 */
public interface GameInterface {
    /**
     * 게임 이름 반환
     * @return 게임 이름
     */
    String getGameName();
    
    /**
     * 게임 설명 반환
     * @return 게임 설명
     */
    String getGameDescription();
    
    /**
     * 게임 실행
     * @param scanner 입력 스캐너
     * @throws GameException 게임 실행 중 오류 발생 시
     */
    void play(Scanner scanner) throws GameException;
}