import java.util.Arrays;

class Solution {
	public int[][] costs;
	public static int MAX_VALUE = 100000 * 200 + 1;

	public int solution(int n, int s, int a, int b, int[][] fares) {
		//init
		costs = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			Arrays.fill(costs[i], MAX_VALUE);
		}

		for (int i = 0; i < fares.length; i++) {
			int fare = fares[i][2];
			int node1 = fares[i][0];
			int node2 = fares[i][1];
			costs[node1][node2] = fare;
			costs[node2][node1] = fare;
		}

		calculateCosts(n);

		int value = MAX_VALUE;
		for (int i = 1; i <= n; i++) {
			value = Math.min(value, costs[s][i] + costs[i][a] + costs[i][b]);
		}
		return value;
	}

	private void calculateCosts(int n) {
		for (int k = 1; k <= n; k++) {
			costs[k][k] = 0;
			for (int i = 1; i <= n; i++) {
				if (k != i && costs[i][k] != MAX_VALUE) {
					int cost = costs[i][k];
					for (int j = 1; j <= n; j++) {
						costs[i][j] = Math.min(costs[i][j], cost + costs[k][j]);
					}
				}
			}
		}
	}
}
