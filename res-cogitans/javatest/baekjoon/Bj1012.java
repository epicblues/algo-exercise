package javatest.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
백준 1012 유기농 배추
Class3, Silver2, DP, https://www.acmicpc.net/problem/1012
 */
public class Bj1012 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < t; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());            //가로 길이
			int m = Integer.parseInt(st.nextToken());            //세로 길이
			int k = Integer.parseInt(st.nextToken());            //배추의 수
			boolean[][] isVegetableExist = new boolean[m][n];
			boolean[][] visited = new boolean[m][n];
			int cnt = 0;
			for (int j = 0; j < k; j++) {
				st = new StringTokenizer(br.readLine(), " ");
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				isVegetableExist[y][x] = true;
			}
			for (int j = 0; j < m; j++) {
				for (int l = 0; l < n; l++) {
					cnt += (isBugNeededSearch(j, l, isVegetableExist, visited)) ? 1 : 0;
				}
			}
			sb.append(cnt).append("\n");
		}
		System.out.println(sb);
	}

	private static boolean isBugNeededSearch(int y, int x, boolean[][] isVegetableExist, boolean[][] visited) {
		if (visited[y][x]) {
			return false;
		}
		visited[y][x] = true;
		if (!isVegetableExist[y][x]) {
			return false;
		}
		if (y > 0) {
			isBugNeededSearch(y - 1, x, isVegetableExist, visited);
		}
		if (x > 0) {
			isBugNeededSearch(y, x - 1, isVegetableExist, visited);

		}
		if (y < visited.length - 1) {
			isBugNeededSearch(y + 1, x, isVegetableExist, visited);
		}
		if (x < visited[0].length - 1) {
			isBugNeededSearch(y, x + 1, isVegetableExist, visited);
		}

		return true;
	}
}
