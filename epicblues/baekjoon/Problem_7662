import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.Collections;

public class Problem_7662 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 테스트 케이스 개수
		int t = Integer.parseInt(br.readLine());
		// 적용할 연산의 개수
		var answer = new StringBuilder();

		for (int i = 0; i < t; i++) {
			int k = Integer.parseInt(br.readLine());
			Map<Integer, Integer> map = new HashMap<>();
			var maxQueue = new PriorityQueue<Integer>(Collections.reverseOrder());
			var minQueue = new PriorityQueue<Integer>();
			for (int j = 0; j < k; j++) {
				var st = new StringTokenizer(br.readLine());
				var command = st.nextToken();
				var num = Integer.parseInt(st.nextToken());
				if (command.equals("I")) {
					maxQueue.add(num);
					minQueue.add(num);
					if (map.containsKey(num)) {
						map.put(num, map.get(num) + 1);
					} else {
						map.put(num, 1);
					}
					continue;
				}
                
                

				if (num == -1 && syncPeek(minQueue, map) != null) {
					int candidate = minQueue.poll();
                    int count = map.get(candidate);
                    if(count == 1) {
                        map.remove(candidate);
                        continue;
                    }
					map.put(candidate, count - 1);
				} else if (num == 1 && syncPeek(maxQueue, map) != null) {
					int candidate = maxQueue.poll();
                    int count = map.get(candidate);
                    if(count == 1) {
                        map.remove(candidate);
                        continue;
                    }
					map.put(candidate, count - 1);
				}
			}
			
			if (map.size()==0) {
				answer.append("EMPTY\n");
				continue;
			}
			answer
				.append(syncPeek(maxQueue, map))
				.append(" ")
				.append(syncPeek(minQueue, map))
				.append("\n");

		}
		answer.deleteCharAt(answer.length() - 1);
		System.out.print(answer);
	}

	private static Integer syncPeek(PriorityQueue<Integer> queue, Map<Integer, Integer> map) {

		while (!queue.isEmpty() &&  map.get(queue.peek()) == null) {
			queue.poll();
		}
		return queue.peek();
	}

}
