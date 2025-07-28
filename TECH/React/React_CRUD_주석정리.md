# React CRUD 애플리케이션 주석 정리

이 문서는 React CRUD 애플리케이션의 주요 개념과 코드에 포함된 주석을 정리한 것입니다. 코드 예시와 함께 개념을 설명합니다.

## 목차

1. [상태 관리와 렌더링](#상태-관리와-렌더링)
2. [모드에 따른 컨텐츠 변환](#모드에-따른-컨텐츠-변환)
3. [이벤트 처리](#이벤트-처리)
4. [컴포넌트 간 데이터 전달](#컴포넌트-간-데이터-전달)
5. [불변성 유지](#불변성-유지)

## 상태 관리와 렌더링

React에서는 상태(state)가 변경되면 해당 컴포넌트가 다시 렌더링됩니다.

```jsx
// topics가 값이 변경되면 (원소가 추가되면) 표현된 화면의 목록이 변경되어야 함
// 렌더링이 진행되어야 함 -> state 활용
const [nextId, setNextId] = useState(4);
const [topics, setTopics] = useState([
  { id: 1, title: "html", body: "html is ..." },
  { id: 2, title: "css", body: "css is ..." },
  { id: 3, title: "javascript", body: "javascript is ..." },
]);
```

## 모드에 따른 컨텐츠 변환

애플리케이션의 모드에 따라 다른 컨텐츠를 보여주는 방식입니다.

```jsx
// mode값에 따라 content 변환 코드
let content = null;
let contextControl = null;

if (mode === "WELCOME") {
  // 초기화면
  content = <Article title="Welcome" body="Hello, Web"></Article>;
} else if (mode === "READ") {
  // 게시 목록을 클릭하면 변화되는 코드
  // ...
} else if (mode === "CREATE") {
  // create 메뉴 클릭하면 입력창을 표현(component 이용->Create)
  // ...
} else if (mode === "UPDATE") {
  // ...
}
```

## 이벤트 처리

React에서 이벤트를 처리하는 방법입니다.

### 기본 이벤트 방지

```jsx
// submit 이벤트의 기본 기능은 중지시킴
<form
  onSubmit={(event) => {
    event.preventDefault();
    // submit 이벤트 발생시에 입력된 데이터 추출
    const title = event.target.title.value;
    const body = event.target.body.value;
    props.onCreate(title, body);
  }}
>
```

### 링크 클릭 이벤트

```jsx
<a
  href="/"
  onClick={(event) => {
    event.preventDefault();
    props.onChangeMode();
  }}
>
  {props.title}
</a>
```

## 컴포넌트 간 데이터 전달

props를 통해 부모 컴포넌트에서 자식 컴포넌트로 데이터와 함수를 전달합니다.

```jsx
// Create 컴포넌트의 create 버튼을 클릭해서 submit 이벤트가 발생하면 props로 전달된 함수가 실행이 되도록
// 함수 내용은 입력된 title과 body를 위에서 선언한 topics 배열에 추가
content = (
  <Create
    onCreate={(_title, _body) => {
      // submit 이벤트 발생시 전달되는 인수를 사용자 정의 객체로 구성
      const newTopic = { id: nextId, title: _title, body: _body };
      // ...
    }}
  ></Create>
);
```

## 불변성 유지

React에서 상태를 업데이트할 때 불변성을 유지하는 것이 중요합니다.

```jsx
// state value 객체배열 복사 -> 원본 보존
const newTopics = [...topics];
newTopics.push(newTopic);
setTopics(newTopics);
```

### 잘못된 방식과 올바른 방식 비교

```jsx
// 잘못된 방식
// topics.push(newTopic);
// setTopics(topics);

// 설명:
// 기존 state value객체인 topics하고 setTopics가 전달하고 값하고 비교해서 변경된것이 있어야 렌더링을 진행함
// 위 코드는 state가 참조하는 배열을 미리 변경시켜 놓고 변경된 배열을 setTopics에게 전달했음
// setTopics입장에서는 변화가 없음
// 렌더링 진행안됨

// 올바른 방식:
// state가 참조하는 원본 배열을 복사해서 복사본을 변경함
// setTopics에게 복사본전달 -> 원본과 비교해서 변동이 있으므로
// 렌더링 진행하고 원본을 변경시킴
// 배열 복제 : [...배열명]
const newTopics = [...topics];
newTopics.push(newTopic);
setTopics(newTopics);
```

## 폼 입력 관리

React에서 폼 입력을 관리하는 방법입니다.

### 제어 컴포넌트 (Controlled Component)

```jsx
// value값은 특정값으로 고정한 상태 inputbox 수정 안됨 state 이용해서 관리
<input
  type="text"
  name="title"
  placeholder="title"
  value={title}
  onChange={(event) => {
    setTitle(event.target.value);
  }}
/>
```

### 비제어 컴포넌트 (Uncontrolled Component)

```jsx
<input type="text" name="title" placeholder="title" />
```

## 정리

React CRUD 애플리케이션을 구현할 때 주요 개념:

1. **상태 관리**: useState를 사용하여 컴포넌트의 상태 관리
2. **이벤트 처리**: 이벤트 핸들러를 통한 사용자 상호작용 처리
3. **불변성 유지**: 상태 업데이트 시 원본 데이터 변경 대신 새 객체 생성
4. **컴포넌트 간 통신**: props를 통한 데이터 및 함수 전달
5. **조건부 렌더링**: 모드에 따라 다른 컨텐츠 표시
