import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Problem_1620 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		var st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		String[] intToNameTable = new String[n + 1];
		Map<String, Integer> toIntMapper = new HashMap<>();
		for (int i = 1; i <= n; i++) {
			String name = br.readLine();
			toIntMapper.put(name, i);
			intToNameTable[i] = name;
		}

		var answer = new StringBuilder();
		for (int i = 0; i < m; i++) {
			String target = br.readLine();
			// 숫자인가
			if (target.codePointAt(0) - '0' < 10) {
				answer.append(intToNameTable[Integer.parseInt(target)]).append("\n");
				continue;
			}
			//	아닌가
			answer.append(toIntMapper.get(target)).append("\n");
		}

		answer.deleteCharAt(answer.length() - 1);
		System.out.println(answer);
	}
}
