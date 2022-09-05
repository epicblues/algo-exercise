package javatest.programmers;

/*
Level2, 최댓값과 최솟값
https://school.programmers.co.kr/learn/courses/30/lessons/12939
 */
public class Prg12939 {
	public String solution(String s) {
		String[] strings = s.split(" ");

		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < strings.length; i++) {
			int eachValue = Integer.parseInt(strings[i]);

			if (eachValue < min) {
				min = eachValue;
			}
			if (eachValue > max) {
				max = eachValue;
			}
		}

		return min + " " + max;
	}
}