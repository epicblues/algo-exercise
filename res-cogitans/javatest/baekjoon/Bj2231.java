package javatest.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj2231 {
	static int n;
	public static void main(String[] args) throws IOException {
		n = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());

		int level = Integer.toString(n).length();

		for (int i = n- 9 * level; i < n; i++) {
			if (isConstructor(i)) {
				System.out.println(i);
				return;
			}
		}

		System.out.println(0);
	}


	private static boolean isConstructor(int tested) {
		char[] eachNum = String.valueOf(tested).toCharArray();
		int testedSum = tested;
		for (char n : eachNum) {
			testedSum += Character.getNumericValue(n);
		}

		return testedSum == n;
	}
}
