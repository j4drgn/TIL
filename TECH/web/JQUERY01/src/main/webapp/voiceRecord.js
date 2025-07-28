/**
 * voiceRecord.js
 */

// 자바스크립트 코드
window.onload = function(){
	let record = document.getElementById ('recordBtn');
	let stop= document.getElementById('stopBtn');
	let soundClips = document.getElementById('sound-clips');
	
	if(navigator.mediaDevices){
		var constraints = {
			audio:true
		}
		
		let chunks = []; //녹음데이터 저장하기 위한 변수
		//mediaDevices 카메라 마이크 공유화면 등 현재 연결된 미디어 입력장치로의 접근 방법 제공하는 인터페이스
		navigator.mediaDevices.getUserMedia(constraints)
			.then(stream=>{
				//녹음을 위한 객체 생성 MediaRecorder 클래스 사용해서 녹음객체 생성 stream 객체 생성자에 전달해야 함
				const mediaRecoder = new MediaRecorder(stream);
				
				//녹음 버튼을 클릭했을 때
				record.onclick = ()=>{
					mediaRecoder.start(); //녹음시작
					record.style.background = "red"; //녹음 버튼 배경색 변경
					record.style.color = "black";
				} //녹음버튼 종료
				
				//정지 버튼을 클릭했을 때
				stop.onclick = ()=>{
					mediaRecoder.stop(); //녹음정지
					record.style.background = ""; //녹음 버튼 원래상태로 되돌림
					record.style.color = "";				
				} //정지버튼 종료
				
				//stop 이벤트 발생시 처리 내용
				//1. audio 담을 컨테이너 객체 생성
				//2. audio 객체 생성 속성 설정
				//3. audio 객체와 컨테이너 객체 연결
				//4. sound-clip에 컨테이너 연결
				//5. 녹음 데이터를 audio 양식으로 설정 -> mp3변환
				//6. 녹음 내용을 파일로 저장 -> 다운로드
				
				mediaRecoder.onstop = e => {
					//1. audio 담을 컨테이너 객체 생성
					const clipContainer = document.createElement('article');
					//2. audio 객체 생성 속성 설정
					const audio = document.createElement('audio'); //audio 태그 생성
					audio.setAttribute('controls','');
					//3. audio 객체와 컨테이너 객체 연결
					clipContainer.appendChild(audio);
					//sound-clips 태그내에 이전에 포함된 자식노드 있으면 제거
					if(soundClips.hasChildNodes()){
						soundClips.removeChild(soundClips.childNodes[0]);						
					}
					//4. sound-clip에 컨테이너 연결
					soundClips.appendChild(clipContainer);
					
					//5. 녹음 데이터를 audio 양식으로 설정 -> mp3변환
					//blob 형식의 데이터를 mp3 타입으로 설정 -> 새로운 객체 사용
					//저장위치 통로 chuncks 활용
					
					const blob = new Blob(chunks,{
						'type':'audio/mp3 codcs=opus'
					})
					chunks = [] ; //초기화 하지 않으면 녹음내용이 누적됨
					
					//6. 녹음파일 내용 파일로 저장하고 다운로드
					const audioURL = URL.createObjectURL(blob);
					audio.src = audioURL;	
					
					const clipName = "voiceRecord";//다운로드시 사용할 파일이름
					
					const a = document.createElement('a');
					clipContainer.appendChild(a);
					a.href = audio.src;
					//alert(audio.src);
					//a태그는 download 속성이 있고 파일명을 주면 해당 파일명으로 다운로드 진행하게 됨(클릭이벤트 발생 시)
					a.download = clipName ;
					a.click();//a태그에 클릭이벤트 발생 자동 다운로드진행								
					
				   }//mediaRecorder.onstop 끝
			   
				//mediaRecoder 유효한 녹음데이터가 있으면 발생하는 이벤트
				//녹음이 시작되어 유효한 상태면 chunks에 녹음데이터 저장   
				mediaRecoder.ondataavailable = e =>{ //마이크를 통해서 전달되는 데이터는 이벤트객체의 data 속성에 담겨 전달됨
					chunks.push(e.data);
				}//유효 이벤트 chunks에 저장끝
				 
			})//then 종료
			.catch(err=>{
				console.log('오류발생 : ' + err);
			})//catch 끝
	}//if 끝
}//window.onload끝








