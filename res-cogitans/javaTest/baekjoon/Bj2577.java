package javaTest.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj2577 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] n = new int[3];
		for (int i = 0; i < 3; i++) {
			n[i] = Integer.parseInt(br.readLine());
		}

		int[] result = new int[10];
		char[] product = Integer.toString(n[0] * n[1] * n[2]).toCharArray();
		for (char c : product) {
			result[Character.getNumericValue(c)]++;
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 10; i++) {
			sb.append(result[i]).append("\n");
		}
		System.out.println(sb);
	}
}
