/*
join.html 파일의 입력 유효성 검사를 진행하는 자바스크립트 코드
<input> 입력란에 데이터를 입력했는지의 여부
입력된 데이터의 길이 체크
비밀번호와 비밀번호 확인 일치 여부
라디오버튼 체크 여부
체크박스 체크 여부
*/

// 태그가 모두 준비되고 나서 유효성 검사
window.onload = function () {
  //submit 버튼 클릭시 form 유효성 검사 진행
  //var from_var = document.getElementById("joinForm");
  document.getElementById("joinForm").onsubmit = function () {
    //1. 성명을 입력하지 않은 경우 경고창 출력 -> 성명 입력 칸에 포커스 -> submit 실행 대기
    var name = document.getElementById("name");

    if (name.value == "") {
      //성명 입력하지 않음
      alert("성명을 입력하세요.");
      name.focus(); //성명 입력란에 자동 포커스
      return false; //submit 방지
    }

    //2. id에 대한 입력 여부, 길이 제한에 대한 유효성 검사
    var id = document.getElementById("id");

    if (id.value == "") {
      alert("아이디를 입력하세요.");
      id.focus();
      return false;
    }

    //입력된 id 글자 수 확인
    if (id.value.length < 6 || id.value.length > 10) {
      alert("아이디는 6~10자리로 입력하세요.");
      id.value = "";
      id.focus();
      return false;
    }

    //비밀번호와 비밀번호 확인 일치여부 체크
    var password = document.getElementById("password");
    var passwordCheck = document.getElementById("passwordCheck");

    if (password.value == "") {
      alert("비밀번호를 입력하세요.");
      password.focus();
      return false;
    }

    if (password.value.length < 10 || password.value.length > 20) {
      alert("비밀번호는 10~20자리로 입력하세요.");
      password.value = "";
      password.focus();
      return false;
    }

    if (password.value != passwordCheck.value) {
      alert("비밀번호 확인이 일치하지 않습니다.");
      passwordCheck.value = "";
      passwordCheck.focus();
      return false;
    }

    //직업 선택을 하지 않은 경우(select 태그 -> selectedIndex)
    //어떤 옵션도 선택하지 않으면 "-1"
    //option 태그의 idx 값은 0부터 시작 -> 0번 idx 옵션에는 value 속성이 비어있으므로
    //selectedIndex 값이 0이면 재선택 진행
    var job = document.getElementById("job"); //select 객체 참조

    // if ((job.selectedIndex = 0)) {
    //   alert("직업을 선택하세요.");
    //   return false;
    // }

    if (job.value == "") {
      alert("직업을 선택하세요.");
      return false;
    }

    //라디오 버튼의 name 속성을 사용해서 객체 접근
    //라디오 그룹에서는 name 속성 값이 동일하므로 name 속성 이용해서 접근하면 배열과 같은 리스트가 반환 - 반복문 활용 모든 라디오버튼 확인
    var chk = false; //라디오 버튼 체크 여부 저장하는 변수
    //라디오 그룹 내에서는 단일 선택만 가능
    for (var i = 0; i < joinForm.emailRcv.length; i++) {
      if (joinForm.emailRcv[i].checked == true) {
        chk = true;
      }
    }

    //그룹내 라디오버튼 검사했는데 chk 가 false 그룹 내 어떤 라디오 버튼도 선택 되지 않았음.
    if (chk == false) {
      alert("이메일 수신 여부를 선택하세요");
      return false;
    }

    //체크박스의 유효성 검사
    var agreement1 = document.getElementById("agreement1");
    var agreement2 = document.getElementById("agreement2");

    if (agreement1.checked == false || agreement2.checked == false) {
      alert("모두 동의해야 합니다");
      return false;
    }
  }; //onsubmit 끝
}; //window.onload 끝
