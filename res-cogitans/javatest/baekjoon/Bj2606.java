package javatest.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
백준 2606 바이러스
Class3, Silver3, Graph, DFS, https://www.acmicpc.net/problem/2606
 */
public class Bj2606 {
	static int n;
	static int infested = -1;
	static boolean[] visited;
	static Node[] nodes;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());        //컴퓨터의 수
		nodes = new Node[n];
		visited = new boolean[n];
		for (int i = 0; i < n; i++) {
			nodes[i] = new Node(i);
		}
		int l = Integer.parseInt(br.readLine());        //연결 수
		StringTokenizer st;
		for (int i = 0; i < l; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int n1 = Integer.parseInt(st.nextToken()) - 1;
			int n2 = Integer.parseInt(st.nextToken()) - 1;

			nodes[n1].addConnected(nodes[n2]);
			nodes[n2].addConnected(nodes[n1]);
		}

		dfs(nodes[0]);
		System.out.println(infested);
	}

	private static void dfs(Node node) {
		visited[node.name] = true;
		List<Node> connected = node.connected;
		infested++;
		for (Node nearNode : connected) {
			if (!visited[nearNode.name]) {
				dfs(nearNode);
			}
		}
	}

	private static class Node {
		private int name;
		private List<Node> connected = new ArrayList<>(n);

		public Node(int name) {
			this.name = name;
		}

		void addConnected(Node node) {
			connected.add(node);
		}
	}
}
