package javatest.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
백준 7576 토마토
Class3, Gold5, Graph, BFS, https://www.acmicpc.net/problem/7576
 */
public class Bj7576 {
	private static int m;
	private static int n;
	private static int[][] store;
	private static boolean[][] visited;
	private static Queue<int[]> toVisit = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		m = Integer.parseInt(st.nextToken());    //가로
		n = Integer.parseInt(st.nextToken());    //세로

		store = new int[n][m];
		visited = new boolean[n][m];

		boolean earlyEnd = true;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				int input = Integer.parseInt(st.nextToken());
				if (input == 1) {
					toVisit.offer(new int[] {i, j});
				}
				if (input == 0) {
					earlyEnd = false;
				}
				store[i][j] = input;
			}
		}

		if (earlyEnd) {
			System.out.println(0);
			return;
		}

		bfs();

		int max = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (store[i][j] == 0) {
					System.out.println(-1);
					return;
				}
				max = Math.max(max, store[i][j]);
			}
		}

		System.out.println(max - 1);
	}

	private static void bfs() {
		toVisit.forEach((p) -> visited[p[0]][p[1]] = true);
		while (!toVisit.isEmpty()) {
			int[] visitNow = toVisit.poll();
			int y = visitNow[0];
			int x = visitNow[1];

			for (int i = 0; i < 4; i++) {
				int nextY = y + dy[i];
				int nextX = x + dx[i];

				if ((nextY < 0) || (nextY >= n) || (nextX < 0) || (nextX >= m)) {
					continue;
				}
				if ((visited[nextY][nextX]) || (store[nextY][nextX] == -1)) {
					continue;
				}

				visited[nextY][nextX] = true;
				toVisit.offer(new int[]{nextY, nextX});
				store[nextY][nextX] = store[y][x] + 1;
			}
		}
	}

	private static int[] dy = {-1, 1, 0, 0};
	private static int[] dx = {0, 0, -1, 1};
}
