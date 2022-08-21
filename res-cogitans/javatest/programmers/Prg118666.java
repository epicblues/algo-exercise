package javatest.programmers;

import java.util.HashMap;
import java.util.Map;

/*
프로그래머스 118666 성격 유형 검사하기
Lv1, https://school.programmers.co.kr/learn/courses/30/lessons/118666
 */
public class Prg118666 {
	private static int[] pointTable = {-3, -2, -1, 0, 1, 2, 3};
	private static char[][] eachType = {{'R', 'T'}, {'C', 'F'}, {'J', 'M'}, {'A', 'N'}};

	public String solution(String[] survey, int[] choices) {
		Map<Character, Integer> scores = new HashMap<>();

		for (int i = 0; i < survey.length; i++) {
			int result = pointTable[choices[i] - 1];

			int pos = 1;
			if (result < 0) {
				pos = 0;
			}
			scores.put(survey[i].charAt(pos), scores.getOrDefault(survey[i].charAt(pos), 0) + Math.abs(result));
		}

		StringBuilder answer = new StringBuilder();

		for (int i = 0; i < 4; i++) {
			Integer typeScore1 = scores.getOrDefault(eachType[i][0], 0);
			Integer typeScore2 = scores.getOrDefault(eachType[i][1], 0);

			char result = eachType[i][0];
			if (typeScore1 < typeScore2) {
				result = eachType[i][1];
			}
			answer.append(result);
		}

		return answer.toString();
	}
}
