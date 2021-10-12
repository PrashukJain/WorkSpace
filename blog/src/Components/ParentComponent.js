import React, { Component } from "react";
import ChildComponent from "./ChildComponent";

export default class ParentComponent extends Component {
  constructor() {
    super();
    this.state = {
      wordParent: "parent",
    };
    this.greetChange = this.greetChange.bind(this);
  }
  greetChange(message) {
    this.setState(
      () => ({
        wordParent: "child",
      }),
      () => console.log(this.state.wordParent)
    );
    console.log(message);
  }
  render() {
    return (
      <div>
        <ChildComponent greetParent={this.greetChange} />
      </div>
    );
  }
}
