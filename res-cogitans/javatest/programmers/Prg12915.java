package javatest.programmers;

import java.util.Arrays;

/*
Level1, 문자열 내 마음대로 정렬하기
https://school.programmers.co.kr/learn/courses/30/lessons/12915
 */
public class Prg12915 {
	public String[] solution(String[] strings, int n) {
		MyString[] myStrings = new MyString[strings.length];

		for (int i = 0; i < strings.length; i++) {
			myStrings[i] = new MyString(strings[i], n);
		}

		Arrays.sort(myStrings);

		String[] answer = new String[strings.length];
		for (int i = 0; i < strings.length; i++) {
			answer[i] = myStrings[i].value;
		}

		return answer;
	}

	private static class MyString implements Comparable<MyString> {
		private String value;
		private int comparedSpace;

		public MyString(String value, int comparedSpace) {
			this.value = value;
			this.comparedSpace = comparedSpace;
		}

		@Override
		public int compareTo(MyString other) {
			if (this.value.charAt(comparedSpace) == other.value.charAt(comparedSpace)) {
				return this.value.compareTo(other.value);
			}
			return Character.valueOf(this.value.charAt(comparedSpace)).compareTo(other.value.charAt(comparedSpace));
		}
	}
}