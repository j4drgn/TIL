package InterfacePkg.sec05;

//데이터 교환에 사용될 클래스
//회원 관리에 사용할 예정 - 회원 한명을 표현하는 클래스
//필요 필드 : 회원가입시 받아야할 정보 결정해서 생성
public class MemberDTO {

  //DTO의 멤버 필드명은 DB 테이블의 컬럼명과 일치시키는 게 좋음(member table을 구성했다고 가정)
  private String memId;
  private String memPass;
  private String memName;
  private String memPhone;
  private String memAddress;

  //DTO는 생성자를 대부분 명시함.
  public MemberDTO(String memId, String memPass, String memName, String memPhone,
      String memAddress) {
    this.memId = memId;
    this.memPass = memPass;
    this.memName = memName;
    this.memPhone = memPhone;
    this.memAddress = memAddress;
  }

  //DTO는 Getter/Setter 구성함.
  public String getMemId() {
    return memId;
  }

  public void setMemId(String memId) {
    this.memId = memId;
  }

  public String getMemPass() {
    return memPass;
  }

  public void setMemPass(String memPass) {
    this.memPass = memPass;
  }

  public String getMemName() {
    return memName;
  }

  public void setMemName(String memName) {
    this.memName = memName;
  }

  public String getMemPhone() {
    return memPhone;
  }

  public void setMemPhone(String memPhone) {
    this.memPhone = memPhone;
  }

  public String getMemAddress() {
    return memAddress;
  }

  public void setMemAddress(String memAddress) {
    this.memAddress = memAddress;
  }
}
