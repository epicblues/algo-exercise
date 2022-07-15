package javaTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Bj11866 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());    //사람 수
		int k = Integer.parseInt(st.nextToken());    //제거 순서

		JosephusPermutation jp = new JosephusPermutation(n, k);

		StringBuilder sb = new StringBuilder();
		sb.append("<");
		for (int i = 0; i < n; i++) {
			sb.append(jp.get());
			if (jp.isEmpty()) {
				sb.append(">");
				System.out.println(sb);
				break;
			} else {
				sb.append(", ");
			}
		}
	}

	static class JosephusPermutation {
		private final LinkedList<Integer> elements = new LinkedList<>();
		private final int k;

		public JosephusPermutation(int n, int k) {
			for (int i = 1; i <= n; i++) {
				elements.add(i);
			}
			this.k = k;
		}

		public int get() {
			for (int i = 0; i < k - 1; i++) {
				firstToLast();
			}

			return elements.removeFirst();
		}

		private void firstToLast() {
			int first = elements.removeFirst();
			elements.addLast(first);
		}

		public boolean isEmpty() {
			return elements.isEmpty();
		}
	}
}