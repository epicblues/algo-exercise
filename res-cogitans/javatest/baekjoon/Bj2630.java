package javatest.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
백준 2630 색종이 만들기
Class3, Silver2, Divide & Conquer, https://www.acmicpc.net/problem/2630
 */
public class Bj2630 {
	static boolean[][] board;
	static int blue;
	static int white;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		board = new boolean[n][n];

		StringTokenizer st;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				board[i][j] = st.nextToken().equals("1");
			}
		}

		countBAndW(0, 0, n);

		System.out.println(white + "\n" + blue);
	}

	private static void countBAndW(int startY, int startX, int size) {
		boolean isBlue = board[startY][startX];
		boolean stop = false;

		for (int i = startY; i < startY + size; i++) {
			for (int j = startX; j < startX + size; j++) {
				if ((isBlue && !board[i][j]) || (!isBlue && board[i][j])) {
					stop = true;
				}
			}

			if (stop) {
				break;
			}
		}

		if (stop) {
			countBAndW(startY, startX, size / 2);
			countBAndW(startY + size / 2, startX, size / 2);
			countBAndW(startY, startX + size / 2, size / 2);
			countBAndW(startY + size / 2, startX + size / 2, size / 2);
		} else {
			if (isBlue) {
				blue++;
			} else {
				white++;
			}
		}
	}
}
