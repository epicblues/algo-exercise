package javaTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Bj10828 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		MyStack<Integer> stack = new MyStack<>();

		for (int i = 0; i < n; i++) {
			execute(br.readLine(), stack);
		}
	}

	private static void execute(String input, MyStack stack) {
		StringTokenizer st = new StringTokenizer(input, " ");
		String command = st.nextToken();

		int pushValue = 0;
		if (st.hasMoreTokens()) {
			pushValue = Integer.parseInt(st.nextToken());
		}

		switch (command) {
			case "push": {
				stack.push(pushValue);
				break;
			}
			case "pop": {
				stack.pop();
				break;
			}
			case "size": {
				stack.size();
				break;
			}
			case "empty": {
				stack.empty();
				break;
			}
			case "top": {
				stack.top();
				break;
			}
			default: throw new IllegalArgumentException("invalid command");
		}
	}

	static class MyStack<E> {
		private List<E> elements = new ArrayList<>();
		private int size = 0;

		public void push(E e) {
			elements.add(size++, e);
		}

		public void pop() {
			if (size == 0) {
				System.out.println("-1");
			} else {
				System.out.println(elements.get(--size));
				elements.remove(size);
			}
		}

		public void size() {
			System.out.println(size);
		}

		public void empty() {
			if (size == 0) {
				System.out.println("1");
			} else {
				System.out.println("0");
			}
		}

		public void top() {
			if (size == 0) {
				System.out.println("-1");
			} else {
				System.out.println(elements.get(size - 1));
			}
		}
	}
}
