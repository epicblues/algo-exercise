package javatest.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
백준 11286 절대값 힙
Class3, Silver1, Heap, https://www.acmicpc.net/problem/11286
 */
public class Bj11286 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		Comparator<Integer> comparator = (o1, o2) -> {
			int abs1 = Math.abs(o1);
			int abs2 = Math.abs(o2);
			return (abs1 == abs2) ? o1 - o2 : abs1 - abs2;
		};
		PriorityQueue<Integer> absHeap = new PriorityQueue<>(n, comparator);

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			int input = Integer.parseInt(br.readLine());

			if (input == 0) {
				sb.append((absHeap.isEmpty()) ? 0 : absHeap.poll()).append("\n");
			} else {
				absHeap.offer(input);
			}
		}
		System.out.println(sb);
	}
}
