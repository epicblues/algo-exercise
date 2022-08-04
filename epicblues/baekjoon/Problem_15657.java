import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int max = 0;
	static StringBuilder answer = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		var st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		max = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] nums = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(nums);

		var buffer = new LinkedList<Integer>();
		for (int i = 0; i < n; i++) {

			dfs(buffer, i, nums);

		}

		
		System.out.println(answer);
	}

	private static void dfs(LinkedList<Integer> buffer, int index, int[] table) {

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
