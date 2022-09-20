import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
	public ArrayList<Integer>[] edgeList;

	public long solution(int[] a, int[][] edges) {
		long answer = -1;
		if (Arrays.stream(a).sum() == 0) {
			//init
			int vertex = a.length;
			edgeList = new ArrayList[vertex];
			for (int i = 0; i < vertex; i++) {
				edgeList[i] = new ArrayList<Integer>();
			}

			for (int i = 0; i < edges.length; i++) {
				int ver1 = edges[i][0];
				int ver2 = edges[i][1];

				edgeList[ver1].add(ver2);
				edgeList[ver2].add(ver1);
			}

			answer = calCount(a);
			return answer;
		}

		return answer;
	}

	private long calCount(int[] value) {

		long count = 0;
		int nodeCount = value.length;
		long[] costs = Arrays.stream(value).mapToLong(i -> (long)i).toArray();
		boolean[] isVisited = new boolean[nodeCount];

		Queue<Integer> queue = new LinkedList<>();
		int[] inbounds = new int[nodeCount];
		for (int i = 0; i < edgeList.length; i++) {
			inbounds[i] = edgeList[i].size();
			if (inbounds[i] == 1) {    //leaf insert
				queue.add(i);
			}
		}

		while (!queue.isEmpty()) {
			int currNode = queue.poll();
			isVisited[currNode] = true;
			for (int i = 0; i < edgeList[currNode].size(); i++) {
				int parentNode = edgeList[currNode].get(i);
				if (!isVisited[parentNode]) {
					//cal
					long dCount = costs[currNode];
					count += Math.abs(dCount);
					costs[currNode] = 0;
					costs[parentNode] += dCount;

					//update inbounds
					inbounds[parentNode]--;
					if (inbounds[parentNode] == 1) {
						queue.add(parentNode);
					}
					break;
				}
			}
		}

		return count;
	}
}
