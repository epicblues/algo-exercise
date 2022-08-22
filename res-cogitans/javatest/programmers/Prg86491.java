package javatest.programmers;

/*
Level1, 최소직사각형
https://school.programmers.co.kr/learn/courses/30/lessons/86491
 */
public class Prg86491 {
	public int solution(int[][] sizes) {
		int smallSideSize = 0;
		int bigSideSize = 0;
		for (int i = 0; i < sizes.length; i++) {
			customSort(sizes[i]);
			smallSideSize = Math.max(sizes[i][0], smallSideSize);
			bigSideSize = Math.max(sizes[i][1], bigSideSize);
		}

		return smallSideSize * bigSideSize;
	}

	private void customSort(int[] eachSize) {
		if (eachSize[0] > eachSize[1]) {
			int tmp = eachSize[0];
			eachSize[0] = eachSize[1];
			eachSize[1] = tmp;
		}
	}
}
