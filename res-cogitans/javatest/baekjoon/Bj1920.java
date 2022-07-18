package javatest.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Bj1920 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] num = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(num);

		int m = Integer.parseInt(br.readLine());
		int[] target = new int[m];
		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < m; i++) {
			target[i] = Integer.parseInt(st.nextToken());
		}

		for (int eachTarget : target) {
			System.out.println(isExistIn(eachTarget, num));
		}
	}

	private static int isExistIn(int target, int[] toSearch) {
		int rangeStart = 0;
		int rangeEnd = toSearch.length - 1;

		while (rangeStart <= rangeEnd) {
			int middle = (rangeStart + rangeEnd) / 2;

			if (target == toSearch[middle]) {
				return 1;
			} else if (rangeStart == rangeEnd && target != toSearch[middle]) {
				return 0;
			} else if (target > toSearch[middle]) {
				if (rangeEnd == rangeStart + 1) {
					rangeStart = rangeEnd;
				} else {
					rangeStart = middle;
				}
			} else {
				if (rangeStart == rangeEnd - 1) {
					rangeEnd = rangeStart;
				} else {
					rangeEnd = middle;
				}
			}
		}
		return 0;
	}
}