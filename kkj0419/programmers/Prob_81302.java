import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
	public static int PLACE_SIZE = 5;
	public static int[][] dMove = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

	public int[] solution(String[][] places) {
		int[] answer = new int[PLACE_SIZE];

		List<int[]> participants;
		for (int i = 0; i < PLACE_SIZE; i++) {
			String[] place = places[i];
			participants = new ArrayList<>();
			for (int c = 0; c < place.length; c++) {
				int index = -1;
				while (true) {
					index = place[c].indexOf("P", index + 1);
					if (index == -1)
						break;

					participants.add(new int[] {c, index});
				}
			}
			answer[i] = bfs(place, participants);
		}
		return answer;
	}
	
	private int bfs(String[] place, List<int[]> participants) {
		boolean[][] isVisited;
		for (int i = 0; i < participants.size(); i++) {
			isVisited = new boolean[PLACE_SIZE][PLACE_SIZE];
			Queue<Node> queue = new LinkedList<>();
			int[] currLocation = participants.get(i);
			Node originNode = new Node(currLocation[0], currLocation[1], 0);
			isVisited[currLocation[0]][currLocation[1]] = true;
			queue.add(originNode);
			while (!queue.isEmpty()) {
				Node currNode = queue.remove();
				if (!checkDistance(place, originNode, currNode)) {
					return 0;
				}

				//add
				if (currNode.dist == 2) {
					continue;
				}
				for (int d = 0; d < dMove.length; d++) {
					int currCol = currNode.col + dMove[d][0];
					int currRow = currNode.row + dMove[d][1];

					//outofrange check
					if (!isOutOfRange(currCol, currRow) && !isVisited[currCol][currRow]) {
						isVisited[currCol][currRow] = true;
						queue.add(new Node(currCol, currRow, currNode.dist + 1));
					}
				}
			}
		}
		return 1;
	}

	private boolean isOutOfRange(int col, int row) {
		return col >= PLACE_SIZE || col < 0 || row >= PLACE_SIZE || row < 0;
	}

	//거리두기 check
	private boolean checkDistance(String[] place, Node node, Node compareNode) {
		if (compareNode.dist == 0 || place[compareNode.col].charAt(compareNode.row) != 'P')
			return true;

		if (compareNode.dist == 2) {
			if (node.col != compareNode.col && node.row != compareNode.row) {    //cross
				return place[node.col].charAt(compareNode.row) == 'X' && place[compareNode.col].charAt(node.row) == 'X';
			} else {
				int currCol = (node.col + compareNode.col) / 2;
				int currRow = (node.row + compareNode.row) / 2;
				return place[currCol].charAt(currRow) == 'X';
			}
		} else {
			return false;
		}
	}
}

class Node {
	int col;
	int row;

	int dist;

	public Node(int col, int row, int dist) {
		this.row = row;
		this.col = col;
		this.dist = dist;
	}
}
