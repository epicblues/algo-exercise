import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Problem_11403 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] table = new int[N][N];

		// 인접 행렬 만들기
		for (int i = 0; i < N; i++) {
			var tokens = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				table[i][j] = Integer.parseInt(tokens[j]);
			}
		}

		int[][] answerTable = new int[N][N];

		// answerTable 채우기
		// 각 시작점마다 그래프 탐색(일단 효율 고려 X)

		for (int start = 0; start < N; start++) {
			Deque<Integer> group = new LinkedList<>();
			boolean[] checked = new boolean[N];
			Deque<Integer> q = new LinkedList<>();
			q.add(start);
			// BFS 시작
			while (!q.isEmpty()) {
				int next = q.poll();

				for (int j = 0; j < N; j++) {
					// 방문하지 않은 방향 간선이 존재할 경우
					if (table[next][j] == 1 && !checked[j]) {
						if (j == start) {
							// 시작 노드에 대한 방향 간선이 있으면 자기 자신으로 돌아올 수 있다는 것.
							answerTable[start][start] = 1;
							checked[j] = true;
							continue;
						}
						q.add(j);
						checked[j] = true;
						group.add(j);
					}
				}
			}

			// bfs가 끝나면 연결된 숫자들의 집합이 존재한다.
			// 연결된 숫자들을 답변 테이블에 갱신
			for (int next : group) {
				answerTable[start][next] = 1;
			}
		}
		var answer = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				answer.append(answerTable[i][j]).append(" ");
			}
			answer.delete(answer.length() - 1, answer.length());
			answer.append("\n");
		}

		System.out.println(answer);

	}
}
