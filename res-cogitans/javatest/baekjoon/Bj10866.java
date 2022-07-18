package javatest.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class Bj10866 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		MyDeque deque = new MyDeque();

		for (int i = 0; i < n; i++) {
			String[] input = br.readLine().split(" ");
			switch (input[0]) {
				case "push_front": {
					deque.pushFront(Integer.parseInt(input[1]));
					break;
				}
				case "push_back": {
					deque.pushBack(Integer.parseInt(input[1]));
					break;
				}
				case "pop_front": {
					deque.popFront();
					break;
				}
				case "pop_back": {
					deque.popBack();
					break;
				}
				case "size": {
					deque.size();
					break;
				}
				case "empty": {
					deque.empty();
					break;
				}
				case "front": {
					deque.front();
					break;
				}
				case "back": {
					deque.back();
					break;
				}
				default:
					throw new IllegalArgumentException("IllegalCommand");
			}
		}

	}

	static class MyDeque {
		private LinkedList<Integer> elements = new LinkedList<>();

		public void pushFront(int x) {
			elements.addFirst(x);
		}

		public void pushBack(int x) {
			elements.addLast(x);
		}

		public void popFront() {
			try {
				Integer removed = elements.removeFirst();
				System.out.println(removed);
			} catch (NoSuchElementException e) {
				System.out.println(-1);
			}
		}

		public void popBack() {
			try {
				Integer removed = elements.removeLast();
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
