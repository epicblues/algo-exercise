import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem_15652 {
	static int n;
	static int m;
	static int[] table;
	static List<Integer> buffer = new LinkedList<>();
	static StringBuilder answer = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		var st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		table = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			table[i] = i;
		}

		for (int i = 1; i <= n; i++) {
			dfs(i);
		}

		answer.deleteCharAt(answer.length() - 1);
		System.out.print(answer);
	}

	private static void dfs(int index) {
		buffer.add(table[index]);
		if (buffer.size() == m) {
			for (int num : buffer) {
				answer.append(num).append(" ");
			}
			answer.deleteCharAt(answer.length() - 1).append("\n");
			buffer.remove(buffer.size() - 1);
			return;
		}

		for (int i = index; i <= n; i++) {
			dfs(i);
		}

		buffer.remove(buffer.size() - 1);
	}
}
