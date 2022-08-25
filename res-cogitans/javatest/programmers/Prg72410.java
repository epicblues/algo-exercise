package javatest.programmers;

/*
Level1,신규 아이디 추천
https://school.programmers.co.kr/learn/courses/30/lessons/72410
 */
public class Prg72410 {
	public static void main(String[] args) {
		String arg1 = "...!@BaT#*..y.abcdefghijklm";
		String arg3 = "=.=";
		String arg = "abcdefghijklmn.p";
		String arg4 = "123_.def";
		System.out.println(new Prg72410().solution(arg3));
	}

	public String solution(String new_id) {
		String answer = new_id.toLowerCase();    //소문자 전환
		answer = deleteNotAllowed(answer);        //불허문자 제거
		while (answer.contains("..")) {
			answer = answer.replace("..", ".");        //연속되는 . 대체
		}
		if (answer.charAt(0) == '.') {
			answer = answer.substring(1);        //앞 . 제거
		}
		answer = checkLastChar(answer);
		if (answer.equals("")) {
			answer = "a";            //공백 문자열일 경우 처리
		}
		if (answer.length() > 15) {
			answer = answer.substring(0, 15);    //글자 수 제한: 최대 15자
			answer = checkLastChar(answer);
		}
		StringBuilder sb = new StringBuilder(answer);
		int length = answer.length();
		boolean isLengthChanged = false;
		while (length < 3) {
			isLengthChanged = true;
			sb.append(answer.charAt(answer.length() - 1));
			length++;
		}
		if (isLengthChanged) {
			answer = sb.toString();
		}

		return answer;
	}

	private String checkLastChar(String answer) {
		if (answer.length() == 0) {
			return answer;
		}

		if (answer.charAt(answer.length() - 1) == '.') {
			answer = answer.substring(0, answer.length() - 1);    //끝 . 제거
		}
		return answer;
	}

	private String deleteNotAllowed(String target) {
		StringBuilder sb = new StringBuilder(target);
		for (int i = target.length() - 1; i >= 0; i--) {
			if (!isAllowedChar(target.charAt(i))) {
				sb.deleteCharAt(i);
			}
		}

		return sb.toString();
	}

	private boolean isAllowedChar(char c) {
		if (c >= 97 && c <= 122) {
			return true;
		}
		if (c >= 48 && c <= 57) {
			return true;
		}
		return c == '-' || c == '_' || c == '.';
	}
}
