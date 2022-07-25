package javatest.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj1072 {
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine(), " ");
		long play = Long.parseLong(st.nextToken());
		long win = Long.parseLong(st.nextToken());
		long z = win * 100 / play;

		long low = 0;
		long high = 1000000000;
		long mid = 0;
		boolean hasChangedOnce = false;

		while (low <= high) {
			mid = (low + high) / 2;
			long newZ = (mid + win) * 100 / (mid + play);
			if (z != newZ) {
				hasChangedOnce = true;
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}

		if (!hasChangedOnce) {
			System.out.println(-1);
		} else {
			System.out.println(low);
		}
	}
}
