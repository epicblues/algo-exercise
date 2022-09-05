package javatest.programmers;

/*
Level1, 자연수 뒤집어 배열로 만들기
https://school.programmers.co.kr/learn/courses/30/lessons/12932
 */
public class Prg12932 {
	public int[] solution(long n) {
		String nString = Long.toString(n);
		int[] answer = new int[nString.length()];
		for (int i = 0; i < nString.length(); i++) {
			answer[answer.length - i - 1] = Character.getNumericValue(nString.charAt(i));
		}
		return answer;
	}
}
