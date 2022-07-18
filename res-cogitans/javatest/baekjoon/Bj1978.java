package javatest.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Bj1978 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[] numbers = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}

		int answer = 0;
		for (int i = 0; i < n; i++) {
			if (isPrimeNumber(numbers[i])) {
				answer++;
			}
		}

		System.out.println(answer);
	}

	private static boolean isPrimeNumber(int number) {
		if (number == 1) {
			return false;
		}
		if (number < 4) {
			return true;
		}
		HashSet<Integer> checkedNumberSet = new HashSet<>();

		for (int i = 2; i < number / 2 + 1; i++) {
			if (checkedNumberSet.contains(i)) {
				continue;
			} else if (number % i == 0) {
				return false;
			} else {
				for (int j = 1; i * j < number; j++) {
					checkedNumberSet.add(i * j);
				}
			}
		}
		return true;
	}
}
