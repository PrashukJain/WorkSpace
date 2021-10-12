import React from "react";

function ChildComponent(props) {
  return (
    <div>
      <button onClick={()=>props.greetParent('helloji')}>change parent</button>
    </div>
  );
}

export default ChildComponent;
