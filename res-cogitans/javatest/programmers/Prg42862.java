package javatest.programmers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
Level1, 체육복
https://school.programmers.co.kr/learn/courses/30/lessons/42862
 */
public class Prg42862 {
	public int solution(int n, int[] lost, int[] reserve) {
		int answer = n;
		Arrays.sort(lost);

		Set<Integer> reserveSet = new HashSet<>();
		Set<Integer> notLost = new HashSet<>();

		for (int eachReserve : reserve) {
			if (Arrays.binarySearch(lost, eachReserve) < 0) {
				reserveSet.add(eachReserve);
			} else {
				notLost.add(eachReserve);
			}
		}

		int lastBorrowed = -1;
		for (int i = 0; i < lost.length; i++) {
			if (notLost.contains(lost[i])) {
				continue;
			}
			if (reserveSet.contains(lost[i] - 1) && lastBorrowed != lost[i] - 1) {
				continue;
			}
			if (reserveSet.contains(lost[i] + 1)) {
				lastBorrowed = lost[i] + 1;
			} else {
				answer--;
			}
		}

		return answer;
	}
}
