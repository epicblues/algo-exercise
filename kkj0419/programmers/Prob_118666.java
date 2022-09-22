import java.util.Map;

class Solution {
	public static Map<String, Integer> types = Map.of(
		"R", 0, "T", 1,
		"C", 2, "F", 3,
		"J", 4, "M", 5,
		"A", 6, "N", 7);

	public String solution(String[] survey, int[] choices) {
		String answer = "";

		int[] typeScore = new int[8];
		for (int i = 0; i < survey.length; i++) {
			int score = choices[i] - 4;
			String type = (score >= 0) ? survey[i].substring(1) : survey[i].substring(0, 1);
			typeScore[types.get(type)] += Math.abs(score);
		}

		for (int i = 0; i < 4; i++) {
			answer += (typeScore[2 * i] >= typeScore[2 * i + 1]) ? getKey(2 * i) : getKey(2 * i + 1);
		}

		return answer;
	}

	private String getKey(int value) {
		for (String key : types.keySet()) {
			if (value == types.get(key)) {
				return key;
			}
		}
		return null;
	}
}
