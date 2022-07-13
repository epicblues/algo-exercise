import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {

	static int dmove[][] = {
		{0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, 0},
		{0, -1}, {-1, -1}, {-1, 0}, {-1, 1}
	};
	static boolean flag = false;

	public static void main(String[] args) throws IOException {
		//input
		char board[][] = new char[8][8];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 8; i++) {
			String line = br.readLine();
			board[i] = line.toCharArray();
		}

		//move
		LinkedList<Dot> moveq = new LinkedList<>();
		if (moveable(board, 7, 0)) {
			moveq.addLast(new Dot(7, 0));
		}
		while (!flag && !moveq.isEmpty()) {
			move(board, moveq);
			movewall(board);
		}

		if (flag)
			System.out.println(1);
		else
			System.out.println(0);
	}

	private static void move(char[][] board, LinkedList<Dot> que) {
		int qsize = que.size();
		boolean isVisited[][] = new boolean[8][8];
		for (int cnt = 0; cnt < qsize; cnt++) {
			Dot currDot = que.removeFirst();
			if (currDot.y == 0 && currDot.x == 7) {
				flag = true;
				return;
			}
			if (!moveable(board, currDot.y, currDot.x))
				continue;
			for (int i = 0; i < dmove.length; i++) {
				int x = currDot.x + dmove[i][1], y = currDot.y + dmove[i][0];
				if (moveable(board, y, x) && !isVisited[y][x]) {
					que.addLast(new Dot(y, x));
					isVisited[y][x] = true;
				}
			}
		}
	}

	private static void movewall(char[][] board) {
		for (int i = 7; i > 0; i--) {
			board[i] = board[i - 1];
		}
		board[0] = "........".toCharArray();
	}

	private static boolean moveable(char[][] board, int y, int x) {
		if (x < 0 || x > 7 || y < 0 || y > 7)
			return false;
		if (board[y][x] == '#')
			return false;
		return true;
	}
}

class Dot {
	int x;
	int y;

	public Dot(int y, int x) {
		this.x = x;
		this.y = y;
	}
}
