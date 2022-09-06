package javatest.programmers;

/*
Level1, 약수의 핮
https://school.programmers.co.kr/learn/courses/30/lessons/12928
 */
public class Prg12928 {
	public int solution(int n) {
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}

		int answer = n + 1;

		for (int i = 2; i <= n / 2; i++) {
			if (n % i == 0) {
				answer += i;
			}
		}
		return answer;
	}
}