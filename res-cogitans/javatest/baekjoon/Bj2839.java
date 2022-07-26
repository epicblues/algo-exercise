package javatest.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj2839 {
	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());

		int fiveUnit = n / 5;

		while (fiveUnit > -1) {
			int rest = n - (fiveUnit * 5);
			if (rest % 3 == 0) {
				System.out.println(fiveUnit + rest / 3);
				return;
			}

			fiveUnit--;
		}
		System.out.println(-1);
	}
}
