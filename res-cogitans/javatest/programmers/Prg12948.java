package javatest.programmers;

/*
Level1, 휴대폰 번호 가리기
https://school.programmers.co.kr/learn/courses/30/lessons/12948
 */
public class Prg12948 {
	public String solution(String phone_number) {
		StringBuilder sb = new StringBuilder();
		int censoredLength = phone_number.length() - 4;
		while (censoredLength-- > 0) {
			sb.append('*');
		}
		sb.append(phone_number.substring(phone_number.length() - 4));
		return sb.toString();
	}
}