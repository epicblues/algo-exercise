package javatest.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Bj2512 {
	static int[] budget;
	static long max;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		max = Long.parseLong(br.readLine());

		budget = new int[n];
		for (int i = 0; i < n; i++) {
			budget[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(budget);

		int low = 0;
		int high = budget[n - 1];
		int mid = 0;
		while (low <= high) {
			mid = (low + high) / 2;
			if (totalBudgetOf(mid) <= max) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		System.out.println(high);
	}

	private static long totalBudgetOf(long budgetCut) {
		long total = 0;
		for (int i = 0; i < budget.length; i++) {
			total += (budgetCut < budget[i]) ? budgetCut : budget[i];
		}
		return total;
	}
}