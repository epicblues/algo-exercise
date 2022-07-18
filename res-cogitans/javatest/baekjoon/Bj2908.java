package javatest.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj2908 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int a = getReverseNumber(st.nextToken());
		int b = getReverseNumber(st.nextToken());

		System.out.println((a > b) ? a : b);
	}

	private static int getReverseNumber(String s) {
		char[] chars = s.toCharArray();
		int result = 0;
		for (int i = chars.length - 1; i >= 0; i--) {
			result += Character.getNumericValue(chars[i]) * ((int)Math.pow(10, i));
		}
		return result;
	}
}
