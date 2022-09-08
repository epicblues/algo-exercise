package javatest.programmers;

import java.util.LinkedList;
import java.util.Queue;

/*
Level2, 거리두기 확인하기
https://school.programmers.co.kr/learn/courses/30/lessons/81302
 */
public class Prg81302 {
	public int[] solution(String[][] places) {
		int[] answer = new int[places.length];

		for (int i = 0; i < places.length; i++) {
			answer[i] = 1;
			for (int y = 0; y < places[i].length; y++) {
				for (int x = 0; x < places[i][0].length(); x++) {
					if (places[i][y].charAt(x) == 'P') {
						if (!isRespectingArea(new int[] {y, x}, places[i])) {
							answer[i] = 0;
						}
					}
					if (answer[i] == 0) {
						break;
					}
				}
				if (answer[i] == 0) {
					break;
				}
			}
		}

		return answer;
	}

	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};

	private boolean isRespectingArea(int[] start, String[] place) {
		Queue<int[]> toVisit = new LinkedList<>();
		boolean[][] visited = new boolean[place.length][place[0].length()];

		toVisit.add(new int[] {start[0], start[1], 0});
		visited[start[0]][start[1]] = true;

		while (!toVisit.isEmpty()) {
			int[] visitNow = toVisit.poll();

			for (int i = 0; i < 4; i++) {
				int nextY = visitNow[0] + dy[i];
				int nextX = visitNow[1] + dx[i];

				if ((nextY >= 0 && nextX >= 0 && nextY < place.length && nextX < place[0].length())
					&& (place[nextY].charAt(nextX) != 'X') && !visited[nextY][nextX]) {
					if (place[nextY].charAt(nextX) == 'P' && visitNow[2] < 2) {
						return false;
					}
					if (place[nextY].charAt(nextX) == 'O' && visitNow[2] < 2) {
						toVisit.offer(new int[] {nextY, nextX, visitNow[2] + 1});
						visited[nextY][nextX] = true;
					}
				}
			}
		}

		return true;
	}
}
