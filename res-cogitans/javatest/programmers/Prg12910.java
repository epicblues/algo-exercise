package javatest.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Level1, 나누어 떨어지는 숫자 배열
https://school.programmers.co.kr/learn/courses/30/lessons/12910
 */
public class Prg12910 {
	public int[] solution(int[] arr, int divisor) {

		List<Integer> answerList = new ArrayList<>();
		for (int i : arr) {
			if (i % divisor == 0) {
				answerList.add(i);
			}
		}

		if (answerList.isEmpty()) {
			return new int[]{-1};
		}

		int[] answer = new int[answerList.size()];

		for (int i = 0; i < answer.length; i++) {
			answer[i] = answerList.get(i);
		}

		Arrays.sort(answer);

		return answer;
	}
}