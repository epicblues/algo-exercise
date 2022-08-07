import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Problem_15666 {
	static int max = 0;
	static StringBuilder answer = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		var st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		max = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		Integer[] nums;
		TreeSet<Integer> set = new TreeSet<>();
		int count = 0;
		for (int i = 0; i < n; i++) {
			int candidate = Integer.parseInt(st.nextToken());
			if (set.add(candidate)) {
				count++;
			}
		}
		nums = set.toArray(new Integer[count]);

		var buffer = new LinkedList<Integer>();
		for (int i = 0; i < count; i++) {

			dfs(buffer, i, nums);

		}

		System.out.println(answer);
	}

	private static void dfs(LinkedList<Integer> buffer, int index, Integer[] table) {

		int next = table[index];
		buffer.add(next);
		if (buffer.size() == max) {
			for (int element : buffer) {
				answer.append(element).append(" ");
			}

			answer.append("\n");
			buffer.removeLast();
			return;
		}

		for (int i = index; i < table.length; i++) {
			dfs(buffer, i, table);

		}
		buffer.removeLast();
	}
}
