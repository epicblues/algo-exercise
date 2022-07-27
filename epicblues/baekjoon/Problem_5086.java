import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_5086 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		var answer = new StringBuilder();
		while (true) {
			var input = br.readLine();
			if (input.equals("0 0"))
				break;

			var st = new StringTokenizer(input);
			int first = Integer.parseInt(st.nextToken());
			int last = Integer.parseInt(st.nextToken());

			if (first > last && first % last == 0) {
				// 배수인가
				answer.append("multiple\n");
				continue;
			}

			if (first < last && last % first == 0) {
				// 약수인가
				answer.append("factor\n");
				continue;
			}
			answer.append("neither\n");

		}

		System.out.println(answer);
	}
}
