import React from "react";

function Event() {

  return (
    <div>
      <button onClick={clickme}>click</button>
    </div>
  );
}
function clickme() {
    console.log("Button clicked");
  }
export default Event;
