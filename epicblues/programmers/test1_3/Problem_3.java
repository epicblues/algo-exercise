
import java.util.LinkedList;
import java.util.Queue;

public class Problem_3 {
	public int solution(int n, int[][] wires) {
		var graph = new int[n + 1][n + 1];
		for (int i = 0; i < wires.length; i++) {
			graph[wires[i][0]][wires[i][1]] = 1;

			graph[wires[i][1]][wires[i][0]] = 1;
		}

		int answer = Integer.MAX_VALUE;
		// wire를 하나씩 끊고, 그 끊긴 와이어를 최상단 부모 노드로 삼아서 연결된 전선 수를 구한 뒤에
		for (int i = 0; i < wires.length; i++) {
			var wire = wires[i];
			int p1 = wire[0];
			int p2 = wire[1];
			Queue<Integer> q = new LinkedList<>();
			var visited = new boolean[n + 1];
			visited[p1] = true;
			q.add(p1);
			int count1 = 0;
			while (!q.isEmpty()) {
				var from = q.poll();
				count1++;
				for (int to = 1; to < n + 1; to++) {
					var candidate = graph[from][to];
					if (candidate == 1 && !visited[to] && to != p2) {
						visited[to] = true;
						q.add(to);
					}
				}
			}

			int count2 = 0;
			visited = new boolean[n + 1];
			visited[p2] = true;
			q.add(p2);
			while (!q.isEmpty()) {
				var from = q.poll();
				count2++;
				for (int to = 1; to < n + 1; to++) {
					var candidate = graph[from][to];
					if (candidate == 1 && !visited[to] && to != p1) {
						visited[to] = true;
						q.add(to);
					}
				}
			}
			answer = Math.min(answer, Math.abs(count1 - count2));
		}
		// 그 두 값의 차이의 최솟값을 구한다.
		return answer;
	}
}
