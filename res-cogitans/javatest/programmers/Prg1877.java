package javatest.programmers;

import java.util.Arrays;

/*
순열 검사
https://school.programmers.co.kr/learn/courses/18/lessons/1877
 */
public class Prg1877 {
	public boolean solution(int[] arr) {
		Arrays.sort(arr);

		boolean[] contains = new boolean[arr[arr.length - 1] + 1];

		for (int eachNumber : arr) {
			if (contains[eachNumber]) {
				return false;
			}
			contains[eachNumber] = true;
		}

		for (int i = 1; i < contains.length; i++) {
			if (!contains[i]) {
				return false;
			}
		}
		return true;
	}
}
