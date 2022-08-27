package javatest.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/*
Level2, 빛의 경로 사이클
https://school.programmers.co.kr/learn/courses/30/lessons/86052
 */
public class Prg86052 {

	public static void main(String[] args) {
		// String[] arg = {"SL", "LR"};
		String[] arg = {"R", "R"};
		int[] answer = new Prg86052().solution(arg);
		for (int i : answer) {
			System.out.println(i);
		}
	}

	static char[][] grids;
	static boolean[][][] visited;
	static List<Integer> lengths = new ArrayList<>();

	public int[] solution(String[] grid) {
		grids = new char[grid.length][grid[0].length()];
		visited = new boolean[grids.length][grids[0].length][4];

		for (int i = 0; i < grid.length; i++) {
			grids[i] = grid[i].toCharArray();
		}

		for (int i = 0; i < grids.length; i++) {
			for (int j = 0; j < grids[0].length; j++) {
				for (int k = 0; k < 4; k++) {
					getLength(new int[] {i, j, k, 0});
				}
			}
		}

		int[] answer = new int[lengths.size()];

		int index = 0;
		for (Integer length : lengths) {
			answer[index++] = length;
		}
		Arrays.sort(answer);
		return answer;
	}

	private void getLength(int[] start) {
		//visit[0]: y, visit[1]: x, visit[2]: direction, visit[3]: cnt
		if (visited[start[0]][start[1]][start[2]]) {
			return;
		}

		Queue<int[]> toVisit = new LinkedList<>();
		toVisit.offer(start);

		visited[start[0]][start[1]][start[2]] = true;

		while (!toVisit.isEmpty()) {
			int[] visitNow = toVisit.poll();

			int nextY = 0;
			int nextX = 0;
			int nextDir = 0;
			switch (grids[visitNow[0]][visitNow[1]]) {
				case 'S': {
					nextY = visitNow[0] + dy[visitNow[2]];
					nextX = visitNow[1] + dx[visitNow[2]];
					nextDir = visitNow[2];
					break;
				}
				case 'L': {
					nextDir = (visitNow[2] > 0) ? visitNow[2] - 1 : 3;
					nextY = visitNow[0] + dy[nextDir];
					nextX = visitNow[1] + dx[nextDir];
					break;
				}
				default: {
					nextDir = (visitNow[2] < 3) ? visitNow[2] + 1 : 0;
					nextY = visitNow[0] + dy[nextDir];
					nextX = visitNow[1] + dx[nextDir];
				}
			}

			if (nextY < 0) {
				nextY = grids.length - 1;
			}
			if (nextY >= grids.length) {
				nextY = 0;
			}
			if (nextX < 0) {
				nextX = grids[0].length - 1;
			}
			if (nextX >= grids[0].length) {
				nextX = 0;
			}

			if (visited[nextY][nextX][nextDir]) {
				lengths.add(visitNow[3] + 1);
				return;
			} else {
				visited[nextY][nextX][nextDir] = true;
				toVisit.offer(new int[] {nextY, nextX, nextDir, visitNow[3] + 1});
			}
		}
	}

	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};
}