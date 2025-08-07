package start;

import exception.UserException;
import java.util.Scanner;
import user.UserDAO;
import user.UserDTO;
import user.UserSession;

/**
 * 사용자 관리 기능을 담당하는 클래스
 */
public class UserManager {
    
    private static final String DIVIDER = "----------------------------------------";
    
    /**
     * 사용자 로그인 처리
     * @param scanner 입력 스캐너
     * @param userDAO 사용자 데이터 접근 객체
     * @param userSession 사용자 세션 관리 객체
     */
    public static void login(Scanner scanner, UserDAO userDAO, UserSession userSession) {
        MenuManager.clearInputBuffer(scanner); // 버퍼 비우기
        System.out.println("\n로그인");
        System.out.println(DIVIDER);
        
        try {
            System.out.print("아이디: ");
            String id = scanner.nextLine();
            
            System.out.print("비밀번호: ");
            String password = scanner.nextLine();
            
            validateLoginInput(id, password);
            
            UserDTO user = userDAO.login(id, password);
            userSession.login(user);
            System.out.println(user.getName() + "님, 환영합니다!");
        } catch (UserException.LoginFailedException e) {
            System.out.println("아이디 또는 비밀번호가 일치하지 않습니다.");
        } catch (UserException.RequiredFieldMissingException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("로그인 중 오류가 발생했습니다: " + e.getMessage());
        }
    }
    
    /**
     * 회원가입 처리
     * @param scanner 입력 스캐너
     * @param userDAO 사용자 데이터 접근 객체
     */
    public static void register(Scanner scanner, UserDAO userDAO) {
        MenuManager.clearInputBuffer(scanner); // 버퍼 비우기
        System.out.println("\n회원가입");
        System.out.println(DIVIDER);
        
        try {
            System.out.print("아이디: ");
            String id = scanner.nextLine();
            
            System.out.print("비밀번호: ");
            String password = scanner.nextLine();
            
            System.out.print("이름: ");
            String name = scanner.nextLine();
            
            validateRegistrationInput(id, password, name);
            
            UserDTO newUser = new UserDTO(id, password, name);
            if (userDAO.saveUser(newUser)) {
                System.out.println("회원가입이 완료되었습니다. 로그인해주세요.");
            }
        } catch (UserException.DuplicateIdException e) {
            System.out.println("이미 사용 중인 아이디입니다.");
        } catch (UserException.RequiredFieldMissingException e) {
            System.out.println(e.getMessage());
        } catch (UserException.RegistrationFailedException e) {
            System.out.println("회원가입에 실패했습니다: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("회원가입 중 오류가 발생했습니다: " + e.getMessage());
        }
    }
    
    /**
     * 로그인 입력 유효성 검증
     * @param id 사용자 아이디
     * @param password 비밀번호
     * @throws UserException.RequiredFieldMissingException 필수 필드 누락 시
     */
    private static void validateLoginInput(String id, String password) throws UserException.RequiredFieldMissingException {
        if (id == null || id.trim().isEmpty()) {
            throw new UserException.RequiredFieldMissingException("아이디");
        }
        
        if (password == null || password.trim().isEmpty()) {
            throw new UserException.RequiredFieldMissingException("비밀번호");
        }
    }
    
    /**
     * 회원가입 입력 유효성 검증
     * @param id 사용자 아이디
     * @param password 비밀번호
     * @param name 이름
     * @throws UserException.RequiredFieldMissingException 필수 필드 누락 시
     */
    private static void validateRegistrationInput(String id, String password, String name) 
            throws UserException.RequiredFieldMissingException {
        validateLoginInput(id, password);
        
        if (name == null || name.trim().isEmpty()) {
            throw new UserException.RequiredFieldMissingException("이름");
        }
    }
}