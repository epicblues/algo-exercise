package javatest.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class Bj10845 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		MyQueue queue = new MyQueue();

		for (int i = 0; i < n; i++) {
			String[] input = br.readLine().split(" ");
			switch (input[0]) {
				case "push": {
					queue.push(Integer.parseInt(input[1]));
					break;
				}
				case "pop": {
					queue.pop();
					break;
				}
				case "size": {
					queue.size();
					break;
				}
				case "empty": {
					queue.empty();
					break;
				}
				case "front": {
					queue.front();
					break;
				}
				case "back": {
					queue.back();
					break;
				}
				default:
					throw new IllegalArgumentException("IllegalCommand");
			}
		}
	}

	static class MyQueue {
		private LinkedList<Integer> elements = new LinkedList<>();

		public void push(int i) {
			elements.add(i);
		}

		public void pop() {
			try {
				Integer removed = elements.removeFirst();
				System.out.println(removed);
			} catch (NoSuchElementException e) {
				System.out.println(-1);
			}
		}

		public void size() {
			System.out.println(elements.size());
		}

		public void empty() {
			System.out.println((elements.isEmpty()) ? 1 : 0);
		}

		public void front() {
			try {
				System.out.println(elements.getFirst());
			} catch (NoSuchElementException e) {
				System.out.println(-1);
			}
		}

		public void back() {
			try {
				System.out.println(elements.getLast());
			} catch (NoSuchElementException e) {
				System.out.println(-1);
			}
		}
	}
}
