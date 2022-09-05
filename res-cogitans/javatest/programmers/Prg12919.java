package javatest.programmers;

/*
Level1, 서울에서 김서방 찾기
https://school.programmers.co.kr/learn/courses/30/lessons/12919
 */
public class Prg12919 {
	public String solution(String[] seoul) {
		int index = seoul.length;
		for (int i = 0; i < seoul.length; i++) {
			if (seoul[i].equals("Kim")) {
				index = i;
			}
		}
		String answer = "김서방은 " + index + "에 있다";
		return answer;
	}
}
