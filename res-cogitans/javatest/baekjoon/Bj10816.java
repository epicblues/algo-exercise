package javatest.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Bj10816 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());    						//숫자 카드의 개수
		Map<Integer, Integer> cards = new HashMap<>();                  	//숫자 카드: 탐색 대상
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			int cardNum = Integer.parseInt(st.nextToken());
			if (cards.containsKey(cardNum)) {
				cards.put(cardNum, cards.get(cardNum) + 1);
			} else {
				cards.put(cardNum, 1);
			}
		}

		int m = Integer.parseInt(br.readLine());    //탐색할 수의 개수
		st = new StringTokenizer(br.readLine());
		int[] targets = new int[m];
		for (int i = 0; i < m; i++) {
			targets[i] = Integer.parseInt(st.nextToken());
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < m; i++) {
			if (cards.containsKey(targets[i])) {
				sb.append(cards.get(targets[i]));
			} else {
				sb.append(0);
			}
			sb.append(" ");
		}
		System.out.println(sb);
	}
}
