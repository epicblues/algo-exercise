package javatest.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj11050 {
	static int[][] cache = new int[11][11];

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		System.out.println(getBino(n, k));
	}

	public static int getBino(int n, int k) {
		if (k == 0 || n == k) {
			return 1;
		}
		if (cache[n][k] == 0) {
			cache[n][k] = getBino(n - 1, k - 1) + getBino(n - 1, k);
		}
		return cache[n][k];
	}
}
