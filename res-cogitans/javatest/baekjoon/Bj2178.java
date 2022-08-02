package javatest.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
백준 2178 미로 탐색
Class3, Silver1, Graph, BFS, https://www.acmicpc.net/problem/2178
 */
public class Bj2178 {
	private static int n;
	private static int m;
	private static int[][] maze;
	private static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		maze = new int[n][m];
		visited = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			char[] inputLine = br.readLine().toCharArray();
			for (int j = 0; j < m; j++) {
				maze[i][j] = (inputLine[j] == '1') ? 1 : 0;
			}
		}

		System.out.println(bfs());
	}

	private static int[] dy = {-1, 1, 0, 0};
	private static int[] dx = {0, 0, -1, 1};

	private static int bfs() {
		Queue<int[]> toVisit = new LinkedList<>();
		toVisit.offer(new int[] {0, 0});
		visited[0][0] = true;

		while (!toVisit.isEmpty()) {
			int[] visitNow = toVisit.poll();
			int y = visitNow[0];
			int x = visitNow[1];

			for (int i = 0; i < 4; i++) {
				if (((y + dy[i] < 0) || (y + dy[i] >= n)) || ((x + dx[i] < 0) || (x + dx[i] >= m))) {
					continue;
				}
				if (maze[y + dy[i]][x + dx[i]] == 0 || visited[y + dy[i]][x + dx[i]]) {
					continue;
				}
				visited[y + dy[i]][x + dx[i]] = true;
				toVisit.offer(new int[] {y + dy[i], x + dx[i]});
				maze[y + dy[i]][x + dx[i]] = maze[y][x] + 1;
			}
		}
		return maze[n - 1][m - 1];
	}
}
