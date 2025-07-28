$(function () {
  // 초기 설정: 첫 번째 탭 메뉴 항목 선택
  $("#tabMenu li:first-child").addClass("selectedItem");
  $("#tabContent div:first-child").show();

  // 탭 메뉴 클릭 이벤트
  $("#tabMenu li a").click(function (e) {
    e.preventDefault();

    // 모든 탭 메뉴에서 선택 클래스 제거
    $("#tabMenu li").removeClass("selectedItem");

    // 현재 클릭한 탭 메뉴에 선택 클래스 추가
    $(this).parent().addClass("selectedItem");

    // 모든 탭 컨텐츠 숨기기
    $(".tabContent").hide();

    // 클릭한 탭에 해당하는 컨텐츠 표시
    const targetContent = $(this).attr("href");
    $(targetContent).show();
  });
});
