package javatest.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
백준 5430 AC
Class3, Gold5, Impl, https://www.acmicpc.net/problem/5430
 */
public class Bj5430 {
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			String commandInput = br.readLine();
			char[] commands = commandInput.toCharArray();
			int n = Integer.parseInt(br.readLine());
			String input = br.readLine();
			if (n == 0 && !commandInput.contains("D")) {
				sb.append("[]").append("\n");
				continue;
			}

			String[] inputs = input.substring(1, input.length() - 1).split(",");
			int[] parsedInput = new int[n];

			for (int j = 0; j < n; j++) {
				parsedInput[j] = Integer.parseInt(inputs[j]);
			}

			AC ac = new AC(parsedInput);

			try {
				for (char command : commands) {
					if (command == 'R') {
						ac.R();
					} else {
						ac.D();
					}
				}
				sb.append(ac.print()).append("\n");
			} catch (IllegalStateException e) {
				sb.append("error").append("\n");
			}
		}

		sb.delete(sb.length() - 1, sb.length());
		System.out.println(sb);
	}

	static class AC {
		private int[] elements;
		private int startIndex;
		private int lastIndex;
		private boolean isReversedOrder = false;

		public AC(int[] elements) {
			this.elements = elements;
			startIndex = 0;
			lastIndex = elements.length - 1;
		}

		private int size() {
			return lastIndex - startIndex + 1;
		}

		public void R() {
			isReversedOrder = !isReversedOrder;
		}

		public void D() {
			if (size() <= 0) {
				throw new IllegalStateException();
			}

			if (isReversedOrder) {
				lastIndex--;
			} else {
				startIndex++;
			}
		}

		public String print() {
			int[] cut = Arrays.copyOfRange(elements, startIndex, lastIndex + 1);
			StringBuilder stringBuilder = new StringBuilder().append("[");
			if (cut.length == 0) {
				return "[]";
			}

			if (isReversedOrder) {
				for (int i = cut.length - 1; i >= 0; i--) {
					stringBuilder.append(cut[i]).append(",");
				}
			} else {
				for (int i = 0; i < cut.length; i++) {
					stringBuilder.append(cut[i]).append(",");
				}
			}
			stringBuilder.delete(stringBuilder.length() - 1, stringBuilder.length()).append("]");
			return stringBuilder.toString();
		}
	}
}
