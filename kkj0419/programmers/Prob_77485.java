import java.util.ArrayList;
import java.util.List;

class Solution {
	public int[][] map;
	public final int[][] dMove = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

	public int[] solution(int rows, int columns, int[][] queries) {

		//초기화
		map = new int[rows + 1][columns + 1];
		for (int r = 1; r <= rows; r++) {
			for (int c = 1; c <= columns; c++) {
				map[r][c] = c + (r - 1) * columns;
			}
		}

		//cal
		List<Integer> numberList = new ArrayList<>();
		for (int i = 0; i < queries.length; i++) {
			numberList.add(rotate(queries[i]));
		}

		return numberList.stream().mapToInt(Integer::intValue).toArray();
	}

	private int rotate(int[] query) {
		int i = 0;
		int x = query[0], y = query[1];	//start
		int value = map[x][y];
		int minNumber = value;
		int dx, dy;
		while (i < 4) {
			dx = x + dMove[i][0];
			dy = y + dMove[i][1];

			if (isOutOfBound(query, dx, dy)) {	//direction 변경
				i++;
			} else {
				//value move
				int buff = map[dx][dy];
				map[dx][dy] = value;
				value = buff;
				//min_number
				minNumber = Math.min(minNumber, value);

				//pointer move
				x = dx;
				y = dy;
			}
		}
		return minNumber;
	}

	private boolean isOutOfBound(int[] bound, int x, int y) {
		return x < bound[0] || x > bound[2] || y < bound[1] || y > bound[3];
	}
}
