import java.util.ArrayList;
import java.util.List;

public class Problem_76503 {

		static List<Integer>[] graph;
	static int[] nodes;
	static boolean[] visited;
	static long calCount = 0L;

	public long solution(int[] a, int[][] edges) {
		nodes = a;

		// 가중치가 가능한 것 : 모든 node의 합이 0이어야 한다.
	    long sum = 0L;
        int zeroCount=0;
		for (int i = 0; i < a.length; i++) {
            if(a[i] == 0) {
                zeroCount++;
                continue;
            }
			sum += a[i];
		}

		if (sum != 0) {
			return -1;
		}
        if(zeroCount == a.length) {
            return 0;
        }

		// 트리 구성하기

		graph = new List[a.length];

		for (int i = 0; i < graph.length; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < edges.length; i++) {
			var edge = edges[i];
			graph[edge[0]].add(edge[1]);
			graph[edge[1]].add(edge[0]);
		}

		visited = new boolean[a.length];

		dfs(0);
		return calCount;
	}

	private long dfs(int rootNode) {
		visited[rootNode] = true;
		long now = nodes[rootNode];

		for (int childNode : graph[rootNode]) {
			if (!visited[childNode])
				now += dfs(childNode);
		}

		calCount += Math.abs(now);
		return now;
	}

}
