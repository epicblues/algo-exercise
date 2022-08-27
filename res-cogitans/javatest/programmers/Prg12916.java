package javatest.programmers;

/*
Level1, 문자열 내 p와 y의 개수
https://school.programmers.co.kr/learn/courses/30/lessons/12916
 */
public class Prg12916 {
	boolean solution(String s) {
		char[] input = s.toCharArray();

		int cnt = 0;
		for (int i = 0; i < input.length; i++) {
			if (input[i] == 'p' || input[i] == 'P') {
				cnt++;
			}
			if (input[i] == 'y' || input[i] == 'Y') {
				cnt--;
			}
		}

		return cnt == 0;
	}
}
