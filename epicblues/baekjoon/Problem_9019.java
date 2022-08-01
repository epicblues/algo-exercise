import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem_9019 {
	static String[] table;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		// BFS : 루프 도중 조건을 만족하면 해당 명령어 나열을 하나씩 출력한다.
		// 새로운 명렁어 나열의 길이가 기존의 명령어 나열의 길이보다 짧을 때만 대체하고 진행
		// 길거나 같을 경우에는 해당 순회는 끝
		var answer = new StringBuilder();
		for (int i = 0; i < n; i++) {
			table = new String[10000]; // null로 초기화
			var st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			Queue<Integer> q = new LinkedList<>();
			q.add(start);
			table[start] = "";
			while (!q.isEmpty()) {
				int next = q.poll();
				if (next == end) {
					answer.append(table[next]).append("\n");
					break;
				}
				int candidate;
				// D
				candidate = next * 2 % 10000;
				if (isInRange(candidate, start)) {
					String preCommand = table[candidate];
					if (preCommand == null || preCommand.length() - 1 > table[next].length()) {
						table[candidate] = table[next] + "D";
						q.add(candidate);
					}
				}

				// S
				candidate = next == 0 ? 9999 : next - 1;
				if (isInRange(candidate, start)) {
					String preCommand = table[candidate];
					if (preCommand == null || preCommand.length() - 1 > table[next].length()) {
						table[candidate] = table[next] + "S";
						q.add(candidate);
					}
				}

				// L
				candidate = rotateLeft(next);
				if (isInRange(candidate, start)) {
					String preCommand = table[candidate];
					if (preCommand == null || preCommand.length() - 1 > table[next].length()) {
						table[candidate] = table[next] + "L";
						q.add(candidate);
					}
				}

				// R
				candidate = rotateRight(next);

				if (isInRange(candidate, start)) {
					String preCommand = table[candidate];
					if (preCommand == null || preCommand.length() - 1 > table[next].length()) {
						table[candidate] = table[next] + "R";
						q.add(candidate);
					}
				}
			}
		}

		System.out.print(answer);
	}

	private static int rotateRight(int next) {
		String start = Integer.toString(next);
		char[] startBuffer = new char[] {'0', '0', '0', '0'};
		for (int i = 0; i < start.length(); i++) {
			startBuffer[i + startBuffer.length - start.length()] = start.charAt(i);
		}
		char[] end = new char[] {'0', '0', '0', '0'};
		for (int i = 0; i < 4; i++) {
			end[i == startBuffer.length - 1 ? 0 : i + 1] = startBuffer[i];
		}
		return Integer.parseInt(String.valueOf(end));
	}

	private static int rotateLeft(int next) {
		String start = Integer.toString(next);
		char[] startBuffer = new char[] {'0', '0', '0', '0'};
		for (int i = 0; i < start.length(); i++) {
			startBuffer[i + startBuffer.length - start.length()] = start.charAt(i);
		}
		char[] end = new char[] {'0', '0', '0', '0'};
		for (int i = 0; i < 4; i++) {
			end[i == 0 ? startBuffer.length - 1 : i - 1] = startBuffer[i];
		}
		return Integer.parseInt(String.valueOf(end));
	}

	private static boolean isInRange(int num, int start) {
		return num < 10000 && num >= 0 && num != start;
	}
}
