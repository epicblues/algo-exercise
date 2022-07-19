package javatest.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Bj4949 {

	static final char PARENTHESES_OPEN = '(';
	static final char PARENTHESES_CLOSE = ')';
	static final char BRACKET_OPEN = '[';
	static final char BRACKET_CLOSE = ']';
	static final char[] BRACKETS_OPEN = {PARENTHESES_OPEN, BRACKET_OPEN};
	static final char[] BRACKETS_CLOSE = {PARENTHESES_CLOSE, BRACKET_CLOSE};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String input = "";
		while (true) {
			input = br.readLine();
			if (input.equals(".")) {
				break;
			}
			sb.append((isBalanced(input.toCharArray())) ? "yes" : "no").append("\n");
		}
		System.out.println(sb);
	}

	public static boolean isBalanced(char[] input) {
		Deque<Character> stack = new ArrayDeque<>();
		for (int i = 0; i < input.length; i++) {
			if (isOpenBracket(input[i])) {
				stack.push(input[i]);
			} else if (isCloseBracket(input[i])) {
				if (stack.isEmpty()) {
					return false;
				}
				char bracketAtTop = stack.pop();
				if (isProperClosing(bracketAtTop, input[i])) {
					continue;
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

	private static boolean isProperClosing(char bracketAtTop, char input) {
		return (input == PARENTHESES_CLOSE && bracketAtTop == PARENTHESES_OPEN)
			|| input == BRACKET_CLOSE && bracketAtTop == BRACKET_OPEN;
	}

	public static boolean isOpenBracket(char c) {
		for (char b : BRACKETS_OPEN) {
			if (b == c) {
				return true;
			}
		}
		return false;
	}

	public static boolean isCloseBracket(char c) {
		for (char b : BRACKETS_CLOSE) {
			if (b == c) {
				return true;
			}
		}
		return false;
	}
}
