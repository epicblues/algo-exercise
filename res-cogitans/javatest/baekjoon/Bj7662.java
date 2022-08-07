package javatest.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
백준 7662 이중 우선순위 큐
Class3, Gold4, Heap, https://www.acmicpc.net/problem/7662
 */
public class Bj7662 {
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			DoublePriorityQueue queue = new DoublePriorityQueue(n);
			StringTokenizer st;
			while (n-- > 0) {
				st = new StringTokenizer(br.readLine(), " ");
				String input = st.nextToken();
				int x = Integer.parseInt(st.nextToken());
				if (input.equals("I")) {
					queue.offer(x);
				} else {
					if (x == 1) {
						queue.pollMax();
					} else {
						queue.pollMin();
					}
				}
			}

			if (queue.lastIndex == 0) {
				sb.append("EMPTY");
			} else {
				sb.append(queue.peekMax()).append(" ").append(queue.peekMin());
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}

	private static class DoublePriorityQueue {
		private int[] elementsMin;            //최소 힙
		private int[] elementsMax;            //최대 힙
		private int lastIndex = 0;

		public DoublePriorityQueue(int size) {
			this.elementsMin = new int[size + 1];
			this.elementsMax = new int[size + 1];
		}

		public int peekMin() {
			return elementsMin[1];
		}

		public int peekMax() {
			return elementsMax[1];
		}

		public void offer(int x) {
			elementsMin[++lastIndex] = x;
			elementsMax[lastIndex] = x;

			sortUpward();
		}

		public void pollMin() {
			if (lastIndex == 0) {
				return;
			}

			int result = elementsMin[1];
			if (lastIndex == 1) {
				lastIndex--;
				return;
			}

			elementsMin[1] = elementsMin[lastIndex];
			int deletedMaxIndex = deleteMax(result);
			lastIndex--;

			sortUpwardMax(deletedMaxIndex);
			sortDownwardMax(deletedMaxIndex);
			sortDownwardMin(1);
		}

		public void pollMax() {
			if (lastIndex == 0) {
				return;
			}

			int result = elementsMax[1];
			if (lastIndex == 1) {
				lastIndex--;
				return;
			}
			elementsMax[1] = elementsMax[lastIndex];
			int deletedMinIndex = deleteMin(result);
			lastIndex--;

			sortUpwardMin(deletedMinIndex);
			sortDownwardMin(deletedMinIndex);
			sortDownwardMax(1);
		}

		private int deleteMax(int toDelete) {
			int index = lastIndex;
			while (elementsMax[index] != toDelete) {
				index--;
			}

			swapMax(index, lastIndex);
			return index;
		}

		private int deleteMin(int toDelete) {
			int index = lastIndex;
			while (elementsMin[index] != toDelete) {
				index--;
			}

			swapMin(index, lastIndex);
			return index;
		}

		private void sortUpward() {
			sortUpwardMin(lastIndex);
			sortUpwardMax(lastIndex);
		}

		private void sortUpwardMin(int startIndex) {
			int index = startIndex;
			while (index / 2 >= 1) {
				if (elementsMin[index] < elementsMin[index / 2]) {
					swapMin(index, index / 2);
					index /= 2;
				} else {
					break;
				}
			}
		}

		private void sortUpwardMax(int startIndex) {
			int index = startIndex;
			while (index / 2 >= 1) {
				if (elementsMax[index] > elementsMax[index / 2]) {
					swapMax(index, index / 2);
					index /= 2;
				} else {
					break;
				}
			}
		}

		private void sortDownwardMin(int startIndex) {
			int index = startIndex;
			while (index * 2 <= lastIndex) {
				int swapIndex;
				if (index * 2 + 1 <= lastIndex) {
					if (elementsMin[index] > elementsMin[index * 2]
						|| elementsMin[index] > elementsMin[index * 2 + 1]) {
						swapIndex = (elementsMin[index * 2] < elementsMin[index * 2 + 1]) ? index * 2 : index * 2 + 1;
					} else {
						break;
					}
				} else {
					if (elementsMin[index] > elementsMin[index * 2]) {
						swapIndex = index * 2;
					} else {
						break;
					}
				}
				swapMin(index, swapIndex);
				index = swapIndex;
			}
		}

		private void sortDownwardMax(int startIndex) {
			int index = startIndex;
			while (index * 2 <= lastIndex) {
				int swapIndex;
				if (index * 2 + 1 <= lastIndex) {
					if (elementsMax[index] < elementsMax[index * 2]
						|| elementsMax[index] < elementsMax[index * 2 + 1]) {
						swapIndex = (elementsMax[index * 2] > elementsMax[index * 2 + 1]) ? index * 2 : index * 2 + 1;
					} else {
						break;
					}
				} else {
					if (elementsMax[index] < elementsMax[index * 2]) {
						swapIndex = index * 2;
					} else {
						break;
					}
				}
				swapMax(index, swapIndex);
				index = swapIndex;
			}
		}

		private void swapMin(int index1, int index2) {
			int tmp = elementsMin[index1];
			elementsMin[index1] = elementsMin[index2];
			elementsMin[index2] = tmp;
		}

		private void swapMax(int index1, int index2) {
			int tmp = elementsMax[index1];
			elementsMax[index1] = elementsMax[index2];
			elementsMax[index2] = tmp;
		}
	}
}