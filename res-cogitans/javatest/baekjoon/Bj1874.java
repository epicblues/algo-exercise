package javatest.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Bj1874 {
	static StringBuilder sb = new StringBuilder();
	static int n;
	static CustomStack stack;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		int[] target = new int[n];
		for (int i = 0; i < n; i++) {
			target[i] = Integer.parseInt(br.readLine());
		}

		stack = new CustomStack();
		for (int i = 0; i < n; i++) {
			try {
				get(target[i]);
			} catch (IllegalArgumentException e) {
				System.out.println("NO");
				return;
			}
		}

		System.out.println(sb);
	}

	private static void get(int target) {
		while (stack.seq <= n || target == stack.top()) {
			if (target == stack.top()) {
				stack.pop();
				return;
			} else {
				stack.push();
			}
		}
		throw new IllegalArgumentException("주어진 수열을 만들 수 없음");
	}

	static class CustomStack {
		LinkedList<Integer> elements = new LinkedList<>();
		int seq = 1;

		public void push() {
			elements.addLast(seq++);
			sb.append("+\n");
		}

		public void pop() {
			elements.removeLast();
			sb.append("-\n");
		}

		public int top() {
			return (elements.isEmpty()) ? 0 : elements.peekLast();
		}
	}
}