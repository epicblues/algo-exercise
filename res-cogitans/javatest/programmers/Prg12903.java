package javatest.programmers;

/*
Level1, 가운데 글자 가져오기
https://school.programmers.co.kr/learn/courses/30/lessons/12903
*/
public class Prg12903 {
	public String solution(String s) {
		if (s.length() % 2 == 0) {
			return s.substring(s.length() / 2 - 1, s.length() / 2 + 1);
		} else {
			return String.valueOf(s.charAt(s.length() / 2));
		}
	}
}
