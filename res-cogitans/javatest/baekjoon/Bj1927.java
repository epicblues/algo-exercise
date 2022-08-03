package javatest.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
백준 1927 최소 힙
Class3, Silver2, Heap, https://www.acmicpc.net/problem/1927
 */
public class Bj1927 {
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		MinHeap heap = new MinHeap(n);
		for (int i = 0; i < n; i++) {
			int input = Integer.parseInt(br.readLine());
			if (input == 0) {
				sb.append(heap.get()).append("\n");
			} else {
				heap.put(input);
			}
		}
		System.out.println(sb);
	}

	private static class MinHeap {
		int[] elements;
		int lastIndex = 0;                            //현재 size

		public MinHeap(int n) {
			this.elements = new int[n + 1];
		}

		public void put(int x) {
			elements[++lastIndex] = x;
			sortUpwards();
		}

		private void sortUpwards() {
			int index = lastIndex;
			while (index > 1 && elements[index] < elements[index / 2]) {
				swap(index, index / 2);

				index /= 2;
			}
		}

		public int get() {
			if (lastIndex == 0) {
				return 0;
			}

			int result = elements[1];

			if (lastIndex == 1) {
				lastIndex--;
				return result;
			}

			swap(1, lastIndex);

			lastIndex--;

			sortDownWards();

			return result;
		}

		private void sortDownWards() {
			int index = 1;
			while (index * 2 <= lastIndex) {
				if (elements[index] < elements[index * 2] &&
					(index * 2 + 1 > lastIndex || elements[index] < elements[index * 2 + 1])) {
					break;
				}
				int nextIndex = index * 2;
				if (index * 2 + 1 <= lastIndex && elements[index * 2 + 1] < elements[index * 2]) {
					nextIndex = index * 2 + 1;
				}
				swap(index, nextIndex);

				index = nextIndex;
			}
		}

		private void swap(int index1, int index2) {
			int tmp = elements[index1];
			elements[index1] = elements[index2];
			elements[index2] = tmp;
		}
	}
}
