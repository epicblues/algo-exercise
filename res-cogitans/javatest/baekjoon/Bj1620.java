package javatest.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Bj1620 {
	static Map<Integer, String> integerKeyPokeDictionary = new HashMap<>();
	static Map<String, Integer> stringKeyPokeDictionary = new HashMap<>();


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		for (int i = 0; i < n; i++) {
			String input = br.readLine();
			integerKeyPokeDictionary.put(i + 1, input);
			stringKeyPokeDictionary.put(input, i + 1);
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < m; i++) {
			String input = br.readLine();
			if (isNumber(input)) {
				sb.append(integerKeyPokeDictionary.get(Integer.parseInt(input))).append("\n");
			}
			else {
				sb.append(stringKeyPokeDictionary.get(input)).append("\n");
			}
		}

		System.out.println(sb);
	}

	private static boolean isNumber(String given) {
		try {
			Integer.parseInt(given);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
}
