import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_16928 {
	static int answer = Integer.MAX_VALUE;
	static int[] table = new int[107];
	static int[] visited = new int[101];

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		var st = new StringTokenizer(br.readLine());

		// 사다리의 수
		int n = Integer.parseInt(st.nextToken());
		// 뱀의 수
		int m = Integer.parseInt(st.nextToken());

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			table[start] = end;
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			table[start] = end;

		}

		DFS(1, 0);

		System.out.println(answer);

	}

	private static void DFS(int target, int stage) {
		if (target >= 100) {
			answer = Math.min(stage, answer);
			return;
		}
		if (visited[target] != 0 && visited[target] < stage) {
			// 방문했는데 이미 더 빠른 수단이 있을 때
			// 여기서 더 재귀를 하는 것은 의미가 없으므로 순회 종료
			return;
		}
		visited[target] = stage;
		// 어느 쪽이 더 빠른 수단인지 끝까지 탐색해야 알 수 있다.(뱀을 타거나 주사위 숫자가 작아도 알 수 없음)
		for (int i = 6; i >= 1; i--) {
			int move = target + i;
			int nextTarget = table[move];
			if (nextTarget != 0) {
				DFS(nextTarget, stage + 1);
				continue;
			}
			DFS(move, stage + 1);
		}
	}
}
