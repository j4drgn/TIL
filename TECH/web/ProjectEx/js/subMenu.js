/**
 * subMenu.js
 */

$(function () {
  //메인메뉴박스의 [전체보기]클릭했을 때 모든 메뉴 항목 보이게
  $("#showAllMenu").on("click", function () {
    if ($(this).text() == "전체보기 ▼") {
      //서브메뉴 박스 보이기
      $("#subMenuBox").css("visibility", "visible");
      $(this).text("메뉴닫기 ▲").css("color", "blue");
      //메뉴텍스트 메뉴닫기로 변경
    } else {
      //서브메뉴박스 감추기
      //메뉴 텍스트 전체보기로 변경
      $("#subMenuBox").css("visibility", "hidden");
      $(this).text("전체보기 ▼").css("color", "black");
    }
  });
});
