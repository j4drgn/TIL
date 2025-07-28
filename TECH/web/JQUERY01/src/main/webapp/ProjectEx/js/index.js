$(function () {
  // 윈도우 스크롤 시 메인 메뉴 고정
  $(window).scroll(function () {
    if ($(this).scrollTop() > $("#headerBox").height()) {
      $("#mainMenuBox").addClass("fixed");
      $("body").css("padding-top", $("#mainMenuBox").height() + "px");
    } else {
      $("#mainMenuBox").removeClass("fixed");
      $("body").css("padding-top", 0);
    }

    // Top 버튼 표시/숨김
    if ($(this).scrollTop() > 300) {
      $(".topButton").fadeIn();
    } else {
      $(".topButton").fadeOut();
    }
  });

  // Top 버튼 클릭 시 맨 위로 스크롤
  $(".topButton").click(function () {
    $("html, body").animate({ scrollTop: 0 }, 500);
    return false;
  });

  // Top 버튼 추가 (없는 경우)
  if ($(".topButton").length === 0) {
    $("body").append('<div class="topButton">TOP</div>');
  }
});
