$(document).ready(function () {
  //챗봇에게 질문하고 응답하기 - 텍스트 응답

  //message 입력하고 전송 버튼 눌렀을 때
  $("#chatForm").on("submit", function (event) {
    //submit 기본 동작 중지
    event.preventDefault();

    if ($("#message").val() != "") {
      $("#chatBox").append(
        "<div class = 'msgBox send'><span>" +
          $("#message").val() +
          "</span></div>"
      );
    }
    $("#message").val("");

    getResponse();
  });

  $("#closeBtn").on("click", function () {
    window.close();
  });
});

function getResponse() {
  //서버에게 입력된 메세지 보내서 받은 응답
  let result =
    "저는 챗봇입니다. 응답 메세지를 길게 작성합니다, 줄바꿈을 확인하기 위해서입니다.";
  //chatBox에 받은 메세지 추가
  $("#chatBox").append(
    '<div class="msgBox receive"><span>' + result + "</span></div><br>"
  );
  //마지막에 추가된 메세지가 보이도록 위로 스크롤
  //객체.attr():
  //객체.prop():  실시간 반영된 요소들에 대한 속성값을 반환
  $("#chatBox").scrollTop($("#chatBox").prop("scrollHeight"));
}
