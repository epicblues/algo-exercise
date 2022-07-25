package javatest.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Bj10815 {
	static int[] cards;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());    //소유 카드
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		cards = new int[n];
		for (int i = 0; i < n; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(cards);

		int m = Integer.parseInt(br.readLine());    //목표 카드 수
		st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < m; i++) {
			int target = Integer.parseInt(st.nextToken());
			if (isCardDeckContains(target)) {
				sb.append(1);
			} else {
				sb.append(0);
			}
			sb.append(" ");
		}

		System.out.println(sb);
	}

	private static boolean isCardDeckContains(int target) {
		int low = 0;
		int high = cards.length -1;
		int mid = 0;
		while (low <= high) {
			mid = (low + high) / 2;
			if (target == cards[mid]) {
				return true;
			}
			if (target > cards[mid]) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return false;
	}
}
