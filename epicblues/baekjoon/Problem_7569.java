import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem_7569 {

	static int[][][] table;
	// 상 하 좌 우 위 아래
	static int[] xMove = {-1, 0, 1, 0, 0, 0};
	static int[] yMove = {0, -1, 0, 1, 0, 0};
	static int[] zMove = {0, 0, 0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());

		table = new int[h][n][m];

		Queue<Point> q = new LinkedList<>();

		for (int k = 0; k < h; k++) {
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < m; j++) {
					table[k][i][j] = Integer.parseInt(st.nextToken());
					if (table[k][i][j] == 1) {
						q.offer(new Point(i, j, k));
					}
				}
			}
		}

		while (!q.isEmpty()) {
			Point start = q.poll();
			int stage = start.getCurrentStage();

			// 상 하 좌 우 위 아래
			for (int i = 0; i < 6; i++) {

				int newX = start.x + xMove[i];
				int newY = start.y + yMove[i];
				int newZ = start.z + zMove[i];
				if (Point.isValid(newX, newY, newZ)) {
					table[newZ][newX][newY] = stage + 1;
					q.offer(new Point(start.x + xMove[i], start.y + yMove[i], start.z + zMove[i]));
				}
			}
		}

		// 최종 점검
		// 노드 전체를 순회한다.
		int answer = -1;
		for (int k = 0; k < h; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (table[k][i][j] == 0) {
						// 0이 한 번이라도 나오면 -1 출력하고 연산을 끝낸다.
						System.out.println(-1);
						return;
					}
					// 순회하면서 토마토의 최댓값을 구한다
					answer = Math.max(answer, table[k][i][j]);
				}
			}
		}

		// 순회가 끝까지 진행되면 토마토의 최댓값의 -1을 출력한다.
		System.out.println(answer - 1);

	}

	static class Point {
		final int x;
		final int y;
		final int z;

		// x는 아래
		// y는 오른쪽
		Point(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}

		static boolean isValid(int x, int y, int z) {
			// 상 하 이동 할때 이전 노드를 침범하는지 체크해야 한다.
			var xValid = x >= 0 && x < table[0].length;
			var yValid = y >= 0 && y < table[0][0].length;
			var zValid = z >= 0 && z < table.length;
			return xValid && yValid && zValid && table[z][x][y] == 0;
		}

		int getCurrentStage() {
			return table[z][x][y];
		}
	}
}
