import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem_2178 {
	public static void main(String[] args) throws IOException {
		// n -1, m - 1 까지 이동

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[][] table = new int[n][m];

		for (int i = 0; i < n; i++) {
			var nums = br.readLine().split("");
			for (int j = 0; j < m; j++) {
				table[i][j] = Integer.parseInt(nums[j]);
			}

		}

		int[] dx = new int[] {-1, 0, 0, 1};
		int[] dy = new int[] {0, -1, 1, 0};

		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(0, 0));
		// bfs 로 0,0에서 n, m 까지 이동
		while (!q.isEmpty()) {
			var start = q.poll();
			var stage = table[start.x][start.y];

			for (int i = 0; i < 4; i++) {
				var newX = start.x + dx[i];
				var newY = start.y + dy[i];

				if (newX == n - 1 && newY == m - 1) {
					System.out.println(stage + 1);
					return;
				}
				if (newX >= 0 && newX < n && newY >= 0 && newY < m && table[newX][newY] == 1) {
					q.offer(new Point(newX, newY));
					table[newX][newY] = stage + 1;
				}
			}
		}

		System.out.println(table[n - 1][m - 1]);

	}

	static class Point {
		final int x;
		final int y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}
