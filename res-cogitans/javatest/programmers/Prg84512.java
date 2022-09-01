package javatest.programmers;

import java.util.ArrayList;
import java.util.Collections;

/*
Level2, 모음 사전
https://school.programmers.co.kr/learn/courses/30/lessons/84512
 */
public class Prg84512 {

	public static void main(String[] args) {
		int answer = new Prg84512().solution("EIO");
		System.out.println(answer);
	}

	static ArrayList<String> generated = new ArrayList<>();

	public int solution(String word) {
		for (int i = 1; i <= 5; i++) {
			generateWord(i, "");
		}

		Collections.sort(generated);

		return generated.indexOf(word) + 1;
	}

	private void generateWord(int toPick, String picked) {
		if (toPick == 0) {
			generated.add(picked);
			return;
		}
		for (int i = 0; i < 5; i++) {
			switch (i) {
				case 0:
					generateWord(toPick - 1, picked + 'A');
					break;
				case 1:
					generateWord(toPick - 1, picked + 'E');
					break;
				case 2:
					generateWord(toPick - 1, picked + 'I');
					break;
				case 3:
					generateWord(toPick - 1, picked + 'O');
					break;
				default:
					generateWord(toPick - 1, picked + 'U');
					break;
			}
		}
	}
}
