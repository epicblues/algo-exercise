import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem_1697 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		var st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		if (start == end) {
			System.out.println(0);
			return;
		}

		int[] table = new int[100001];

		// BFS
		// 방문 -> 해당 초를 입력한다.
		// 이미 초가 입력되어 있을 경우 시간을 비교하고
		// 시간이 더 적게 걸릴 경우에만 갱신하고 나아간다.
		// 시간이 더 오래 걸릴 경우 순회를 멈추고 다음 순회로 넘어간다.
		// end에 도달했을 경우, 해당 초를 답에 입력하고 순회를 완전히 끝낸다.

		Queue<Dot> q = new LinkedList<>();
		table[start] = 1;
		q.offer(new Dot(0, start));
		while (!q.isEmpty()) {
			Dot before = q.poll();
			int stage = before.stage;

			//  -1, +1, *2
			int[] candidates = new int[] {before.pos - 1, before.pos + 1, 2 * before.pos};
			for (int candidate : candidates) {
				if (candidate < 0 || candidate > 100000)
					continue;
				// 다음 큐에 들어올 자격 확인
				if (candidate == end) {
					System.out.println(stage + 1);
					return;
				}
				if (table[candidate] == 0 || table[candidate] > stage + 1) {
					table[candidate] = stage + 1;
					q.offer(new Dot(stage + 1, candidate));
				}

			}
		}

	}

	static class Dot {
		final int stage;
		final int pos;

		Dot(int stage, int pos) {
			this.stage = stage;
			this.pos = pos;
		}
	}

}
