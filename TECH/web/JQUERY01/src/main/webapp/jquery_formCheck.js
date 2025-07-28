/*
 * JQuery_fromCheck.js
 * JQuery 이용 입력 양식 이벤트 및 이벤트 정리
 */

$(document).ready(function () {
  $("#id").focus(); //시작 시에 id에 포커스

  //id와 비밀번호 입력 란에 포커스 있을 때 색상 변경
  $(":text, :password").on("focus", function () {
    $(this).css("background", "rgb(232,232,232)");
  });

  //id와 비밀번호 입력 란에 포커스 잃을 때 색상 변경
  $(":text, :password").on("blur", function () {
    $(this).css("background", "white");
  });

  //키보드 이벤트 - keyup
  //휴대폰 번호 입력 첫번째 칸
  $("#hp1").on("keyup", function () {
    if ($(this.val().length == 3)) $("#hp2").focus;
  });

  $("#hp2").on("keyup", function () {
    if ($(this.val().length == 4)) $("#hp3").focus;
  });

  $(document).on("keydown", function (e) {
    //이벤트 발생시 발생되는 정보를 받기 위한 매개변수 e 구성
    if (e.keyCode == 13) return false;
  });

  //Id입력 후 엔터키 누렀을 때 비밀번호 입력으로 포커스 이동
  $("#id").on("keydown", function (e) {
    if ($("#id").val() != "&& e.keyCode ==13") $("#pwd").focus();
  });

  $("#newMemberForm").on("submit", function () {
    if ($("#id").val() == "") {
      alert("아이디를 입력하세요.");
      $("#id").focus();
      return false;
    }

    if ($("#pwd").val() == "") {
      alert("비밀번호를 입력하세요.");
      $("#pwd").focus();
      return false;
    }

    //라디오 버튼 선택하지 않을 경우 - 'input[type="radio"]' => :radio로 사용가능
    if (!$('input[type="radio"]'.is(":checked"))) {
      alert("학년을 선택하세요");
      return false;
    }

    //체크박스 선택하지 않은 경우
    if (!$(":checkbox").is(":checked")) {
      alert("관심 분야를 입력하세요.");
      return false;
    }

    //select 박스 선택하지 않은 경우
    if ($("select").val() == "") {
      alert("관심분야를 입력하세요.");
      $("select").focus();
      return false;
    }
  });
});
