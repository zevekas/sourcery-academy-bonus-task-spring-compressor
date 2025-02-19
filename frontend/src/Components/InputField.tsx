import React, {useState} from "react";
import "./styles.css";

interface InputFieldProps {
    input: string;
    setInput: (input: string) => void;
}

const InputField: React.FC<InputFieldProps> = ({input, setInput}) => {

    const [answer, setAnswer] = useState<string>("")

    const handleAdd = async (e: React.MouseEvent<HTMLButtonElement, MouseEvent>, action: string) => {
        e.preventDefault();

        try {
            const response = await fetch(`http://localhost:8080/api/${action}/${input}`, {method: "GET"});
            if (!response.ok) {
                throw new Error(`HTTP error! Status: ${response.status}`);
            }
            const converted: string = await response.text();
            setAnswer(converted);
            setInput("");
        } catch (error) {
            console.error("Failed to fetch:", error);
        }
    }

    return (
        <div>
            <form className="input">
                <input
                    type="input"
                    value={input}
                    onChange={(e) => setInput(e.target.value)}
                    placeholder="Enter a string..."
                    className="input_box"
                />
            </form>
            <form className="input">
                <button className="button" onClick={(e) =>
                    handleAdd(e, "compress")}>
                    Compress
                </button>
                <button className="button" onClick={(e) =>
                    handleAdd(e, "decompress")}>
                    Decompress
                </button>
            </form>
            <form className="input">
                <span className="answer">
                {answer}
            </span>
            </form>

        </div>
    )
}

export default InputField;