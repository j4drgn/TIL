$(function () {
  // 상품 아이템에 마우스 오버 시 효과
  $(".productItem").mouseenter(function () {
    $(this).find("img").css({
      transform: "scale(1.1)",
      transition: "transform 0.3s",
    });
  });

  // 상품 아이템에서 마우스가 벗어날 때 효과
  $(".productItem").mouseleave(function () {
    $(this).find("img").css({
      transform: "scale(1.0)",
      transition: "transform 0.3s",
    });
  });

  // 상품 아이템 클릭 시 이벤트 (예: 상세 페이지로 이동)
  $(".productItem").click(function () {
    const productName = $(this).find("h3").text();
    alert(productName + " 상품 상세 페이지로 이동합니다.");
    // 실제 구현에서는 location.href를 사용하여 페이지 이동
  });
});
