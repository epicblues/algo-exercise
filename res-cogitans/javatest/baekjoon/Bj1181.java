package javatest.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bj1181 {

	static Map<String, Boolean> inserted = new HashMap<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		List<StringExtension> answer = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			String input = br.readLine();
			if (inserted.containsKey(input)) {
				continue;
			}
			answer.add(new StringExtension(input));
			inserted.put(input, true);
		}

		Collections.sort(answer);

		StringBuilder sb = new StringBuilder();
		for (StringExtension string : answer) {
			sb.append(string.value).append("\n");
		}

		System.out.println(sb);
	}

	static class StringExtension implements Comparable<StringExtension> {
		private String value;

		public StringExtension(String value) {
			this.value = value;
		}

		@Override
		public int compareTo(StringExtension other) {
			if (this.value.length() != other.value.length()) {
				return this.value.length() - other.value.length();
			}
			return this.value.compareTo(other.value);
		}
	}
}
