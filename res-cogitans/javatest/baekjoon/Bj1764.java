package javatest.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Bj1764 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		HashSet<String> targetList = new HashSet<>();
		for (int i = 0; i < n; i++) {
			targetList.add(br.readLine());
		}

		ArrayList<String> answerList = new ArrayList<>();
		for (int i = 0; i < m; i++) {
			String input = br.readLine();
			if (targetList.contains(input)) {
				answerList.add(input);
			}
		}

		Collections.sort(answerList);
		StringBuilder sb = new StringBuilder();
		sb.append(answerList.size()).append("\n");
		for (String each : answerList) {
			sb.append(each).append("\n");
		}
		System.out.println(sb);
	}
}
