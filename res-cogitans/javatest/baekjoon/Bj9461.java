package javatest.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
백준 9461 파도반 수열
Class3, Silver3, DP, https://www.acmicpc.net/problem/9461
 */
public class Bj9461 {
	static long cache[] = new long[101];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		while (t-- > 0) {
			sb.append(fibo(Integer.parseInt(br.readLine()))).append("\n");
		}

		System.out.println(sb);
	}

	private static long fibo(int i) {
		if (i <= 3) {
			return 1;
		}
		if (cache[i] == 0) {
			cache[i] = fibo(i - 3) + fibo(i - 2);
		}
		return cache[i];
	}
}
