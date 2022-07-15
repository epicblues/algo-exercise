import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class Problem_1541 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Pattern tokens = Pattern.compile("([1-9]\\d*)|[-+]");

		var matcher = tokens.matcher(br.readLine());

		var answer = 0;
		boolean minusFlag = false;
		for (int i = 0; matcher.find(); i++) {
			var token = matcher.group();
			if (i % 2 == 0) {
				// 숫자
				var num = Integer.parseInt(token);
				answer += (minusFlag ? -num : num);
				continue;
			}
			if (!minusFlag && token.equals("-")) {
        // 연산자
				minusFlag = true;
			}
		}

		System.out.println(answer);
	}
}
