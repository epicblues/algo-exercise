import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.StringTokenizer;

public class Problem_1764 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		var st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		Set<String> set = new HashSet<>();
		var answer = new StringBuilder();
		for (int i = 0; i < n; i++) {
			set.add(br.readLine());

		}
		var table = new LinkedList<String>();
		for (int i = 0; i < m; i++) {
			var candidate = br.readLine();
			if (set.contains(candidate)) {
				table.add(candidate);
			}
		}
		table.sort((a, b) -> {
			if (a.length() != b.length()) {
				for (int i = 0; i < Math.min(a.length(), b.length()); i++) {
					if (a.codePointAt(i) != b.codePointAt(i)) {
						return a.codePointAt(i) - b.codePointAt(i);
					}
				}
				return a.length() > b.length() ? 1 : -1;
			}
			for (int i = 0; i < a.length(); i++) {
				if (a.codePointAt(i) != b.codePointAt(i)) {
					return a.codePointAt(i) - b.codePointAt(i);
				}
			}
			return 0;
		});
		for (String name : table) {
			answer.append(name).append("\n");
		}
    // 출력을 고려하지 않아서 시간을 날렸다.
		if (!table.isEmpty()) {
			answer.deleteCharAt(answer.length() - 1);
		}
		System.out.println(table.size());
		System.out.println(answer);
	}
}
