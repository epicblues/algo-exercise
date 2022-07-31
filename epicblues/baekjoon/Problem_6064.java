import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_6064 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		var answerBuffer = new StringBuilder();
		for (int i = 0; i < test; i++) {
			var st = new StringTokenizer(br.readLine());

			int m = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			// 몇 번째 해까지 존재하는가? 최소공배수 만큼
			int M = 1;
			int N = 1;
			int capacity;
			while (m * M != n * N) {
				if (m * M > n * N) {
					N++;
					continue;
				}
				M++;
			}
			capacity = m * M;

			int answer = -1;
			int xMove = x;
			int yMove = y;
      // 최소공배수 원리 확장
      // 시작점만 x,y
			while (xMove <= capacity && yMove <= capacity) {
				if (xMove == yMove) {
					answer = xMove;
					break;
				}
				if (xMove > yMove) {
					yMove += n;
					continue;
				}
				xMove += m;
			}
			answerBuffer.append(answer).append("\n");
		}

		System.out.println(answerBuffer.deleteCharAt(answerBuffer.length() - 1));
	}
}
