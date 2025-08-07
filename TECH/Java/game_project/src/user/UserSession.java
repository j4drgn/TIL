package user;

import exception.SystemException;

/**
 * 사용자 세션 관리 클래스
 * 
 * 로그인한 유저 정보 저장하고 세션 관리함
 * 싱글톤으로 만들어서 프로그램 전체에서 하나만 씀
 * 
 * 기능:
 * - 로그인/로그아웃
 * - 현재 유저 정보
 * - 세션 시간 체크
 * - 최대 세션 수 제한
 */
public class UserSession {
    // 싱글톤 객체 (volatile로 스레드 안전하게)
    private static volatile UserSession instance;
    
    // 현재 로그인한 유저
    private UserDTO currentUser;
    
    // 마지막으로 뭔가 한 시간
    private long lastActivityTime;
    
    // 세션 타임아웃 시간 (30분)
    private static final long SESSION_TIMEOUT = 30 * 60 * 1000;
    
    // 최대 세션 수
    private static final int MAX_SESSIONS = 100;
    
    // 지금 활성화된 세션 수
    private static int activeSessions = 0;
    
    // 생성자 - private으로 해서 외부에서 못 만들게 함
    private UserSession() {
        updateLastActivityTime();
    }
    
    /**
     * UserSession 객체 가져오기 (스레드 안전한 싱글톤)
     * 
     * @return UserSession 객체
     * @throws SystemException.OutOfMemoryException 세션 너무 많으면 에러
     */
    public static UserSession getInstance() throws SystemException {
        // 없으면 만들기
        if (instance == null) {
            // 동기화 블록 (한번에 하나의 스레드만)
            synchronized (UserSession.class) {
                // 한번 더 체크 (다른 스레드가 만들었을 수도 있음)
                if (instance == null) {
                    // 세션 너무 많은지 체크
                    if (activeSessions >= MAX_SESSIONS) {
                        throw new SystemException.OutOfMemoryException("세션이 너무 많아요! 나중에 다시 시도해주세요.");
                    }
                    // 새로 만들고 카운트 증가
                    instance = new UserSession();
                    activeSessions++;
                }
            }
        }
        return instance;
    }
    
    /**
     * 현재 로그인한 유저 정보 가져오기
     * 
     * @return 유저 정보 (없으면 null)
     * @throws SystemException.SessionTimeoutException 세션 시간 지났을 때
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
     * 
     * @param user 유저 정보
     * @return 성공하면 true, 실패하면 false
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
     * 
     * @return 로그인 했으면 true, 아니면 false
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
     * 
     * @return 시간 지났으면 true, 아니면 false
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
    
    /**
     * 현재 활성화된 세션 수 가져오기
     * 
     * @return 세션 수
     */
    public static int getActiveSessions() {
        return activeSessions;
    }
    
    /**
     * 객체 소멸될 때 세션 수 감소
     */
    @Override
    protected void finalize() {
        synchronized (UserSession.class) {
            activeSessions--;
        }
    }
}