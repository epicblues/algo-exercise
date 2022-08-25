package javatest.programmers;

import java.util.LinkedList;
import java.util.Queue;

/*
Level2, 전력망을 둘로 나누기
https://school.programmers.co.kr/learn/courses/30/lessons/86971
 */
public class Prg86971 {
	static int[][] wire;
	public int solution(int n, int[][] wires) {
		wire = wires;

		int answer = Integer.MAX_VALUE;
		for (int i = 0; i < wire.length; i++) {
			int eachAnswer = checkAnswerOf(i);
			answer = Math.min(answer, eachAnswer);
		}

		return answer;
	}

	private int checkAnswerOf(int indexOfCut) {
		int[] target = wire[indexOfCut];
		int cnt1 = checkLinkedCntOf(target[0], indexOfCut);
		int cnt2 = checkLinkedCntOf(target[1], indexOfCut);

		return Math.abs(cnt1 - cnt2);
	}

	private int checkLinkedCntOf(int start, int indexOfCut) {
		Queue<Integer> toVisit = new LinkedList<>();
		boolean[] visited = new boolean[wire.length];
		visited[indexOfCut] = true;
		int cnt = 1;

		toVisit.offer(start);

		while (!toVisit.isEmpty()) {
			Integer visitNow = toVisit.poll();

			for (int i = 0; i < wire.length; i++) {
				if (visited[i]) {
					continue;
				}
				if (wire[i][0] == visitNow) {
					toVisit.add(wire[i][1]);
					visited[i] = true;
					cnt++;
				}
				if (wire[i][1] == visitNow) {
					toVisit.add(wire[i][0]);
					visited[i] = true;
					cnt++;
				}
			}
		}
		return cnt;
	}
}
