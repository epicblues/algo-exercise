package javatest.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Bj18870 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[] coords = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < n; i++) {
			coords[i] = Integer.parseInt(st.nextToken());
		}
		int[] sortedCoords = coords.clone();

		Arrays.sort(sortedCoords);
		HashMap<Integer, Integer> rankingMap = new HashMap<>();
		int rankSeq = 0;
		for (int i = 0; i < n; i++) {
			if (!rankingMap.containsKey(sortedCoords[i])) {
				rankingMap.put(sortedCoords[i], rankSeq++);
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append(rankingMap.get(coords[i])).append(" ");
		}

		System.out.println(sb);
	}
}
