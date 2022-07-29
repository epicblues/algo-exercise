package javatest.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
백준 11727 2×n 타일링 2
Class3, Silver3, DP, https://www.acmicpc.net/problem/11727
 */
public class Bj11727 {
	static long[] cache;
	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
		if (n == 1) {
			System.out.println(1);
			return;
		}
		cache = new long[n + 1];
		cache[1] = 1;
		cache[2] = 3;
		System.out.println(getWaysCountOf(n));
	}

	private static long getWaysCountOf(int length) {
		if (cache[length] == 0) {
			cache[length] = (getWaysCountOf(length - 1) + 2 * getWaysCountOf(length -2)) % 10007;
		}
		return cache[length];
	}
}
