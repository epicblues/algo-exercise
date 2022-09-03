package javatest.programmers;
/*
Level2, 두 개 이하로 다른 비트
https://school.programmers.co.kr/learn/courses/30/lessons/77885
 */
public class Prg77885 {
	public long[] solution(long[] numbers) {
		long[] answer = new long[numbers.length];

		for (int i = 0; i < answer.length; i++) {
			answer[i] = getAnswer(numbers[i]);
		}

		return answer;
	}

	private long getAnswer(long number) {
		if (number == 0) {
			return 1;
		}
		if (number == 1) {
			return 2;
		}
		String bit = Long.toBinaryString(number);
		int lastIndexOfZero = bit.lastIndexOf('0');
		if (lastIndexOfZero < 0) {
			return number + 1L + Long.parseLong(bit.substring(1), 2);
		} else {
			char[] bitChar = bit.toCharArray();
			bitChar[lastIndexOfZero] = '1';

			if (lastIndexOfZero != bit.length() - 1) {
				bitChar[lastIndexOfZero + 1] = '0';
			}
			return Long.parseLong(String.valueOf(bitChar), 2);
		}
	}
}