import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int[][] minCosts;
	static final int INF = 10000001;		//최대 비용 100000*100
	public static void main(String[] args) throws IOException {

		//input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());

		StringTokenizer stk;
		minCosts = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				minCosts[i][j] = INF;

				if (i == j)
					minCosts[i][j] = 0;
			}
		}
		for (int i = 0; i < m; i++) {
			stk = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(stk.nextToken());
			int end = Integer.parseInt(stk.nextToken());
			int cost = Integer.parseInt(stk.nextToken());

			if (minCosts[start][end] == 0) {
				minCosts[start][end] = cost;
			} else {
				minCosts[start][end] = Math.min(minCosts[start][end], cost);
			}
		}

		//cal (i->k, k->j)
		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				int passBy = minCosts[i][k];
				if (passBy != 0) {
					for (int j = 1; j <= n; j++) {
						if (i == j)
							continue;
						minCosts[i][j] =
							Math.min(minCosts[i][j], minCosts[k][j] + passBy);
					}
				}
			}
		}

		//print
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (minCosts[i][j] == INF)
					minCosts[i][j] = 0;
				sb.append(minCosts[i][j] + " ");
			}
			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
