import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static int[] dr = {-1, 0, 1, 0};
	public static int[] dc = {0, 1, 0, -1};
	public static int N;
	public static int M;
	public static int[][] isVisited;

	public static void main(String[] args) throws IOException {

		//input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());

		stk = new StringTokenizer(br.readLine());
		int currR = Integer.parseInt(stk.nextToken());
		int currC = Integer.parseInt(stk.nextToken());
		int direction = Integer.parseInt(stk.nextToken());

		isVisited = new int[N][M];
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			isVisited[i] = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
		}

		//cal
		int count = dfs(currR, currC, direction);

		//print
		System.out.println(count);
	}

	private static int dfs(int r, int c, int direction) {
		int visitCount = 1;
		int currR = r, currC = c;
		int nextDirection = direction;

		boolean moveFlag = true;
		while (moveFlag) {
			boolean backFlag = true;
			isVisited[currR][currC] = -1;

			//direction check
			for (int i = 1; i <= 4; i++) {
				int direct = nextDirection - i;
				if (direct < 0)
					direct += 4;

				if (cleanable(currR + dr[direct], currC + dc[direct])) {
					visitCount++;
					currR = currR + dr[direct];
					currC = currC + dc[direct];
					nextDirection = direct;
					backFlag = false;
					break;
				}
			}

			//
			if (backFlag) {
				int direct = nextDirection - 2;
				if (direct < 0)
					direct += 4;
				if (isVisitable(currR + dr[direct], currC + dc[direct])) {
					currR = currR + dr[direct];
					currC = currC + dc[direct];
				} else {    //stop
					moveFlag = false;
				}
			}
		}
		return visitCount;
	}

	private static boolean cleanable(int r, int c) {
		//out of bound
		if (r < 0 || r >= N || c<0 || c>=M)	return false;
		return isVisited[r][c] == 0;
	}

	private static boolean isVisitable(int r, int c) {
		//out of bound
		if (r < 0 || r >= N || c<0 || c>=M)	return false;
		return isVisited[r][c] == -1;
	}
}
