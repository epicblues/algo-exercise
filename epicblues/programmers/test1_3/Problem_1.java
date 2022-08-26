
import java.util.Map;

public class Problem_1 {
	public int solution(String s) {
		var buffer = new StringBuilder();
		var table = Map.of(
			"zero", 0,
			"one", 1,
			"two", 2,
			"three", 3,
			"four", 4,
			"five", 5,
			"six", 6,
			"seven", 7,
			"eight", 8,
			"nine", 9

		);

		for (int i = 0; i < s.length(); i++) {
			char head = s.charAt(i);
			if ('0' <= head && head <= '9') {
				buffer.append(head);
				continue;
			}
			StringBuilder chunk = new StringBuilder();
			chunk.append(head);
			while (i + 1 < s.length() && s.charAt(i + 1) >= 'a' && s.charAt(i + 1) <= 'z') {
				i++;
				chunk.append(s.charAt(i + 1));
				if (table.containsKey(chunk.toString())) {
					var numStr = chunk.toString();
					buffer.append(table.get(numStr));

				}
			}
		}

		return Integer.parseInt(buffer.toString());
	}
}
