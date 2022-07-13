import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {

	static int dx[] = {-1, 0, 1, 0};
	static int dy[] = {0, 1, 0, -1};
	static char map[][] = new char[12][6];
	static boolean flag = true;

	public static void main(String[] args) throws IOException {

		//input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < map.length; i++) {
			String line = br.readLine();
			map[i] = line.toCharArray();
		}

		//cal
		int chainCount = 0;
		while (flag) {
			boolean isVisited[][] = new boolean[12][6];
			flag = false;

			for (int y = 0; y < 12; y++) {
				for (int x = 0; x < 6; x++) {
					Point curPoint = new Point(11 - y, x);
					char color = map[curPoint.y][curPoint.x];
					if (moveable(curPoint, color, isVisited)) {
						bfs(curPoint, color, isVisited);
					}
				}
			}
			if (flag) {
				chainCount++;
			} else {
				break;
			}

			//down
			move();
		}
		System.out.println(chainCount);
	}

	private static void bfs(Point start, char color, boolean[][] isVisited) {
		LinkedList<Point> queue = new LinkedList<>();
		LinkedList<Point> readyQ = new LinkedList<>();
		queue.addLast(start);
		readyQ.addLast(start);
		isVisited[start.y][start.x] = true;

		while (!queue.isEmpty()) {
			Point currPoint = queue.removeFirst();
			for (int i = 0; i < 4; i++) {
				Point movePoint = new Point(currPoint.y + dy[i], currPoint.x + dx[i]);
				if (moveable(movePoint, color, isVisited)) {
					isVisited[movePoint.y][movePoint.x] = true;
					queue.addLast(movePoint);
					readyQ.addLast(movePoint);
				}
			}
		}

		if (readyQ.size() >= 4) {
			//boom
			flag = true;
			while (!readyQ.isEmpty()) {
				Point delPoint = readyQ.removeFirst();
				map[delPoint.y][delPoint.x] = '.';
			}
		}
	}

	private static void move() {
		for (int x = 0; x < 6; x++) {
			for (int y = 11; y > 0; y--) {

				//down
				if (map[y][x] == '.') {
					for (int k = y - 1; k >= 0; k--) {
						if (map[k][x] != '.') {
							//swap
							map[y][x] = map[k][x];
							map[k][x] = '.';
							break;
						}
					}
				}

			}
		}
	}

	private static boolean moveable(Point point, char color, boolean[][] isVisited) {
		if (color == '.' ||
			point.x < 0 || point.x > 5 || point.y < 0 || point.y > 11)
			return false;
		if (isVisited[point.y][point.x] || map[point.y][point.x] != color)
			return false;
		return true;
	}

}

class Point {
	int x;
	int y;

	public Point(int y, int x) {
		this.x = x;
		this.y = y;
	}
}
