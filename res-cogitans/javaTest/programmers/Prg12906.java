package javaTest.programmers;

import java.util.ArrayList;
import java.util.List;

/*
https://school.programmers.co.kr/learn/courses/30/lessons/12906?language=java
 */
public class Prg12906 {
	public int[] solution(int []arr) {
		int previous = 10;

		List<Integer> answerList = new ArrayList<>();

		for (int i : arr) {
			if (i == previous) {
				continue;
			}
			answerList.add(i);
			previous = i;
		}

		int[] answer = new int[answerList.size()];
		for (int i = 0; i < answerList.size(); i++) {
			answer[i] = answerList.get(i);
		}

		return answer;
	}
}
