package javatest.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
백준 9019 DSLR
Class3, Gold4, Graph, BFS, https://www.acmicpc.net/problem/9019
 */
public class Bj9019 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		while (t-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int target = Integer.parseInt(st.nextToken());
			sb.append(bfs(start, target)).append("\n");
		}

		System.out.println(sb);
	}

	private static String bfs(int start, int target) {
		boolean[] visited = new boolean[10001];
		Queue<Move> toVisit = new LinkedList<>();

		if (start == target) {
			return "";
		}

		toVisit.offer(new Move(start, ""));

		while (!toVisit.isEmpty()) {
			Move visitNow = toVisit.poll();

			if (!visited[l(visitNow.pos)]) {
				if (l(visitNow.pos) == target) {
					return visitNow.move + "L";
				}
				visited[l(visitNow.pos)] = true;
				toVisit.offer(new Move(l(visitNow.pos), visitNow.move + "L"));
			}
			if (!visited[r(visitNow.pos)]) {
				if (r(visitNow.pos) == target) {
					return visitNow.move + "R";
				}
				visited[r(visitNow.pos)] = true;
				toVisit.offer(new Move(r(visitNow.pos), visitNow.move + "R"));
			}
			if (!visited[d(visitNow.pos)]) {
				if (d(visitNow.pos) == target) {
					return visitNow.move + "D";
				}
				visited[d(visitNow.pos)] = true;
				toVisit.offer(new Move(d(visitNow.pos), visitNow.move + "D"));
			}
			if (!visited[s(visitNow.pos)]) {
				if (s(visitNow.pos) == target) {
					return visitNow.move + "S";
				}
				visited[s(visitNow.pos)] = true;
				toVisit.offer(new Move(s(visitNow.pos), visitNow.move + "S"));
			}
		}

		throw new IllegalStateException();
	}

	static class Move {
		int pos;
		String move;

		public Move(int pos, String move) {
			this.pos = pos;
			this.move = move;
		}
	}

	private static int d(int x) {
		int result = x * 2;
		return (result >= 10000) ? result % 10000 : result;
	}

	private static int s(int x) {
		return (x == 0) ? 9999 : x - 1;
	}

	private static int l(int x) {
		int[] d = new int[4];
		d[0] = x / 1000;
		x %= 1000;
		d[1] = x / 100;
		x %= 100;
		d[2] = x / 10;
		d[3] = x % 10;

		return d[1] * 1000 + d[2] * 100 + d[3] * 10 + d[0];
	}

	private static int r(int x) {
		int[] d = new int[4];
		d[0] = x / 1000;
		x %= 1000;
		d[1] = x / 100;
		x %= 100;
		d[2] = x / 10;
		d[3] = x % 10;

		return d[3] * 1000 + d[0] * 100 + d[1] * 10 + d[2];
	}
}
