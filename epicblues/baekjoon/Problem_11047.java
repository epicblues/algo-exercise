import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class Problem_11047 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		var meta = br.readLine().split(" ");
		int n = Integer.parseInt(meta[0]);
		int k = Integer.parseInt(meta[1]);

		// limit()을 사용하지 않으면 InputStream이 계속 열려 있음
		var coins = br.lines().limit(n).map(Integer::parseInt).collect(Collectors.toUnmodifiableList());
		int answer = 0;
    
		for (int i = n - 1; i >= 0; i--) {
			// 그리디 알고리즘 : 큰 값부터 먼저 고려
			var nextNum = coins.get(i);
			if (nextNum > k)
				continue;
			int share = k / nextNum;
			if (k % nextNum == 0) {
				answer += share;
				break;
			}
			answer += share;
			k = k - nextNum * (share);
		}
		System.out.println(answer);

	}
}
