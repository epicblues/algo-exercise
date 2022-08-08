package javatest.programmers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
프로그래머스 92334 신고 결과 받기
Lv1, https://school.programmers.co.kr/learn/courses/30/lessons/92334
 */
public class Prg92334 {
	public int[] solution(String[] id_list, String[] report, int k) {
		Map<String, Set<String>> reported = new HashMap<>();
		for (String id : id_list) {
			reported.put(id, new HashSet<>());
		}

		for (String eachReport : report) {
			String[] reportData = eachReport.split(" ");
			reported.get(reportData[1]).add(reportData[0]);
		}

		Map<String, Integer> emailed = new HashMap<>();
		for (Set<String> each : reported.values()) {
			if (each.size() >= k) {
				each.forEach(
					(id) ->
						emailed.put(id, emailed.getOrDefault(id, 0) + 1));
			}
		}

		int[] answer = new int[id_list.length];
		for (int i = 0; i < id_list.length; i++) {
			answer[i] = emailed.getOrDefault(id_list[i], 0);
		}

		return answer;
	}
}
