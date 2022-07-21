import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_14500 {

	/*
		알고리즘에서는 Stream 절대 쓰지 말자.
	 */

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		var st = new StringTokenizer(br.readLine());
		// 세로
		int n = Integer.parseInt(st.nextToken());
		// 가로
		int m = Integer.parseInt(st.nextToken());

		int[][] table = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				table[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int answer = 0;
		// 직선
		// 직선 세로
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n - 3; j++) {
				int temp = 0;
				for (int k = j; k < j + 4; k++) {
					temp += table[k][i];
				}
				answer = Math.max(answer, temp);
			}
		}

		// 직선 가로
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m - 3; j++) {
				int temp = 0;
				for (int k = j; k < j + 4; k++) {
					temp += table[i][k];
				}
				answer = Math.max(answer, temp);
			}
		}

		// 정사각형
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < m - 1; j++) {
				int temp = 0;
				temp += table[i][j];
				temp += table[i + 1][j];
				temp += table[i][j + 1];
				temp += table[i + 1][j + 1];
				answer = Math.max(answer, temp);
			}
		}

		// 2*3 사각형
		//
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < m - 2; j++) {
				// 모든 노드의 합
				int MAX = 0;
				for (int k = i; k < i + 2; k++) {
					for (int l = j; l < j + 3; l++) {
						MAX += table[k][l];
					}
				}

				// 여러 도형 케이스 중 가장 작은 것을 구한다.
				var min = Integer.MAX_VALUE;

				min = Math.min(min, table[i][j] + table[i][j + 2]);
				min = Math.min(min, table[i + 1][j] + table[i + 1][j + 2]);
				min = Math.min(min, table[i][j + 1] + table[i][j + 2]);
				min = Math.min(min, table[i][j] + table[i][j + 1]);
				min = Math.min(min, table[i + 1][j + 1] + table[i + 1][j + 2]);
				min = Math.min(min, table[i + 1][j] + table[i + 1][j + 1]);
				min = Math.min(min, table[i][j + 2] + table[i + 1][j]);
				min = Math.min(min, table[i][j] + table[i + 1][j + 2]);

				MAX = MAX - min;
				answer = Math.max(MAX, answer);
			}
		}

		// 3* 2 사각형
		for (int i = 0; i < n - 2; i++) {
			for (int j = 0; j < m - 1; j++) {
				// 모든 노드의 합
				int MAX = 0;
				for (int k = i; k < i + 3; k++) {
					for (int l = j; l < j + 2; l++) {
						MAX += table[k][l];
					}
				}

				var min = Integer.MAX_VALUE;
				// 여러 도형 케이스 중 가장 작은 것을 구한다.
				min = Math.min(min, table[i][j] + table[i + 2][j]);
				min = Math.min(min, table[i][j + 1] + table[i + 2][j + 1]);
				min = Math.min(min, table[i][j] + table[i + 1][j]);
				min = Math.min(min, table[i][j + 1] + table[i + 1][j + 1]);
				min = Math.min(min, table[i + 1][j] + table[i + 2][j]);
				min = Math.min(min, table[i + 1][j + 1] + table[i + 2][j + 1]);
				min = Math.min(min, table[i][j] + table[i + 2][j + 1]);
				min = Math.min(min, table[i][j + 1] + table[i + 2][j]);
				MAX = MAX - min;
				answer = Math.max(MAX, answer);
			}
		}

		System.out.println(answer);
	}
}
