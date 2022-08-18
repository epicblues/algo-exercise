import java.util.HashMap;

public class Problem_118666 {
	public String solution(String[] survey, int[] choices) {
		var table = new HashMap<String, Integer>();
		table.put("RT", 0);
		table.put("CF", 0);
		table.put("JM", 0);
		table.put("AN", 0);

		for (int i = 0; i < survey.length; i++) {
			var question = survey[i];
			var choice = choices[i] - 4;
			if (table.containsKey(question)) {
				table.put(question, table.get(question) - choice);
				continue;
			}
			String opposite = String.valueOf(question.charAt(1)) + question.charAt(0);
			table.put(opposite, table.get(opposite) + choice);
		}
		var buffer = new StringBuilder();
		table.forEach((type, score) -> {
			if (score >= 0) {
				buffer.append(type.charAt(0));
				return;
			}
			buffer.append(type.charAt(1));
		});

		return buffer.toString();
	}
}
