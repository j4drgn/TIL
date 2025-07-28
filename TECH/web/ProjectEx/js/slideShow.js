/**
 *slideShow.js
 */

$(function () {
  //이동한 이미지의 index 값 저장 변수(현재 이미지)
  var moveIndex = 0;

  //슬라이드 패널을 움직여주는 함수
  function moveSlide(index) {
    //전달받은 index값을 moveIndex에 저장
    moveIndex = index;

    //슬라이드 이동
    var moveLeft = -(index * 1280);
    $("#slidePanel").animate({ left: moveLeft }, "slow");
  }

  //prev 버튼 클릭하면 앞으로 이동
  $("#prevButton").on("click", function () {
    if (moveIndex != 0)
      //첫번째 이미지가 아니면 진행
      moveIndex = moveIndex - 1;

    moveSlide(moveIndex);
  });

  //next 버튼 클릭하면 뒤로 이동
  $("#nextButton").on("click", function () {
    if (moveIndex != 4)
      //마지막 이미지가 아니면 진행
      moveIndex = moveIndex + 1;

    moveSlide(moveIndex);
  });

  //   var randomNumber = Math.floor(Math.random() * 5);
  //   moveSlide(randomNumber);

  // 첫 번째 이미지부터 시작
  moveSlide(0);

  //각 컨트롤 버튼에 대해
  $(".controlButton").each(function (index) {
    $(this).hover(
      function () {
        $(this).attr("src", "image/controlButton2.png");
      },
      function () {
        $(this).attr("src", "image/controlButton1.png");
      }
    );
    $(this).on("click", function () {
      moveSlide(index);
    }); //click끝
  }); //each끝

  // 자동 슬라이드 실행
  var slideInterval = setInterval(() => {
    if (moveIndex >= 4) {
      moveIndex = 0;
    } else {
      moveIndex = moveIndex + 1;
    }
    moveSlide(moveIndex);
  }, 5000);

  $("#slideShow").hover(
    function () {
      clearInterval(slideInterval);
    },
    function () {
      slideInterval = setInterval(() => {
        if (moveIndex >= 4) {
          moveIndex = 0;
        } else {
          moveIndex = moveIndex + 1;
        }
        moveSlide(moveIndex);
      }, 5000);
    }
  );
}); //ready 끝
