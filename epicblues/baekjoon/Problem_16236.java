import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;

public class Problem_16236 {
	public static final int[] DX = new int[] {-1, 0, 1, 0};
	public static final int[] DY = new int[] {0, -1, 0, 1};
	static int[][] table = null;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		table = new int[n][n];
		Queue<Dot>[] fishListBySize = new LinkedList[7];
		for (int i = 1; i <= 6; i++) {
			fishListBySize[i] = new LinkedList<>();
		}
		Dot shark = null;
		for (int i = 0; i < n; i++) {
			var tokens = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				table[i][j] = Integer.parseInt(tokens[j]);
				if (table[i][j] > 0 && table[i][j] < 7) {
					fishListBySize[table[i][j]].add(new Dot(i, j));
				}
				if (table[i][j] == 9) {
					table[i][j] = 0;
					shark = new Dot(i, j);
				}
			}
		}
		int sharkSize = 2;
		int time = 0;
		int sharkStatus = 0;

		// 먹을 수 있는 물고기 리스트 받기
		List<Dot> eatableList = new LinkedList<>(fishListBySize[1]);
		Dot nextFish = null;
		while (!eatableList.isEmpty()) {
			int shortestLength = Integer.MAX_VALUE;
			Map<Integer, List<Dot>> lengthTable = new HashMap<>();
			// 먹을 수 있는 리스트에서 갈 수 있는 곳 찾기
			for (Dot dot : eatableList) {
				int candidateLength = getShortestLength(shark, dot, sharkSize);
				if (candidateLength > shortestLength) {
					continue;
				}
				shortestLength = candidateLength;
				lengthTable.putIfAbsent(shortestLength, new LinkedList<>());
				lengthTable.get(shortestLength).add(dot);
			}
			// 먹을 곳은 있으나 더 이상 갈 수 없을 경우 탐색 중단
			if (shortestLength == Integer.MAX_VALUE) {
				break;
			}

			// 물고기 선택
			var targets = lengthTable.get(shortestLength);
			if (targets.size() > 1) {
				targets.sort((a, b) -> {
					if (a.x == b.x) {
						return a.y - b.y;
					}
					return a.x - b.x;
				});
			}
			nextFish = targets.get(0);
			// 먹기
			shark = nextFish;
			// 시간 추가
			time += shortestLength;
			// 해당 위치를 0으로 바꾼다
			table[nextFish.x][nextFish.y] = 0;
			// eatableList에서 제외
			eatableList.remove(nextFish);
			// 상어의 size와 먹은 상태를 보고 사이즈 키우기 여부 결정
			sharkStatus++;
			if (sharkSize <= 6 && sharkStatus == sharkSize) {
				sharkStatus = 0;
				sharkSize++;
				// 상어 1단계 업글마다 새로운 먹을 거리들 생김
				eatableList.addAll(fishListBySize[sharkSize - 1]);
			}

		}

		System.out.println(time);
	}

	// 도달할 수 없을 경우 Integer.MAX_VALUE 반환
	private static int getShortestLength(Dot start, Dot end, int sharkSize) {
		Map<Dot, Integer> visited = new HashMap<>();
		// 해당 dot으로 가는 길
		Queue<Dot> q = new LinkedList<>();

		q.offer(start);
		visited.put(start, 0);

		while (!q.isEmpty()) {
			Dot next = q.poll();
			int stage = visited.get(next) + 1;
			for (int i = 0; i < 4; i++) {
				int newX = next.x + DX[i];
				int newY = next.y + DY[i];
				Dot candidate = new Dot(newX, newY);
				if (!candidate.isValid() || table[candidate.x][candidate.y] > sharkSize || visited.containsKey(
					candidate)) {
					continue;
				}
				if (candidate.equals(end)) {
					return stage;
				}
				visited.put(candidate, stage);
				q.offer(candidate);
			}
		}
		// 여기까지 왔다는 것 자체가 갈 수 없다는 뜻
		return Integer.MAX_VALUE;
	}

	// 왼쪽 위 기준점
	static class Dot {
		final int x;
		final int y;

		Dot(int x, int y) {
			this.x = x;
			this.y = y;
		}

		private boolean isValid() {
			return x >= 0 && x < table.length && y >= 0 && y < table.length;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o)
				return true;
			if (!(o instanceof Dot))
				return false;
			Dot dot = (Dot)o;
			return x == dot.x && y == dot.y;
		}

		@Override
		public int hashCode() {
			return Objects.hash(x, y);
		}
	}
}
