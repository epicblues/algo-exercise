package javatest.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
백준 2579 계단 오르기
Class3, Silver3, DP, https://www.acmicpc.net/problem/2579
 */
public class Bj2579 {
	static int[] stairs;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		stairs = new int[n];
		for (int i = 0; i < n; i++) {
			stairs[i] = Integer.parseInt(br.readLine());
		}
		cacheOfJump = new Integer[n];
		cacheOfNoJump = new Integer[n];

		System.out.println(getPointOf(n - 1, false));
	}

	static Integer[] cacheOfJump;
	static Integer[] cacheOfNoJump;

	private static int getPointOf(int targetIndex, boolean forcedJump) {
		if (targetIndex < 0) {
			return 0;
		}
		if (forcedJump) {
			if (cacheOfJump[targetIndex] == null) {
				cacheOfJump[targetIndex] = stairs[targetIndex] + getPointOf(targetIndex - 2, false);
			}
			return cacheOfJump[targetIndex];
		}
		if (cacheOfNoJump[targetIndex] == null) {
			cacheOfNoJump[targetIndex] = stairs[targetIndex] + Math.max(getPointOf(targetIndex - 1, true), getPointOf(targetIndex - 2, false));
		}
		return cacheOfNoJump[targetIndex];
	}
}
