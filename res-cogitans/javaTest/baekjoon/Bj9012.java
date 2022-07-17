package javaTest.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Bj9012 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			checkVps(br.readLine().toCharArray());
		}
	}

	private static void checkVps(char[] c) {
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < c.length; i++) {
			if (c[i] == '(') {
				stack.push('(');
			}
			else {
				if (stack.isEmpty()) {
					System.out.println("NO");
					return;
				}
				else {
					stack.pop();
				}
			}
		}
		if (stack.isEmpty()) {
			System.out.println("YES");
		}
		else {
			System.out.println("NO");
		}
	}
}