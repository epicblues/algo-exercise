package javatest.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
백준 7562 나이트의 이동
Silver1, Graph, BFS https://www.acmicpc.net/problem/7562
 */
public class Bj7562 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());        //체스판 한 변의 길이

		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		while (t-- > 0) {
			int l = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine(), " ");
			int startY = Integer.parseInt(st.nextToken());
			int startX = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine(), " ");
			int targetY = Integer.parseInt(st.nextToken());
			int targetX = Integer.parseInt(st.nextToken());

			sb.append(bfs(new int[]{startY, startX}, new int[]{targetY, targetX}, l)).append("\n");
		}
		System.out.println(sb);
	}

	public static int bfs(int[] start, int[] target, int l) {
		if (start[0] == target[0] && start[1] == target[1]) {
			return 0;
		}

		Queue<int[]> toVisit = new LinkedList<>();
		toVisit.offer(new int[] {start[0], start[1], 0});
		boolean[][] visited = new boolean[l][l];

		while (!toVisit.isEmpty()) {
			int[] visitNow = toVisit.poll();
			int y = visitNow[0];
			int x = visitNow[1];
			int time = visitNow[2];

			for (int i = 0; i < 8; i++) {
				if (y + dy[i] >= 0 && y + dy[i] < l && x + dx[i] >= 0 && x + dx[i] < l && !visited[y + dy[i]][x
					+ dx[i]]) {
					visited[y + dy[i]][x + dx[i]] = true;
					if (y + dy[i] == target[0] && x + dx[i] == target[1]) {
						return time + 1;
					}
					toVisit.offer(new int[] {y + dy[i], x + dx[i], time + 1});
				}
			}
		}

		throw new IllegalStateException();
	}

	static int[] dy = {-1, -2, -2, -1, 1, 2, 2, 1};
	static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
}
