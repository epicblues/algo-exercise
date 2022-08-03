import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_5430 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		var answer = new StringBuilder();

		LOOP:
		for (int i = 0; i < t; i++) {
			int downCount = 0;
			String commands = br.readLine();
			for (int j = 0; j < commands.length(); j++) {
				char command = commands.charAt(j);
				if (command == 'D') {
					downCount++;
				}
			}
			int n = Integer.parseInt(br.readLine());
			var line = br.readLine();
			if (downCount > n) {
				answer.append("error\n");
				continue;
			}

			if (downCount == n) {
				answer.append("[]\n");
				continue;
			}

			var nums = line.substring(1, line.length() - 1).split(",");
			int frontPointer = 0;
			int endPointer = nums.length - 1;
			boolean isReverse = false;

			for (int j = 0; j < commands.length(); j++) {

				char command = commands.charAt(j);
				if (command == 'D') {
					if (isReverse) {
						endPointer--;
					} else {
						frontPointer++;
					}
				} else {
					isReverse = !isReverse;
				}

			}
			// 무사히 모든 결과를 거쳤다.
			var buffer = new StringBuilder();
			buffer.append("[");
			if (isReverse) {
				for (int j = endPointer; j >= frontPointer; j--) {
					buffer.append(nums[j]).append(",");
				}
			} else {
				for (int j = frontPointer; j <= endPointer; j++) {
					buffer.append(nums[j]).append(",");
				}
			}
			buffer.deleteCharAt(buffer.length() - 1);

			buffer.append("]");
			answer.append(buffer.toString()).append("\n");
		}
		System.out.print(answer);
	}
}
