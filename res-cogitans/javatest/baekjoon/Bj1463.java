package javatest.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
백준 1463 1로 만들기
Class3, Silver3, DP, https://www.acmicpc.net/problem/1463
 */
public class Bj1463 {
	static Integer[] cache = new Integer[1000001];

	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
		cache[1] = 0;
		cache[2] = 1;
		cache[3] = 1;
		System.out.println(getMinimum(n));
	}

	private static int getMinimum(int n) {
		if (cache[n] != null) {
			return cache[n];
		}
		if (n % 6 == 0) {
			cache[n] = Math.min(Math.min(getMinimum(n / 3), getMinimum(n / 2)), getMinimum(n - 1)) +1;
			return cache[n];
		}
		if (n % 3 == 0) {
			cache[n] = Math.min(getMinimum(n / 3), getMinimum(n - 1)) + 1;
			return cache[n];
		}
		if (n % 2 == 0) {
			cache[n] = Math.min(getMinimum(n / 2), getMinimum(n - 1)) + 1;
			return cache[n];
		}
		cache[n] = getMinimum(n - 1) + 1;
		return cache[n];
	}
}
