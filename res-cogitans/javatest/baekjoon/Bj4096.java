package javatest.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
백준 4096 팰린드로미터
Silver5, BruteForce, https://www.acmicpc.net/problem/4096
 */
public class Bj4096 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = " ";

		StringBuilder sb = new StringBuilder();
		while (true) {
			input = br.readLine();
			if (input.equals("0")) {
				break;
			}
			int run = 0;
			while (!isPalindrome(input)) {
				input = add(input);
				run++;
			}
			sb.append(run).append("\n");
		}

		System.out.println(sb);
	}

	private static String add(String meter) {
		String after = String.valueOf(Integer.parseInt(meter) + 1);

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < meter.length() - after.length(); i++) {
			sb.append("0");
		}
		sb.append(after);

		return sb.toString();
	}
	private static boolean isPalindrome(String target) {
		for (int i = 0; i <target.length() / 2; i++) {
			if (target.charAt(i) != target.charAt(target.length() -1 - i)) {
				return false;
			}
		}
		return true;
	}
}
