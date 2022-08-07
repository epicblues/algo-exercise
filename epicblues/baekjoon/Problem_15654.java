import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Problem_15654 {
	static int n;
	static int m;
	static int[] table;
	static List<Integer> buffer = new LinkedList<>();
	static StringBuilder answer = new StringBuilder();
	static Set<Integer> visited = new HashSet<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		var st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		table = new int[n];
		for (int i = 0; i < n; i++) {
			table[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(table);

		for (int i = 0; i < n; i++) {
			dfs(i);
		}

		answer.deleteCharAt(answer.length() - 1);
		System.out.print(answer);
	}

	private static void dfs(int index) {
		buffer.add(table[index]);
		visited.add(index);
		if (buffer.size() == m) {
			for (int num : buffer) {
				answer.append(num).append(" ");
			}
			answer.deleteCharAt(answer.length() - 1).append("\n");
			buffer.remove(buffer.size() - 1);
			visited.remove(index);
			return;
		}

		for (int i = 0; i < n; i++) {
			if (!visited.contains(i)) {
				dfs(i);
			}
		}

		buffer.remove(buffer.size() - 1);
		visited.remove(index);
	}

}
