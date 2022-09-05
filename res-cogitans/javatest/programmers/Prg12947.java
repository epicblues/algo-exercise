package javatest.programmers;

/*
Level1, 하샤드 수
https://school.programmers.co.kr/learn/courses/30/lessons/12947
 */
public class Prg12947 {
	public boolean solution(int x) {

		int tested = x;
		int sum = 0;
		while (tested > 0) {
			sum += tested % 10;
			tested /= 10;
		}

		return x % sum == 0;
	}
}
