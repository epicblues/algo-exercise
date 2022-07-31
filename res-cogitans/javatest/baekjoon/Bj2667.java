package javatest.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
백준 2667 단지번호붙이기
Class3, Silver1, Graph, DFS, https://www.acmicpc.net/problem/2667
 */
public class Bj2667 {
	static char[][] area;
	static boolean[][] visited;
	static int size;
	static List<Integer> answerList = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		size = Integer.parseInt(br.readLine());
		visited = new boolean[size][size];
		area = new char[size][size];
		for (int i = 0; i < size; i++) {
			area[i] = br.readLine().toCharArray();
		}

		checkUnvisited();

		Collections.sort(answerList);
		StringBuilder sb = new StringBuilder();
		sb.append(answerList.size()).append("\n");

		for (Integer answer : answerList) {
			sb.append(answer).append("\n");
		}
		System.out.println(sb);
	}

	private static void checkUnvisited() {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (!visited[i][j]) {
					int count = districtCount(i, j);
					if (count != 0) {
						answerList.add(count);
					}
				}
			}
		}
	}

	private static int districtCount(int y, int x) {
		if (area[y][x] == '0') {
			return 0;
		}
		visited[y][x] = true;
		int count = 1;

		for (int i = 0; i < 4; i++) {
			if (y > 0 && !visited[y - 1][x]) {
				count += districtCount(y - 1, x);
			}
			if (x > 0 && !visited[y][x - 1]) {
				count += districtCount(y, x - 1);
			}
			if (y < size - 1 && !visited[y + 1][x]) {
				count += districtCount(y + 1, x);
			}
			if (x < size - 1 && !visited[y][x + 1]) {
				count += districtCount(y, x + 1);
			}
		}
		return count;
	}
}
