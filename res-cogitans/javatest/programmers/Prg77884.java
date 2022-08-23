package javatest.programmers;

/*
Level1, 약수의 개수와 덧셈
https://school.programmers.co.kr/learn/courses/30/lessons/77884
 */
public class Prg77884 {
	public int solution(int left, int right) {
		int answer = 0;

		for (int i = left; i <= right; i++) {
			if (getDivisorCntOf(i) % 2 == 0) {
				answer += i;
			} else {
				answer -= i;
			}
		}

		return answer;
	}

	private int getDivisorCntOf(int target) {
		int cnt = 0;
		for (int i = 1; i <= target; i++) {
			if (target % i == 0) {
				cnt++;
			}
		}
		return cnt;
	}
}