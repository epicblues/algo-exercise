import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Problem_15650 {
	static StringBuilder answer = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		var st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());

		int m = Integer.parseInt(st.nextToken());
		var list = new LinkedList<Integer>();
		for (int i = 1; i <= n; i++) {
			dfs(i, 1, m, n, list);
		}
		answer.deleteCharAt(answer.length() - 1);
		System.out.println(answer);
	}

	private static void dfs(int num, int stage, int maxStage, int maxNum, LinkedList<Integer> list) {
		if (stage == maxStage) {
			list.add(num);
			for (int candidate : list) {
				answer.append(candidate).append(" ");
			}
			answer.deleteCharAt(answer.length() - 1).append("\n");
			list.removeLast();
			return;
		}

		list.add(num);

		for (int i = num + 1; i <= maxNum; i++) {
			dfs(i, stage + 1, maxStage, maxNum, list);
		}
		list.removeLast();
	}

}
