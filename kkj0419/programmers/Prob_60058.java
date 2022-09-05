import java.util.Stack;

class Solution {
	public final Parenthesis OPEN_CHAR = new Parenthesis('(', true);
	public final Parenthesis CLOSE_CHAR = new Parenthesis(')', false);
	public StringBuilder sb = new StringBuilder();

	public String solution(String p) {
		return makeCorrectString(p);
	}

	private String makeCorrectString(String s) {
		if (s.length() == 0)
			return s;
		int index = findBalancedStringIndex(s);
		String u = s.substring(0, index + 1);
		String v = s.substring(index + 1, s.length());

		sb.append(makeCorrectString(v));
		if (isCorrect(u)) {    //3
			sb.insert(0, u);
		} else {            //4
			sb.insert(0, "(");
			sb.append(")");
			sb.append(convertString(u));
		}
		String result = sb.toString();
		sb.setLength(0);
		return result;
	}

	private int findBalancedStringIndex(String p) {
		char[] stringArray = p.toCharArray();
		int openCount = 0, closeCount = 0;
		for (int i = 0; i < stringArray.length; i++) {
			if (OPEN_CHAR.equalsFromChar(stringArray[i])) {
				openCount++;
			} else {
				closeCount++;
			}

			if (openCount == closeCount)
				return i;
		}
		return stringArray.length - 1;
	}

	private boolean isCorrect(String s) {
		char[] stringArray = s.toCharArray();
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < stringArray.length; i++) {
			char value = stringArray[i];
			Parenthesis c;
			if (OPEN_CHAR.equalsFromChar(value)) {//open
				stack.push(value);
			} else {								//close
				c = CLOSE_CHAR;
				if (!stack.isEmpty() && !c.equalsFromChar(stack.peek())) {
					stack.pop();
				} else {
					return false;
				}
			}
		}

		if (stack.isEmpty()) {
			return true;
		}
		return false;
	}

	private String convertString(String s) {
		StringBuilder builder = new StringBuilder();
		char[] stringArray = s.toCharArray();
		for (int i = 0; i < stringArray.length - 1; i++) {
			if (i == 0)
				continue;

			if (OPEN_CHAR.equalsFromChar(stringArray[i])) {
				builder.append(CLOSE_CHAR.value);
			} else {
				builder.append(OPEN_CHAR.value);
			}
		}
		return builder.toString();
	}
}

class Parenthesis {
	char value;
	Boolean isOpen;

	Parenthesis(char value, Boolean isOpen) {
		this.value = value;
		this.isOpen = isOpen;
	}

	public boolean equalsFromChar(char c) {
		return (value == c);
	}
}
