package user;

import exception.UserException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * UserDAO 인터페이스 구현체
 * 
 * 사용자 정보를 메모리 내 컬렉션(HashMap)에 저장하고 관리합니다.
 * 싱글톤 패턴을 적용하여 애플리케이션 전체에서 하나의 인스턴스만 사용합니다.
 * 
 * 주요 기능:
 * - 사용자 정보 저장 및 유효성 검증
 * - ID를 통한 사용자 정보 빠른 조회 (O(1) 시간 복잡도)
 * - 로그인 처리 및 인증
 * - 전체 사용자 목록 조회
 */
public class UserDAOImpl implements UserDAO {
    /** 
     * 사용자 정보를 저장할 컬렉션 
     * HashMap을 사용하여 ID 기반 조회 시 O(1) 시간 복잡도로 성능 최적화
     */
    private Map<String, UserDTO> userMap;
    
    /** 
     * 싱글톤 인스턴스 
     * volatile 키워드를 사용하여 멀티스레드 환경에서 안전하게 접근 가능
     */
    private static volatile UserDAOImpl instance;
    
    /**
     * 생성자 (private으로 외부 생성 방지)
     * 
     * 싱글톤 패턴 구현을 위해 private으로 선언하여 외부에서 인스턴스 생성을 방지합니다.
     */
    private UserDAOImpl() {
        userMap = new HashMap<>();
    }
    
    /**
     * UserDAOImpl 인스턴스를 반환 (Thread-safe 싱글톤)
     * 
     * 이중 검사 잠금(Double-Checked Locking) 방식을 사용하여
     * 스레드 안전성을 보장하면서도 성능을 최적화합니다.
     * 
     * @return UserDAOImpl 싱글톤 인스턴스
     */
    public static UserDAOImpl getInstance() {
        // 첫 번째 검사 (락 획득 전)
        if (instance == null) {
            // 동기화 블록 (멀티스레드 환경에서 한 번에 하나의 스레드만 접근)
            synchronized (UserDAOImpl.class) {
                // 두 번째 검사 (락 획득 후)
                if (instance == null) {
                    instance = new UserDAOImpl();
                }
            }
        }
        return instance;
    }

    /**
     * 사용자 정보 저장
     * 
     * 새로운 사용자 정보를 검증하고 저장합니다.
     * 1. 필수 필드 유효성 검증
     * 2. ID 중복 확인
     * 3. 사용자 정보 저장
     * 
     * @param user 저장할 사용자 정보 (UserDTO 객체)
     * @return 저장 성공 여부 (true: 성공)
     * @throws UserException 유효성 검증 실패 또는 저장 중 오류 발생 시
     */
    @Override
    public boolean saveUser(UserDTO user) throws UserException {
        // 필수 필드 검증
        validateUserFields(user);
        
        // ID 중복 확인 (O(1) 시간 복잡도)
        if (userMap.containsKey(user.getId())) {
            throw new UserException.DuplicateIdException();
        }
        
        // 사용자 정보 저장
        try {
            userMap.put(user.getId(), user);
            return true;
        } catch (Exception e) {
            // 예외 발생 시 래핑하여 상위로 전달
            throw new UserException.RegistrationFailedException("사용자 정보 저장 중 오류가 발생했습니다: " + e.getMessage());
        }
    }

    /**
     * 사용자 필드 유효성 검증
     * 
     * 사용자 객체의 필수 필드(ID, 비밀번호, 이름)가 존재하는지 검증합니다.
     * 누락된 필드가 있을 경우 예외를 발생시킵니다.
     * 
     * @param user 검증할 사용자 정보 (UserDTO 객체)
     * @throws UserException 사용자 객체가 null이거나 필수 필드가 누락된 경우
     */
    private void validateUserFields(UserDTO user) throws UserException {
        // 사용자 객체 자체가 null인 경우
        if (user == null) {
            throw new UserException("사용자 정보가 없습니다.");
        }
        
        // ID 필드 검증
        if (user.getId() == null || user.getId().trim().isEmpty()) {
            throw new UserException.RequiredFieldMissingException("아이디");
        }
        
        // 비밀번호 필드 검증
        if (user.getPassword() == null || user.getPassword().trim().isEmpty()) {
            throw new UserException.RequiredFieldMissingException("비밀번호");
        }
        
        // 이름 필드 검증
        if (user.getName() == null || user.getName().trim().isEmpty()) {
            throw new UserException.RequiredFieldMissingException("이름");
        }
    }

    /**
     * 사용자 ID로 사용자 정보 조회
     * 
     * 지정된 ID에 해당하는 사용자 정보를 HashMap에서 O(1) 시간 복잡도로 조회합니다.
     * 
     * @param id 조회할 사용자 ID
     * @return 사용자 정보 (UserDTO 객체), 해당 ID의 사용자가 없으면 null 반환
     */
    @Override
    public UserDTO findUserById(String id) {
        // ID가 null이거나 빈 문자열인 경우 null 반환
        if (id == null || id.trim().isEmpty()) {
            return null;
        }
        
        // HashMap을 사용하여 O(1) 시간 복잡도로 조회
        return userMap.get(id);
    }

    /**
     * 로그인 처리
     * 
     * 사용자 ID와 비밀번호를 검증하여 로그인을 처리합니다.
     * 1. 입력값 유효성 검증
     * 2. 사용자 ID로 사용자 정보 조회
     * 3. 비밀번호 일치 여부 확인
     * 
     * @param id 사용자 ID
     * @param password 비밀번호
     * @return 로그인 성공 시 사용자 정보 (UserDTO 객체)
     * @throws UserException.RequiredFieldMissingException ID 또는 비밀번호가 누락된 경우
     * @throws UserException.LoginFailedException 로그인 실패 시 (ID 없음 또는 비밀번호 불일치)
     */
    @Override
    public UserDTO login(String id, String password) throws UserException {
        // ID 유효성 검증
        if (id == null || id.trim().isEmpty()) {
            throw new UserException.RequiredFieldMissingException("아이디");
        }
        
        // 비밀번호 유효성 검증
        if (password == null || password.trim().isEmpty()) {
            throw new UserException.RequiredFieldMissingException("비밀번호");
        }
        
        // 사용자 조회 (O(1) 시간 복잡도)
        UserDTO user = findUserById(id);
        if (user == null) {
            // ID에 해당하는 사용자가 없는 경우
            throw new UserException.LoginFailedException();
        }
        
        // 비밀번호 일치 여부 확인
        if (!user.getPassword().equals(password)) {
            // 비밀번호가 일치하지 않는 경우
            throw new UserException.LoginFailedException();
        }
        
        // 로그인 성공
        return user;
    }

    /**
     * 모든 사용자 목록 조회
     * 
     * 시스템에 등록된 모든 사용자 정보를 목록으로 반환합니다.
     * HashMap의 values()를 ArrayList로 변환하여 반환합니다.
     * 
     * @return 사용자 정보 목록 (UserDTO 객체의 List)
     */
    @Override
    public List<UserDTO> getAllUsers() {
        // Map의 values()를 ArrayList로 변환하여 반환
        return new ArrayList<>(userMap.values());
    }
}