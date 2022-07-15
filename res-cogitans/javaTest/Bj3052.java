package javaTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Bj3052 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		HashSet<Integer> rests = new HashSet<>();
		for (int i = 0; i < 10; i++) {
			int n = Integer.parseInt(br.readLine());
			rests.add(n % 42);
		}

		System.out.println(rests.size());
	}
}
