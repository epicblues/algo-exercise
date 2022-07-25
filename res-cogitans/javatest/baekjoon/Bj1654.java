package javatest.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Bj1654 {

	static int[] lines;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int k = Integer.parseInt(st.nextToken());    //랜선의 수
		int n = Integer.parseInt(st.nextToken());    //필요한 랜선의 수
		lines = new int[k];
		for (int i = 0; i < k; i++) {
			lines[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(lines);

		long low = 1;
		long high = lines[lines.length - 1];
		long mid = 0;

		while (low <= high) {
			mid = (low + high) / 2;
			if (getHowManyLinesWith(mid) >= n) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}

		System.out.println(high);
	}

	private static int getHowManyLinesWith(long length) {
		int cnt = 0;
		for (int i = 0; i < lines.length; i++) {
			cnt += lines[i] / length;
		}
		return cnt;
	}
}
