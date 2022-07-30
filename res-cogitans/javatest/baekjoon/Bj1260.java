package javatest.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/*
백준 1260 DFS와 BFS
Class3, Silver2, Graph, DFS, BFS, https://www.acmicpc.net/problem/1260
 */
public class Bj1260 {
	static int m;
	static Node[] nodeList;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());            //정점의 개수
		m = Integer.parseInt(st.nextToken());                //간선의 개수
		int v = Integer.parseInt(st.nextToken());            //탐색 시작 지점
		visited = new boolean[n];

		nodeList = new Node[n];
		for (int i = 0; i < n; i++) {
			nodeList[i] = (new Node(i + 1));
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());

			nodeList[n1 - 1].addNearNode(nodeList[n2 - 1]);
			nodeList[n2 - 1].addNearNode(nodeList[n1 - 1]);
		}

		for (Node node : nodeList) {
			Collections.sort(node.nearNodes);
		}

		dfs(nodeList[v - 1]);
		sb.append("\n");
		visited = new boolean[n];
		bfs(nodeList[v - 1]);
		System.out.println(sb);
	}

	private static void dfs(Node start) {
		sb.append(start.nodeNumber).append(" ");
		visited[start.nodeNumber - 1] = true;

		List<Node> nearNodes = start.nearNodes;
		for (Node nearNode : nearNodes) {
			if (!visited[nearNode.nodeNumber - 1]) {
				dfs(nearNode);
			}
		}
	}

	private static void bfs(Node start) {
		Queue<Node> toVisit = new LinkedList<>();
		toVisit.offer(start);

		visited[start.nodeNumber - 1] = true;

		while (!toVisit.isEmpty()) {
			Node visitNow = toVisit.poll();
			sb.append(visitNow.nodeNumber).append(" ");

			List<Node> nearNodes = visitNow.nearNodes;
			for (Node nearNode : nearNodes) {
				if (!visited[nearNode.nodeNumber -1]) {
					toVisit.offer(nearNode);
					visited[nearNode.nodeNumber - 1] = true;
				}
			}
		}
	}

	static class Node implements Comparable<Node> {
		private int nodeNumber;
		private List<Node> nearNodes = new ArrayList<>(m);

		public Node(int nodeNumber) {
			this.nodeNumber = nodeNumber;
		}

		public void addNearNode(Node n) {
			this.nearNodes.add(n);
		}

		@Override
		public int compareTo(Node other) {
			return this.nodeNumber - other.nodeNumber;
		}
	}
}
