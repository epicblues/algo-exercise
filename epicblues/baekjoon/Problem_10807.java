import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Problem_10807 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		var st = new StringTokenizer(br.readLine());
		var table = new HashMap<Integer, Integer>();

		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(st.nextToken());
			if (!table.containsKey(num)) {
				table.put(num, 1);
				continue;
			}

			table.put(num, table.get(num) + 1);

		}
		int target = Integer.parseInt(br.readLine());

		System.out.println(table.getOrDefault(target, 0));
	}
}
