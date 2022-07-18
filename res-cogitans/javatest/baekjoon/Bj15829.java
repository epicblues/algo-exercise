package javatest.baekjoon;

import static java.math.BigInteger.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Bj15829 {
	private static final int R = 31;
	private static final int M = 1234567891;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int l = Integer.parseInt(br.readLine());
		char[] target = br.readLine().toCharArray();

		if (l > 5) {
			BigInteger hashValue = ZERO;

			for (int i = 0; i < l; i++) {
				hashValue = hashValue.add(getGreaterHashValue(target[i], i));
			}

			System.out.println(hashValue.remainder(valueOf(M)));
		}
		else {
			long hashValue = 0;

			for (int i = 0; i < l; i++) {
				hashValue += getHashValue(target[i], i);
			}

			System.out.println(hashValue % M);
		}
	}

	private static long getHashValue(char target, int i) {
		return (target - 96) * (long)Math.pow(R, i);
	}

	private static BigInteger getGreaterHashValue(char target, int i) {
		return valueOf(target - 96L).multiply(valueOf(R).pow(i));
	}
}
