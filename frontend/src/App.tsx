import { useState } from 'react';
import "./App.css"
import InputField from "./Components/InputField";


const App: React.FC = () => {

  const [input, setInput] = useState<string>("")

  return (
    <div className="App">
      <span className="heading">Text Compressor</span>
      <InputField input={input} setInput={setInput} />
    </div>
  )
}


export default App
