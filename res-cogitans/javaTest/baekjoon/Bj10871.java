package javaTest.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Bj10871 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st1.nextToken());
		int x = Integer.parseInt(st1.nextToken());

		StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
		List<Integer> numbers = new ArrayList<>();
		for (int i = 0; i <n ; i++) {
			int number = Integer.parseInt(st2.nextToken());
			if (number < x) {
				numbers.add(number);
			}
		}

		StringBuilder sb = new StringBuilder();
		for (Integer number : numbers) {
			sb.append(number).append(" ");
		}

		System.out.println(sb);
	}
}
