package javatest.programmers;

import java.util.Arrays;

/*
Level1, K번째수
https://school.programmers.co.kr/learn/courses/30/lessons/42748
 */
public class Prg42748 {
	public int[] solution(int[] array, int[][] commands) {
		int[] answer = new int[commands.length];
		int index = 0;

		for (int[] command : commands) {
			int[] eachArray = Arrays.copyOfRange(array, command[0] - 1, command[1]);
			Arrays.sort(eachArray);
			answer[index++] = eachArray[command[2] - 1];
		}

		return answer;
	}
}
