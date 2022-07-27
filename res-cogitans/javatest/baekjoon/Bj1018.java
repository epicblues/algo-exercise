package javatest.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj1018 {
	static char[][] givenBoard;
	static char[][] expectedBoardA = {
		{'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
		{'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
		{'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
		{'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
		{'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
		{'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
		{'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
		{'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'}
	};
	static char[][] expectedBoardB = {
		{'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
		{'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
		{'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
		{'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
		{'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
		{'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
		{'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
		{'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'}
	};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		givenBoard = new char[n][m];

		for (int i = 0; i < n; i++) {
			givenBoard[i] = br.readLine().toCharArray();
		}

		int best = 65;
		for (int i = 0; i + 8 <= n; i++) {
			for (int j = 0; j + 8 <= m; j++) {
				best = Math.min(best, countNeedToPaint(i, j));
			}
		}

		System.out.println(best);
	}

	private static int countNeedToPaint(int startY, int startX) {
		return Math.min(checkFor(startY, startX, true), checkFor(startY, startX, false));
	}

	private static int checkFor(int startY, int startX, boolean isBoardIsA) {
		char[][] toCheck;
		if (isBoardIsA) {
			toCheck = expectedBoardA;
		} else {
			toCheck = expectedBoardB;
		}
		int toPaint = 0;
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (givenBoard[i + startY][j + startX] != toCheck[i][j]) {
					toPaint++;
				}
			}
		}

		return toPaint;
	}
}
