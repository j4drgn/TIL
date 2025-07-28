$(function () {
  $("#showBtn").on("click", function () {
    let result = {
      points: [
        { x: 0.42, y: 0.2 },
        { x: 0.49, y: 0.22 },
        { x: 0.42, y: 0.27 },
        { x: 0.3, y: 0.33 },
        { x: 0.32, y: 0.22 },
        { x: 0.52, y: 0.25 },
        { x: 0.65, y: 0.31 },
        { x: 0.72, y: 0.41 },
        { x: 0.61, y: 0.51 },
        { x: 0.65, y: 0.69 },
        { x: 0.81, y: 0.82 },
        { x: 0.51, y: 0.51 },
        { x: 0.29, y: 0.51 },
        { x: 0.35, y: 0.72 },
        { x: 0.39, y: 0.18 },
        { x: 0.49, y: 0.18 },
      ],
    };
    //canvas에 이미지 출력
    let src = "image/run.jpg";
    drawCanvas(result.points, src); //이미지 출력, 이미지 위에 텍스트 출력 등을 진행하는 사용자 정의 함수
  });

  function drawCanvas(result, src) {
    //canvas 객체 생성
    let canvas = document.getElementById("poseCanvas");
    let context = canvas.getContext("2d");

    //이미지 객체 생성 후 canvas에 추가 (drawImage 메서드 활용)
    let posImage = new Image();
    posImage.src = src;
    posImage.width = canvas.width;
    posImage.height = canvas.height;

    posImage.onload = function () {
      context.drawImage(posImage, 0, 0, posImage.width, posImage.height);
      //텍스트 출력 (출력 정보별 색상 사용)
      let colors = [
        "red",
        "blue",
        "yellow",
        "yellow",
        "yellow",
        "green",
        "green",
        "green",
        "skyblue",
        "skyblue",
        "skyblue",
        "white",
        "white",
        "white",
        "brown",
        "gold",
      ];
      let position = [
        "코",
        "목",
        "오른쪽 어깨",
        "오른쪽 팔굼치",
        "오른쪽 손목",
        "왼쪽 어깨",
        "왼쪽 팔굼치",
        "왼쪽 손목",
        "오른쪽 엉덩이",
        "오른쪽 무릎",
        "오른쪽 발목",
        "왼쪽 엉덩이",
        "왼쪽 무릎",
        "왼쪽 발목",
        "왼쪽 눈",
        "왼쪽 귀",
      ];

      let value = "";

      //result는 배열이 전달됨 배열 순회하면서 정해진 위치(result에 전달된 position 값)에 텍스트 출력
      $.each(result, function (i) {
        if (this.x != 0 || this.y != 0) {
          context.strokeStyle = colors[i];
          context.strokeRect(
            this.x * posImage.width,
            this.y * posImage.height,
            2,
            2
          );
          let text = this.x.toFixed(2) + "," + this.y.toFixed(2);
          console.log(text);
          context.font = "10px";
          context.strokeText(
            text,
            this.x * posImage.width,
            this.y * posImage.height
          );
          value += position[i] + "(" + this.x + "," + this.y + ")</br>";
        }
      }); //each
      $("#resultDivBox").html(value);
    }; //onload
  } //drawcanvas
}); //ready
