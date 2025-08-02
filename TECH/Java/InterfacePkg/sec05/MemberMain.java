package InterfacePkg.sec05;

public class MemberMain {

  public static void main(String[] args) {
    //DTO DAO 활용 예제
    //회원 가입을 위한 정보가 전달되었다고 가정
    MemberDTO dto = new MemberDTO("abcd", "1234", "김철수", "010-1234-1234", "서울");

    //DAO에게 전달해서 회원가입 메서드가 실행되어야 함.
    IMemberDAO idao = new MemberDAO();
    MemberDAO dao = new MemberDAO();

    idao.insertMember(dto);
    dao.insertMember(dto);

    //회원검색 - 검색결과 반환 타입 DTO
    dto = idao.selectMember("123");
    //검색된 결과인 dto를 view로 넘겨서 프론트를 완성 클라이언트에게 전달.
    
  }

}
