package javatest.programmers;

/*
Level1, 두 정수 사이의 합
https://school.programmers.co.kr/learn/courses/30/lessons/12912
*/
public class Prg12912 {
	public long solution(int a, int b) {
		if (a == b) {
			return a;
		}

		if (a > b) {
			int tmp = a;
			a = b;
			b = tmp;
		}

		long answer = 0L;
		for (long i = a; i <= b; i++) {
			answer += i;
		}

		return answer;
	}
}
