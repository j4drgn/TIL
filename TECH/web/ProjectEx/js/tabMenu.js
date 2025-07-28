$(function () {
  var $tabContent = $("#tabContent div");

  $("#tabMenu li:first-child").addClass("selectedItem");

  $("#tabMenu li").on("click", function () {
    // 탭 메뉴 항목 클릭시
    // 클릭한 메뉴 항목 index 알아오기
    var index = $(this).index();

    //탭메뉴 항목을 선택된 이미지로 변경

    //메뉴 이미지 변경
    $("#tabMenu li").removeClass("selectedItem");
    $(this).addClass("selectedItem");
    //콘텐츠 이미지 변경
    //content의 모든 div 숨기고
    $tabContent.css("display", "none");
    //선택된 탭메뉴와 인덱스 값이 같은 원소 div만 표현함.
    $tabContent.eq(index).css("display", "block");
  });
});
