import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Problem_11723 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		var set = new HashSet<>();
		var answer = new StringBuilder();
		for (int i = 0; i < n; i++) {
			var st = new StringTokenizer(br.readLine());
			String command = st.nextToken();

			switch (command) {
				case "all":
					for (int j = 1; j <= 20; j++) {
						set.add(j);
					}
					break;
				case "empty":
					set.clear();
					break;
				case "add":
					int num = Integer.parseInt(st.nextToken());
					set.add(num);
					break;
				case "remove":
					num = Integer.parseInt(st.nextToken());
					set.remove(num);
					break;
				case "check":
					num = Integer.parseInt(st.nextToken());
					answer.append(set.contains(num) ? 1 : 0).append("\n");
					break;
				case "toggle":
					num = Integer.parseInt(st.nextToken());
					if (set.contains(num)) {
						set.remove(num);
					} else {
						set.add(num);
					}

			}

		}
		System.out.println(answer);
	}

}
