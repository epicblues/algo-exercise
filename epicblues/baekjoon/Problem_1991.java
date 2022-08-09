import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_1991 {
	static int[][] graph;
	static StringBuilder answer = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		graph = new int[n][2];

		for (int i = 0; i < n; i++) {
			var node = br.readLine().split(" ");
			var root = node[0].charAt(0) - 'A';
			var leftChild = node[1].charAt(0);
			var rightChild = node[2].charAt(0);
			graph[root][0] = leftChild == '.' ? Integer.MAX_VALUE : leftChild - 'A';
			graph[root][1] = rightChild == '.' ? Integer.MAX_VALUE : rightChild - 'A';
		}

		// 전위 순회 루트 왼 오
		preOrder(0);
		answer.append("\n");
		// 중위 순회 왼 루트 오
		midOrder(0);
		answer.append("\n");
		// 후위 순회 왼 오 루트
		postOrder(0);
		System.out.print(answer);
	}

	private static void postOrder(int index) {
		for (int i = 0; i < 2; i++) {
			if (graph[index][i] != Integer.MAX_VALUE) {
				postOrder(graph[index][i]);
			}
		}
		answer.append((char)(index + 'A'));
	}

	private static void midOrder(int index) {
		if (graph[index][0] != Integer.MAX_VALUE) {
			midOrder(graph[index][0]);

		}
		answer.append((char)(index + 'A'));
		if (graph[index][1] != Integer.MAX_VALUE) {
			midOrder(graph[index][1]);

		}
	}

	private static void preOrder(int index) {
		answer.append((char)(index + 'A'));
		for (int i = 0; i < 2; i++) {
			if (graph[index][i] != Integer.MAX_VALUE) {
				preOrder(graph[index][i]);
			}
		}

	}
}
