$(function () {
  // 변수 선언
  let currentIndex = 0;
  const slideCount = $("#slidePanel img").length;
  let slidePosition;
  let slideWidth = $("#slideShowBox").width();
  let timer;

  // 슬라이드 패널 초기 위치 설정
  $("#slidePanel").css("left", 0);

  // 이미지 인덱스 사용
  function moveSlide(index) {
    if (index < 0) {
      index = slideCount - 1;
    } else if (index >= slideCount) {
      index = 0;
    }

    currentIndex = index;
    slidePosition = -currentIndex * slideWidth;
    $("#slidePanel").stop().animate({ left: slidePosition }, 500);
  }

  // 이전 버튼 클릭 시
  $("#prevButton").click(function () {
    moveSlide(currentIndex - 1);
    clearInterval(timer);
    autoSlide();
  });

  // 다음 버튼 클릭 시
  $("#nextButton").click(function () {
    moveSlide(currentIndex + 1);
    clearInterval(timer);
    autoSlide();
  });

  // 자동 슬라이드 함수
  function autoSlide() {
    timer = setInterval(function () {
      moveSlide(currentIndex + 1);
    }, 3000);
  }

  // 자동 슬라이드 시작
  autoSlide();

  // 윈도우 크기 변경 시 슬라이드 너비 조정
  $(window).resize(function () {
    slideWidth = $("#slideShowBox").width();
    moveSlide(currentIndex);
  });
});
