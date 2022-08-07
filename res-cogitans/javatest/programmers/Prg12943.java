package javatest.programmers;

/*
프로그래머스 12943 콜라츠 추측
Lv1, https://school.programmers.co.kr/learn/courses/30/lessons/12943
 */
public class Prg12943 {
	public int solution(int num) {
		if (num == 1) {
			return 0;
		}

		int cnt = 0;
		long toCalculate = num;

		while (toCalculate != 1) {
			if (toCalculate % 2 != 0) {
				toCalculate = toCalculate * 3 + 1;
			} else {
				toCalculate /= 2;
			}
			cnt++;

			if (cnt >= 500) {
				return -1;
			}
		}
		return cnt;
	}
}
