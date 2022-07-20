import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static final int INF = 987654321;
	public static void main(String[] args) throws IOException {

		//input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int number = Integer.parseInt(br.readLine());

		int[][] costs = new int[number + 1][number + 1];
		for (int i = 1; i <= number; i++) {
			Arrays.fill(costs[i], INF);
		}
		StringTokenizer stk;
		while (true) {
			stk = new StringTokenizer(br.readLine());
			int num1 = Integer.parseInt(stk.nextToken());
			int num2 = Integer.parseInt(stk.nextToken());
			if (num1 == -1)
				break;

			costs[num1][num2] = 1;
			costs[num2][num1] = 1;
		}

		//cal
		for (int k = 1; k <= number; k++) {
			for (int i = 1; i <= number; i++) {
				for (int j = 1; j <= number; j++) {
					if (i == j)
						continue;
					costs[i][j] = Math.min(costs[i][j],
						costs[i][k] + costs[k][j]);
				}
			}
		}

		int minScore = INF;
		int[] score = new int[number + 1];
		for (int i = 1; i <= number; i++) {
			for (int j = 1; j <= number; j++) {
				if (costs[i][j] != INF) {
					score[i] = Math.max(score[i], costs[i][j]);
				}
			}
			minScore = Math.min(minScore, score[i]);
		}

		//print
		StringBuilder head = new StringBuilder();
		StringBuilder list = new StringBuilder();
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int candidateCount = 0;
		head.append(minScore + " ");
		for (int i = 1; i <= number; i++) {
			if (minScore == score[i]) {
				candidateCount++;
				list.append(i + " ");
			}
		}
		head.append(candidateCount);

		bw.write(head.toString() + "\n");
		bw.write(list.toString());
		bw.flush();
		bw.close();
	}
}
