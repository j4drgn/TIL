package user;

import exception.SystemException;

/**
 * 사용자 세션 관리 클래스
 * 
 * 로그인한 유저 정보를 저장하고 관리함
 */
public class UserSession {
    // 싱글톤 객체
    private static UserSession instance;
    
    // 현재 로그인한 유저
    private UserDTO currentUser;
    
    // 마지막 활동 시간
    private long lastActivityTime;
    
    // 세션 타임아웃 시간 (30분)
    private static final long SESSION_TIMEOUT = 30 * 60 * 1000;
    
    // private 생성자
    private UserSession() {
        updateLastActivityTime();
    }
    
    /**
     * UserSession 객체 가져오기
     */
    public static UserSession getInstance() throws SystemException {
        if (instance == null) {
            instance = new UserSession();
        }
        return instance;
    }
    
    /**
     * 현재 로그인한 유저 정보 가져오기
     */
    public UserDTO getCurrentUser() throws SystemException {
        // 세션 시간 지났는지 확인
        if (checkSessionTimeout()) {
            throw new SystemException.SessionTimeoutException();
        }
        return currentUser;
    }
    
    /**
     * 로그인하기
     */
    public boolean login(UserDTO user) {
        if (user != null) {
            // 유저 정보 저장하고 시간 갱신
            this.currentUser = user;
            updateLastActivityTime();
            return true;
        }
        return false;
    }
    
    /**
     * 로그아웃하기
     */
    public void logout() {
        this.currentUser = null;
    }
    
    /**
     * 로그인 했는지 확인
     */
    public boolean isLoggedIn() {
        // 세션 시간 체크하고 유저 있는지 확인
        checkSessionTimeout();
        return currentUser != null;
    }
    
    /**
     * 마지막 활동 시간 업데이트
     */
    public void updateLastActivityTime() {
        this.lastActivityTime = System.currentTimeMillis();
    }
    
    /**
     * 세션 시간 지났는지 체크
     */
    private boolean checkSessionTimeout() {
        boolean isTimeout = false;
        
        // 로그인 했는데 시간 지났으면
        if (currentUser != null && 
            System.currentTimeMillis() - lastActivityTime > SESSION_TIMEOUT) {
            // 자동으로 로그아웃 시키기
            logout();
            isTimeout = true;
        }
        
        // 로그인 했으면 시간 갱신
        if (currentUser != null) {
            updateLastActivityTime();
        }
        
        return isTimeout;
    }
}