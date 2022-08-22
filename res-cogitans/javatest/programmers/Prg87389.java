package javatest.programmers;

/*
Level1, 나머지가 1이 되는 수 찾기
https://school.programmers.co.kr/learn/courses/30/lessons/87389
*/
public class Prg87389 {
	public int solution(int n) {
		for (int i = 2; i < n; i++) {
			if (n % i == 1) {
				return i;
			}
		}
		throw new IllegalStateException();
	}
}
