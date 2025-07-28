const Nav = (props) => {
  //props에 전달되는 객체는 toipcs라는 배열이 전달됨
  //props.topics -> 배열
  //props.topics[0].id
  //각 원소의 title만 추출해서 목록을 구성
  const lis = [];
  for (let i = 0; i < props.topics.length; i++) {
    let t = props.topics[i];
    lis.push(<li>{t.title}</li>);
  }
  return (
    <nav>
      <ol>
        {/* 선택자 컴포넌트에서 전달된 데이터에 따라 목록 생성 */}
        {lis}
      </ol>
    </nav>
  );
};

export default Nav;
