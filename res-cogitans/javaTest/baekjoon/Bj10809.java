package javaTest.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj10809 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] string = br.readLine().toCharArray();

		StringBuilder sb = new StringBuilder();
		for (char c = 'a'; c <= 'z'; c++) {
			sb.append(checkTheLetterIsIn(c, string)).append(" ");
		}

		System.out.println(sb);
	}

	private static int checkTheLetterIsIn(char c, char[] string) {
		for (int i = 0; i < string.length; i++) {
			if (c == string[i]) {
				return i;
			}
		}
		return -1;
	}
}