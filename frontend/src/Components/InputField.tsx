import React from "react";
import "./styles.css";

interface InputFieldProps {
    input: string;
    setInput: (input: string) => void;
}

const InputField: React.FC<InputFieldProps> = ({input, setInput}) => {

    const handleAdd = async (e: MouseEvent, action: string) => {

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

        </div>
    )
}

export default InputField;