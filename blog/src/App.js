import logo from './logo.svg';
import './App.css';
import Greet from './Components/Greet'
import Message from './Components/Message'
import Counter from './Components/Counter';
import Event from'./Components/Event';
import ParentComponent from './Components/ParentComponent';
import IfElse from './Components/IfElse';
import RefsDemo from './Components/RefsDemo';
import HookCounterTwo from './Components/HookCounterTwo'
function App() {
  return (
    <div className="App">
      <HookCounterTwo/>
      {/* <RefsDemo /> */}
      {/* <IfElse/> */}
      {/* <ParentComponent /> */}
      {/* <Event/> */}
      {/* <Counter /> */}
     {/* <Message /> */}
      {/* <Greet name="Prashuk"/> */}
   
    </div>
  );
}

export default App;
