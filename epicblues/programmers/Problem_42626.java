import java.util.PriorityQueue;

public class Problem_42626 {
	public int solution(int[] scoville, int K) {
		var queue = new PriorityQueue<Integer>();
		for (int num : scoville) {
			queue.add(num);
		}

		// 스코빌 지수를 맞출 때 까지 음식 섞기
		int mixCount = 0;
		while (queue.size() >= 2 && queue.peek() < K) {
			mixCount++;
			int mixed = queue.poll() + queue.poll() * 2;
			queue.add(mixed);
		}

		// 최대한 섞고 나서 가장 맵지 않은 음식을 꺼내서 검증
		return queue.peek() < K ? -1 : mixCount;

	}
}
