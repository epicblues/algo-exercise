package javatest.programmers;

/*
Level1, 정수 제곱근 판별
https://school.programmers.co.kr/learn/courses/30/lessons/12934
 */
public class Prg12934 {
	public long solution(long n) {
		long answer = -1;

		long index = 0L;
		while (index * index <= n) {
			if (index * index == n) {
				answer = (index + 1) * (index + 1);
			}
			index++;
		}

		return answer;
	}
}
