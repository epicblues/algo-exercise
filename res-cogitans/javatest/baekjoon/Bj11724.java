package javatest.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

/*
백준 11724 연결 요소의 개수
Class3, Silver2, Graph, DFS, https://www.acmicpc.net/problem/11724
 */
public class Bj11724 {
	private static Node[] nodes;
	private static boolean[] visited;
	private static int n;
	private static int m;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());        //정점의 개수
		m = Integer.parseInt(st.nextToken());        //간선의 개수

		nodes = new Node[n];
		visited = new boolean[n];

		for (int i = 0; i < n; i++) {
			nodes[i] = new Node(i);
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int nIndex1 = Integer.parseInt(st.nextToken()) - 1;
			int nIndex2 = Integer.parseInt(st.nextToken()) - 1;
			nodes[nIndex1].add(nodes[nIndex2]);
			nodes[nIndex2].add(nodes[nIndex1]);
		}

		int cnt = 0;
		for (int i = 0; i < n; i++) {
			if (isNewCComponent(nodes[i])) {
				cnt++;
			}
		}

		System.out.println(cnt);
	}

	private static boolean isNewCComponent(Node start) {
		if (visited[start.name]) {
			return false;
		}

		LinkedList<Node> stack = new LinkedList<>();
		stack.push(start);

		while (!stack.isEmpty()) {
			Node toVisit = stack.pop();

			visited[toVisit.name] = true;
			List<Node> linkedNodes = toVisit.linkedNodes;
			for (Node linkedNode : linkedNodes) {
				if (!visited[linkedNode.name]) {

					stack.push(linkedNode);
					visited[linkedNode.name] = true;
				}
			}
		}

		return true;
	}

	private static class Node {
		private int name;
		private List<Node> linkedNodes = new ArrayList<>();

		public Node(int name) {
			this.name = name;
		}

		private void add(Node node) {
			linkedNodes.add(node);
		}
	}
}
