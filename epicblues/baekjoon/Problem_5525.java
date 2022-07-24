import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class Problem_5525 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		String input = br.readLine();

		var pattern = Pattern.compile("I(OI)+");

		int count = 0;

		var results = pattern.matcher(input);
		while (results.find()) {
			var matchedString = results.group();
			int numberOfO = (matchedString.length() - 1) / 2;
			if (n <= numberOfO) {
				count += numberOfO - n + 1;
			}
		}
		System.out.println(count);
	}
}
