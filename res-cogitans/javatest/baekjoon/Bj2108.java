package javatest.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Bj2108 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[] given = new int[n];
		Map<Integer, Integer> count = new HashMap<>();
		int sum = 0;
		for (int i = 0; i < n; i++) {
			given[i] = Integer.parseInt(br.readLine());
			count.put(given[i], count.getOrDefault(given[i], 0) + 1);
			sum += given[i];
		}

		if (n == 1) {
			System.out.println(given[0] + "\n" + given[0] + "\n" + given[0] + "\n0");
			return;
		}

		StringBuilder sb = new StringBuilder();
		//산술 평균
		sb.append(Math.round(sum / (double)n)).append("\n");

		//중앙값
		Arrays.sort(given);
		sb.append(given[(n - 1) / 2]).append("\n");

		//최빈값
		Set<Integer> countedNums = count.keySet();
		int greatestCount = Integer.MIN_VALUE;
		List<Integer> preCountedMost = new ArrayList<>();

		for (Integer countedNum : countedNums) {
			if( count.getOrDefault(countedNum, Integer.MIN_VALUE) > greatestCount) {
				preCountedMost.clear();
				preCountedMost.add(countedNum);
				greatestCount = count.getOrDefault(countedNum, Integer.MIN_VALUE);
			} else if (count.getOrDefault(countedNum, Integer.MIN_VALUE) == greatestCount) {
				preCountedMost.add(countedNum);
			}
		}

		Collections.sort(preCountedMost);

		if (preCountedMost.size() > 1) {
			sb.append(preCountedMost.get(1));
		} else {
			sb.append(preCountedMost.get(0));
		}
		sb.append("\n");

		//범위
		sb.append(given[n - 1] - given[0]);
		System.out.println(sb);
	}
}