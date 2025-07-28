import React from "react";
import { useParams } from "react-router-dom";

const Topic = (props) => {
  console.log(props.content);
  let content = props.content;
  let params = useParams();
  console.log(params);
  let topic_id = params.topic_id;
  //topic_id에 해당되는 데이터를 content에서 찾는 작업을 진행
  //topic_id에 해당되는 데이터가 없으면 기본값으로 출력
  let selected_topic = {
    title: "Sorry",
    description: "Not Found",
  };

  for (var i = 0; i < content.length; i++) {
    if (content[i].id === Number(topic_id)) {
      selected_topic = content[i];
      break;
    }
  }
  return (
    <div>
      <h3>{selected_topic.title}</h3>
      {selected_topic.description}
    </div>
  );
};

export default Topic;
