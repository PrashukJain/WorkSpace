import React from "react";

// export default function Greet() {
//   return <h1>Hello Prashuk</h1>;
// }
// export const Greet = () => <h1>Hello</h1>;

// export default Greet;

/*******************
JSX
*********************/

// export default function Greet() {
//     return (
//       React.createElement('div',{id:'hello',className:'dummyClass'},React.createElement('h1',null,"Hello"))
//     )
// }

/*
Props
*/


export default function Greet(props) {
    return (
        <>
       <h1>hello {props.name}</h1>
       </>
    )
}

