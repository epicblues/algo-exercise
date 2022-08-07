package javatest.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
백준 12851 숨바꼭질2
Class4, Gold4, Graph, BFS, https://www.acmicpc.net/problem/12851
 */
public class Bj12851 {
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine(), " ");
		int start = Integer.parseInt(st.nextToken());
		int target = Integer.parseInt(st.nextToken());

		int[] result = bfs(start, target);
		System.out.println(result[0] + "\n" + result[1]);
	}

	public static int[] bfs(int start, int target) {
		if (start == target) {
			return new int[] {0, 1};
		}

		int[] visited = new int[200001];
		Queue<int[]> toVisit = new LinkedList<>();
		toVisit.offer(new int[] {start, 0});

		visited[start] = 1;
		int bestTime = -1;
		int cnt = 0;

		while (!toVisit.isEmpty()) {
			int[] visitNow = toVisit.poll();
			int pos = visitNow[0];
			int time = visitNow[1];

			if (pos * 2 <= 200000 && (visited[pos * 2] == 0 || visited[pos * 2] >= time + 1)) {
				if (pos * 2 == target) {

					if (bestTime == -1) {
						bestTime = time + 1;
						cnt++;
					} else {
						if (bestTime - 1 == time) {
							cnt++;
						}
					}
				} else {
					visited[pos * 2] = time + 1;
					if (bestTime == -1 || bestTime - 1 > time) {
						toVisit.offer(new int[] {pos * 2, time + 1});
					}
				}
			}

			if (pos - 1 >= 0 && (visited[pos - 1] == 0 || visited[pos - 1] >= time + 1)) {
				if (pos - 1 == target) {

					if (bestTime == -1) {
						bestTime = time + 1;
						cnt++;
					} else {
						if (bestTime - 1 == time) {
							cnt++;
						}
					}
				} else {
					visited[pos - 1] = time + 1;
					if (bestTime == -1 || bestTime - 1 > time) {
						toVisit.offer(new int[] {pos - 1, time + 1});
					}
				}
			}

			if (pos + 1 <= 200000 && (visited[pos + 1] == 0 || visited[pos + 1] >= time + 1)) {
				if (pos + 1 == target) {

					if (bestTime == -1) {
						bestTime = time + 1;
						cnt++;
					} else {
						if (bestTime - 1 == time) {
							cnt++;
						}
					}
				} else {
					visited[pos + 1] = time + 1;
					if (bestTime == -1 || bestTime - 1 > time) {
						toVisit.offer(new int[] {pos + 1, time + 1});
					}
				}
			}
		}
		return new int[] {bestTime, cnt};
	}
}