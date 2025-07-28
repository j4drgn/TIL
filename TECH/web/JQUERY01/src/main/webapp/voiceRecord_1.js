/*
 * voiceRecord.js
 */

// 자바스크립트 코드
window.onload = function () {
  let record = document.getElementById("recordBtn");
  let stop = document.getElementById("stopBtn");
  let soundClips = document.getElementById("soundClips");

  if (navigator.mediaDevices) {
    var constraints = {
      audio: true,
    };
    let chunks = []; //녹음 데이터 저장하기 위한 변수
    //mediaDevices 카메라 마이크 공유화면 등 현재 연결된 미디어 입력장치로의 접근 방법 제공하는 인터페이스
    navigator.mediaDevices
      .getUserMedia(constraints)
      .then((stream) => {
        //녹음을 위한 객체 생성 MediaRecorder 클래스 사용해서 녹음 개체 생성
        const MediaRecoder = new MediaRecorder(stream);

        //녹음 버튼을 클릭했을 때
        record.onclick = () => {
          MediaRecoder.start(); //녹음 시작, 10ms마다 데이터 수집
          record.style.background = "red";
          record.style.color = "black";
        }; //녹음버튼 종료

        //정지 버튼을 클릭했을 때
        stop.onclick = () => {
          MediaRecoder.stop();
          record.style.background = "";
          record.style.color = "";
        };

        //stop 이벤트 발생시 처리 내용
        MediaRecoder.onstop = (e) => {
          //1. audio 담을 컨테이너 객체 생성
          const clipContainer = document.createElement("article");
          //2. audio 객체 생성 속성 설정
          const audio = document.createElement("audio");
          audio.setAttribute("controls", "");
          //3. audio 객체와 컨테이너 객체 연결
          clipContainer.appendChild(audio);
          //sound-clips 태그 내에 이전에 포함된 자식 노드 있으면 제거
          if (soundClips.hasChildNodes()) {
            soundClips.removeChild(soundClips.childNodes[0]);
          }
          //4. sound-clip에 컨테이너 연결
          soundClips.appendChild(clipContainer);
          //5. 녹음데이터를 audio 양식으로 설정 -> mp3변환
          //blob 형식의 데이터를 mp3 타입으로 설정 -> 새로운 객체 사용
          //저장위치 통로 chuncks 활용
          const blob = new Blob(chunks, {
            type: "audio/mp3; codecs=opus",
          });
          //6. 녹음 내용을 파일로 저장 -> 다운로드
          const audioURL = URL.createObjectURL(blob);
          audio.src = audioURL;

          const clipName = "voiceRecord"; //다운로드시 사용할 파일 이름

          const a = document.createElement("a");
          clipContainer.appendChild(a);
          a.href = audio.src;
          // alert(audio.src);
          // a태그는 download 속성이 있고 파일명을 주면 해당 파일명으로 다운로드 진행하게 됨(클릭이벤트 발생시)
          a.download = clipName;
          a.click(); //a 태그에 클릭 이벤트 발생 자동 다운로드 진행
        }; //MediaRecoder.onstop 끝

        //mediaRecoder 유효한 녹음 데이터가 있으며 발생하는 이벤트
        //녹음이 시작되어 유효한 상태면 chunks에 녹음 데이터 저장
        MediaRecoder.ondataavailable = (e) => {
          //마이크를 통해서 전달되는 데이터는 이벤트 객체의 data 속성에 담겨 전달됨
          chunks.push(e.data);
        }; //유효 이벤트 chunks에 저장 끝
      })
      .catch((err) => {
        console.log("오류 발생: " + err);
      });
  }
};
