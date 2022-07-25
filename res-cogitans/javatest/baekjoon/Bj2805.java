package javatest.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Bj2805 {
	static long m;
	static long tree[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());    //나무 수
		m = Long.parseLong(st.nextToken());    //요구치

		st = new StringTokenizer(br.readLine(), " ");
		tree = new long[n];
		for (int i = 0; i < n; i++) {
			tree[i] = Long.parseLong(st.nextToken());
		}

		Arrays.sort(tree);

		long low = -1;
		long high = tree[tree.length - 1] + 1;
		while (low <= high) {
			long mid = (low+ high)/2;
			if (getWoods(mid) >= m) {
				low = mid + 1;
			}
			else {
				high = mid - 1;
			}
		}

		System.out.println(high);
	}

	private static long getWoods(long height) {
		long cnt = 0;
		for (int i = 0; i < tree.length; i++) {
			cnt += Math.max(tree[i] - height, 0);
		}
		return cnt;
	}
}
