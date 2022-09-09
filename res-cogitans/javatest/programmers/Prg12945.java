package javatest.programmers;

/*
Level2, 피보나치 수
https://school.programmers.co.kr/learn/courses/30/lessons/12945
 */
public class Prg12945 {
	public int solution(int n) {
		return fibo(n);
	}

	private static int[] fibo = new int[100001];

	static {
		fibo[1] = 1;
		fibo[2] = 1;
	}

	private int fibo(int n) {
		if (fibo[n] == 0) {
			fibo[n] = (fibo(n - 1) + fibo(n - 2)) % 1234567;
		}

		return fibo[n];
	}
}