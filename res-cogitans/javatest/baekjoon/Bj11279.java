package javatest.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

/*
백준 11279 최대 힙
Class3, Silver2, Heap, https://www.acmicpc.net/problem/11279
 */
public class Bj11279 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> heap = new PriorityQueue<>(n, Collections.reverseOrder());

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < n; i++) {
			int input = Integer.parseInt(br.readLine());
			if (input == 0) {
				sb.append((heap.isEmpty()) ? 0: heap.poll()).append("\n");
			} else {
				heap.offer(input);
			}
		}

		System.out.println(sb);
	}
}
