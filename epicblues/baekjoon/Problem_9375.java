import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Hashtable;

public class Problem_9375 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		var answer = new StringBuilder();
		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			if (N == 0) {
				answer.append("0\n");
				continue;
			}

			if (N == 1) {
				br.readLine(); // 다음 케이스를 읽기 위해 옷에 대한 입력 값을 읽어 줘야 한다.
				answer.append(1).append("\n");
				continue;
			}
			// 의상 종류에 대한 hashTable
			var map = new Hashtable<String, Integer>();
			for (int j = 0; j < N; j++) {
				var wearName = br.readLine().split(" ")[1];
				if (map.containsKey(wearName)) {
					map.put(wearName, map.get(wearName) + 1);
					continue;
				}
				map.put(wearName, 1);
			}

			int tempAnswer = 1;
			for (int num : map.values()) {
				tempAnswer = tempAnswer * (num + 1);
			}
			answer.append(tempAnswer - 1).append("\n");
		}
		answer.deleteCharAt(answer.length() - 1);
		System.out.println(answer);

	}
}
