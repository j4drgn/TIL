package user;

import exception.UserException;
import java.util.List;

/**
 * 사용자 정보를 관리하는 DAO(Data Access Object) 인터페이스
 * 
 * 이 인터페이스는 사용자 정보의 저장, 조회, 인증 등의 데이터 접근 작업을 정의합니다.
 * DAO 패턴을 통해 데이터 접근 로직과 비즈니스 로직을 분리합니다.
 * 
 * 주요 기능:
 * - 사용자 정보 저장 및 유효성 검증
 * - ID를 통한 사용자 정보 조회
 * - 로그인 처리 및 인증
 * - 전체 사용자 목록 조회
 */
public interface UserDAO {
    /**
     * 사용자 정보를 저장
     * 
     * 새로운 사용자 정보를 저장합니다. 저장 전에 필수 필드 유효성 검증 및
     * ID 중복 여부를 확인합니다.
     * 
     * @param user 저장할 사용자 정보 (UserDTO 객체)
     * @return 저장 성공 여부 (true: 성공, false: 실패)
     * @throws UserException.DuplicateIdException 이미 존재하는 ID인 경우
     * @throws UserException.RequiredFieldMissingException 필수 필드(ID, 비밀번호, 이름)가 누락된 경우
     * @throws UserException.RegistrationFailedException 기타 저장 과정에서 오류 발생 시
     */
    boolean saveUser(UserDTO user) throws UserException;
    
    /**
     * 사용자 ID로 사용자 정보 조회
     * 
     * 지정된 ID에 해당하는 사용자 정보를 조회합니다.
     * 
     * @param id 조회할 사용자 ID
     * @return 사용자 정보 (UserDTO 객체), 해당 ID의 사용자가 없으면 null 반환
     */
    UserDTO findUserById(String id);
    
    /**
     * 로그인 처리
     * 
     * 사용자 ID와 비밀번호를 검증하여 로그인을 처리합니다.
     * 
     * @param id 사용자 ID
     * @param password 비밀번호
     * @return 로그인 성공 시 사용자 정보 (UserDTO 객체)
     * @throws UserException.LoginFailedException 로그인 실패 시 (ID 없음 또는 비밀번호 불일치)
     * @throws UserException.RequiredFieldMissingException ID 또는 비밀번호가 누락된 경우
     */
    UserDTO login(String id, String password) throws UserException;
    
    /**
     * 모든 사용자 목록 조회
     * 
     * 시스템에 등록된 모든 사용자 정보 목록을 반환합니다.
     * 
     * @return 사용자 정보 목록 (UserDTO 객체의 List)
     */
    List<UserDTO> getAllUsers();
    
    /**
     * 사용자 정보 수정
     * 
     * @param user 수정할 사용자 정보
     * @return 수정 성공 여부
     * @throws UserException 수정 중 오류 발생 시
     */
    boolean updateUser(UserDTO user) throws UserException;
    
    /**
     * 회원 탈퇴 처리
     * 
     * @param id 탈퇴할 사용자 ID
     * @return 탈퇴 성공 여부
     * @throws UserException 탈퇴 처리 중 오류 발생 시
     */
    boolean withdrawUser(String id) throws UserException;
}