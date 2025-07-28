$(function () {
  // 메인 메뉴 항목에 마우스 오버 시 서브메뉴 표시
  $("#menuItem li").mouseenter(function () {
    // 현재 메인 메뉴의 인덱스 가져오기
    const index = $(this).index() + 1;

    // 모든 서브메뉴 숨기기
    $(".subMenuItem").hide();

    // 해당 서브메뉴 표시
    $("#subMenuItem" + index).show();

    // 서브메뉴 박스 표시
    $("#subMenuBox").css("visibility", "visible");
  });

  // 메인 메뉴에서 마우스가 벗어나면 서브메뉴 숨기기
  $("#mainMenuBox").mouseleave(function () {
    $("#subMenuBox").css("visibility", "hidden");
  });

  // 서브메뉴 박스에 마우스 오버 시 표시 유지
  $("#subMenuBox").mouseenter(function () {
    $(this).css("visibility", "visible");
  });

  // 서브메뉴 박스에서 마우스가 벗어나면 숨기기
  $("#subMenuBox").mouseleave(function () {
    $(this).css("visibility", "hidden");
  });
});
