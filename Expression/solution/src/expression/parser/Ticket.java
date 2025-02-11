package expression.parser;

public interface Ticket {
    static KeyWord convertToKeyWord(String chr) {
        return switch (chr) {
            case "(" -> KeyWord.LEFT_BRACKET;
            case ")" -> KeyWord.RIGHT_BRACKET;
            case "+" -> KeyWord.ADD;
            case "-" -> KeyWord.SUBTRACT;
            case "*" -> KeyWord.MULTIPLY;
            case "/" -> KeyWord.DIVIDE;
            case "set" -> KeyWord.SET;
            case "clear" -> KeyWord.CLEAR;
            case "x" -> KeyWord.X;
            case "y" -> KeyWord.Y;
            case "z" -> KeyWord.Z;
            default -> throw new IllegalArgumentException("I give up (made in Verilog)");
        };
    }
    static KeyWord convertToKeyWord(char chr) {
        return convertToKeyWord(String.valueOf(chr));
    }

}
