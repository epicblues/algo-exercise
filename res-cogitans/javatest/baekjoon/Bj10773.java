package javatest.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Bj10773 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		LinkedList<Integer> input = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(br.readLine());
			if (num == 0) {
				input.removeLast();
				continue;
			}
			input.add(num);
		}

		int sum = 0;
		for (Integer i : input) {
			sum += i;
		}
		System.out.println(sum);
	}
}
