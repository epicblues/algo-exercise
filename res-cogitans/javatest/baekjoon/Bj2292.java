package javatest.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Bj2292 {
	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());

		if (n == 1) {
			System.out.println(1);
			return;
		}

		int i = 1;
		cache.put(0, 0);
		while (true) {
			int start = 6 * getI(i - 1) + 2;
			int end = 6 * getI(i) + 1;
			if (n >= start && n<= end) {
				System.out.println(i + 1);
				return;
			}
			i++;
		}
	}

	static Map<Integer, Integer> cache = new HashMap<>();

	private static int getI(int i) {
		if (cache.containsKey(i)) {
			return cache.get(i);
		}
		int answer = getI(i - 1) + i;
		cache.put(i, answer);
		return answer;
	}
}