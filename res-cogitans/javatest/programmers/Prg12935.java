package javatest.programmers;

import java.util.Arrays;

/*
Level1, 제일 작은 수 제거하기
https://school.programmers.co.kr/learn/courses/30/lessons/12935
 */
public class Prg12935 {
	public int[] solution(int[] arr) {
		if (arr.length == 1) {
			return new int[] {-1};
		}

		int[] sorted = arr.clone();
		Arrays.sort(sorted);
		int minimum = sorted[0];

		int[] answer = new int[arr.length - 1];

		int answerIndex = 0;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != minimum) {
				answer[answerIndex++] = arr[i];
			}
		}
		return answer;
	}
}
