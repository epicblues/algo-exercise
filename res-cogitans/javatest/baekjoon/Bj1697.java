package javatest.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
백준 1697 숨바꼭질
Class3, Silver1, Graph, BFS, https://www.acmicpc.net/problem/1697
 */
public class Bj1697 {
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine(), " ");
		int start = Integer.parseInt(st.nextToken());
		int target = Integer.parseInt(st.nextToken());

		System.out.println(bfs(start, target));
	}

	public static int bfs(int start, int target) {
		if (start == target) {
			return 0;
		}

		boolean[] visited = new boolean[200001];
		Queue<int[]> toVisit = new LinkedList<>();
		toVisit.offer(new int[] {start, 0});

		visited[start] = true;

		while (!toVisit.isEmpty()) {
			int[] visitNow = toVisit.poll();
			int pos = visitNow[0];
			int time = visitNow[1];

			if (pos * 2 <= 200000 && !visited[pos * 2]) {
				if (pos * 2 == target) {
					return time + 1;
				}
				toVisit.offer(new int[] {pos * 2, time + 1});
				visited[pos * 2] = true;
			}
			if (pos - 1 >= 0 && !visited[pos - 1]) {
				if (pos - 1 == target) {
					return time + 1;
				}
				toVisit.offer(new int[] {pos - 1, time + 1});
				visited[pos - 1] = true;
			}
			if (pos + 1 <= 200000 && !visited[pos + 1]) {
				if (pos + 1 == target) {
					return time + 1;
				}
				toVisit.offer(new int[] {pos + 1, time + 1});
				visited[pos + 1] = true;
			}
		}

		throw new IllegalStateException();
	}
}
