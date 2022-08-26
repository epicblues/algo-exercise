package javatest.programmers;

import java.util.LinkedList;
import java.util.Queue;

/*
Level2, 게임 맵 최단거리
https://school.programmers.co.kr/learn/courses/18/lessons/1844
 */
public class Prg1844 {

	public static void main(String[] args) {
		int[][] arg = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
		System.out.println(new Prg1844().solution(arg));
	}

	static int[] dy = {1, -1, 0, 0};
	static int[] dx = {0, 0, 1, -1};

	public int solution(int[][] maps) {
		Queue<int[]> toVisit = new LinkedList<>();
		toVisit.offer(new int[] {0, 0, 1});
		boolean[][] visited = new boolean[maps.length][maps[0].length];
		visited[0][0] = true;

		while (!toVisit.isEmpty()) {
			int[] visitNow = toVisit.poll();

			for (int i = 0; i < 4; i++) {
				int targetY = visitNow[0] + dy[i];
				int targetX = visitNow[1] + dx[i];

				if (targetY < 0 || targetX < 0 || targetY >= maps.length || targetX >= maps[0].length
					|| maps[targetY][targetX] == 0 || visited[targetY][targetX]) {
					continue;
				}

				if (targetY == maps.length - 1 && targetX == maps[0].length - 1) {
					return visitNow[2] + 1;
				}

				visited[targetY][targetX] = true;
				toVisit.offer(new int[] {targetY, targetX, visitNow[2] + 1});
			}
		}

		return -1;
	}
}
