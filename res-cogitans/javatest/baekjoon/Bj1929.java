package javatest.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj1929 {
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine(), " ");
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());

		System.out.println(getPrimes(m, n));
	}

	private static String getPrimes(int m, int n) {
		StringBuilder sb = new StringBuilder();

		boolean[] notPrime = new boolean[n - m + 1];

		for (int i = m; i <= n; i++) {
			if (i <= 1) {
				notPrime[i - m] = true;
			} else {
				if (notPrime[i - m]) {
					continue;
				}
				if (isPrime(i)) {
					int seq = 2;
					while (i * seq <= n) {
						notPrime[i * seq - m] = true;
						seq++;
					}
				} else {
					notPrime[i - m] = true;
				}
			}
		}

		for (int i = 0; i < notPrime.length; i++) {
			if (!notPrime[i]) {
				sb.append(i + m).append("\n");
			}
		}

		return sb.toString();
	}

	private static boolean isPrime(int number) {
		for (int i = 2; i <= Math.sqrt(number); i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}
}