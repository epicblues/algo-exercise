package javatest.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
백준 1904 01타일
Silver3, DP, https://www.acmicpc.net/problem/1904
 */
public class Bj1904 {
	static int[] cache;

	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
		cache = new int[n + 1];
		System.out.println(fibo(n));
	}

	private static int fibo(int index) {
		if (index == 1) {
			return 1;
		}
		if (index == 2) {
			return 2;
		}
		if (cache[index] == 0) {
			cache[index] = (fibo(index - 2) + fibo(index - 1)) % 15746;
		}
		return cache[index];
	}
}