package user;

/**
 * 사용자 정보를 저장하는 DTO(Data Transfer Object) 클래스
 * 
 * 이 클래스는 사용자의 기본 정보(ID, 비밀번호, 이름)를 캡슐화하여
 * 시스템 내에서 사용자 데이터를 전달하는 용도로 사용됩니다.
 * 
 * DTO 패턴을 적용하여 데이터 계층과 비즈니스 로직 계층 사이의
 * 데이터 교환을 단순화합니다.
 */
public class UserDTO {
    /** 사용자 ID (고유 식별자) */
    private String id;
    
    /** 사용자 비밀번호 (인증용) */
    private String password;
    
    /** 사용자 이름 (표시용) */
    private String name;

    /**
     * 기본 생성자
     * 
     * 매개변수 없이 객체를 생성합니다.
     * 주로 프레임워크나 라이브러리에서 리플렉션을 통한 객체 생성 시 사용됩니다.
     */
    public UserDTO() {
        // 기본 생성자
    }

    /**
     * 모든 필드를 초기화하는 생성자
     * 
     * 사용자 정보의 모든 필드를 한 번에 초기화합니다.
     * 
     * @param id 사용자 ID
     * @param password 사용자 비밀번호
     * @param name 사용자 이름
     */
    public UserDTO(String id, String password, String name) {
        this.id = id;
        this.password = password;
        this.name = name;
    }

    /**
     * 사용자 ID 조회
     * 
     * @return 사용자 ID
     */
    public String getId() {
        return id;
    }

    /**
     * 사용자 ID 설정
     * 
     * @param id 설정할 사용자 ID
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 사용자 비밀번호 조회
     * 
     * @return 사용자 비밀번호
     */
    public String getPassword() {
        return password;
    }

    /**
     * 사용자 비밀번호 설정
     * 
     * @param password 설정할 사용자 비밀번호
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 사용자 이름 조회
     * 
     * @return 사용자 이름
     */
    public String getName() {
        return name;
    }

    /**
     * 사용자 이름 설정
     * 
     * @param name 설정할 사용자 이름
     */
    public void setName(String name) {
        this.name = name;
    }
}