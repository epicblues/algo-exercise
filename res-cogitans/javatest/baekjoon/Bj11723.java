package javatest.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
백준 11723 집합
Class3, Silver5, Impl, https://www.acmicpc.net/problem/11723
 */
public class Bj11723 {
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		CustomSet set = new CustomSet();
		for (int i = 0; i < n; i++) {
			String[] input = br.readLine().split(" ");
			switch (input[0]) {
				case "add":
					set.add(Integer.parseInt(input[1]));
					break;
				case "remove":
					set.remove(Integer.parseInt(input[1]));
					break;
				case "check":
					set.check(Integer.parseInt(input[1]));
					break;
				case "toggle":
					set.toggle(Integer.parseInt(input[1]));
					break;
				case "all":
					set.all();
					break;
				case "empty":
					set.empty();
					break;
			}
		}

		System.out.println(sb);
	}

	private static class CustomSet {
		boolean[] elements = new boolean[21];

		private void add(int i) {
			elements[i] = true;
		}

		private void remove(int i) {
			elements[i] = false;
		}

		private void check(int i) {
			if (elements[i]) {
				sb.append(1).append("\n");
			} else {
				sb.append(0).append("\n");
			}
		}

		private void toggle(int i) {
			elements[i] = (elements[i]) ? false : true;
		}

		private void all() {
			for (int i = 0; i < 21; i++) {
				elements[i] = true;
			}
		}

		private void empty() {
			for (int i = 0; i < 21; i++) {
				elements[i] = false;
			}
		}
	}
}
