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
     */
    public static void login(Scanner scanner, UserDAO userDAO, UserSession userSession) {
        // 버퍼 비우기
        MenuManager.clearInputBuffer(scanner);
        System.out.println("\n로그인");
        System.out.println(DIVIDER);
        
        try {
            // 사용자 입력 받기
            System.out.print("아이디: ");
            String id = scanner.nextLine();
            
            System.out.print("비밀번호: ");
            String password = scanner.nextLine();
            
            // 입력값 검증
            if (id == null || id.trim().isEmpty()) {
                System.out.println("아이디를 입력해주세요.");
                return;
            }
            
            if (password == null || password.trim().isEmpty()) {
                System.out.println("비밀번호를 입력해주세요.");
                return;
            }
            
            // 로그인 처리
            UserDTO user = userDAO.login(id, password);
            userSession.login(user);
            System.out.println(user.getName() + "님, 환영합니다!");
        } catch (UserException.LoginFailedException e) {
            System.out.println("아이디 또는 비밀번호가 일치하지 않습니다.");
        } catch (Exception e) {
            System.out.println("로그인 중 오류가 발생했습니다: " + e.getMessage());
        }
    }
    
    /**
     * 회원가입 처리
     */
    public static void register(Scanner scanner, UserDAO userDAO) {
        // 버퍼 비우기
        MenuManager.clearInputBuffer(scanner);
        System.out.println("\n회원가입");
        System.out.println(DIVIDER);
        
        try {
            // 사용자 입력 받기
            System.out.print("아이디: ");
            String id = scanner.nextLine();
            
            System.out.print("비밀번호: ");
            String password = scanner.nextLine();
            
            System.out.print("이름: ");
            String name = scanner.nextLine();
            
            // 입력값 검증
            if (id == null || id.trim().isEmpty()) {
                System.out.println("아이디를 입력해주세요.");
                return;
            }
            
            if (password == null || password.trim().isEmpty()) {
                System.out.println("비밀번호를 입력해주세요.");
                return;
            }
            
            if (name == null || name.trim().isEmpty()) {
                System.out.println("이름을 입력해주세요.");
                return;
            }
            
            // 회원가입 처리
            UserDTO newUser = new UserDTO(id, password, name);
            if (userDAO.saveUser(newUser)) {
                System.out.println("회원가입이 완료되었습니다. 로그인해주세요.");
            }
        } catch (UserException.DuplicateIdException e) {
            System.out.println("이미 사용 중인 아이디입니다.");
        } catch (Exception e) {
            System.out.println("회원가입 중 오류가 발생했습니다: " + e.getMessage());
        }
    }
    
    /**
     * 회원 정보 수정
     */
    public static void updateUserInfo(Scanner scanner, UserDAO userDAO, UserSession userSession) {
        // 버퍼 비우기
        MenuManager.clearInputBuffer(scanner);
        System.out.println("\n비밀번호 변경");
        System.out.println(DIVIDER);
        
        try {
            // 로그인 상태 확인
            UserDTO currentUser = userSession.getCurrentUser();
            if (currentUser == null) {
                System.out.println("로그인 후 이용 가능합니다.");
                return;
            }
            
            // 현재 정보 표시
            System.out.println("현재 사용자: " + currentUser.getId() + " (" + currentUser.getName() + ")");
            
            // 현재 비밀번호 확인
            System.out.print("현재 비밀번호: ");
            String currentPassword = scanner.nextLine();
            
            if (!currentPassword.equals(currentUser.getPassword())) {
                System.out.println("비밀번호가 일치하지 않습니다.");
                return;
            }
            
            // 새 비밀번호 입력
            System.out.print("새 비밀번호: ");
            String newPassword = scanner.nextLine();
            
            if (newPassword == null || newPassword.trim().isEmpty()) {
                System.out.println("새 비밀번호를 입력해주세요.");
                return;
            }
            
            // 비밀번호 변경 처리
            UserDTO updatedUser = new UserDTO();
            updatedUser.setId(currentUser.getId());
            updatedUser.setPassword(newPassword);
            
            if (userDAO.updateUser(updatedUser)) {
                System.out.println("비밀번호가 변경되었습니다.");
                
                // 세션 정보 업데이트
                UserDTO refreshedUser = userDAO.findUserById(currentUser.getId());
                if (refreshedUser != null) {
                    userSession.login(refreshedUser);
                }
            } else {
                System.out.println("비밀번호 변경에 실패했습니다.");
            }
        } catch (Exception e) {
            System.out.println("비밀번호 변경 중 오류가 발생했습니다: " + e.getMessage());
        }
    }
    
    /**
     * 회원 탈퇴 처리
     */
    public static boolean withdrawUser(Scanner scanner, UserDAO userDAO, UserSession userSession) {
        // 버퍼 비우기
        MenuManager.clearInputBuffer(scanner);
        System.out.println("\n회원 탈퇴");
        System.out.println(DIVIDER);
        
        try {
            // 로그인 상태 확인
            UserDTO currentUser = userSession.getCurrentUser();
            if (currentUser == null) {
                System.out.println("로그인 후 이용 가능합니다.");
                return false;
            }
            
            // 탈퇴 확인
            System.out.print("정말 탈퇴하시겠습니까? (y/n): ");
            String confirm = scanner.nextLine();
            
            if (!confirm.equalsIgnoreCase("y")) {
                System.out.println("탈퇴가 취소되었습니다.");
                return false;
            }
            
            // 비밀번호 확인
            System.out.print("비밀번호 확인: ");
            String password = scanner.nextLine();
            
            if (!password.equals(currentUser.getPassword())) {
                System.out.println("비밀번호가 일치하지 않습니다.");
                return false;
            }
            
            // 탈퇴 처리
            if (userDAO.withdrawUser(currentUser.getId())) {
                System.out.println("회원 탈퇴가 완료되었습니다.");
                userSession.logout();
                return true;
            } else {
                System.out.println("회원 탈퇴에 실패했습니다.");
                return false;
            }
        } catch (Exception e) {
            System.out.println("회원 탈퇴 중 오류가 발생했습니다: " + e.getMessage());
            return false;
        }
    }
}