import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_1182 {
	static int[] nums;
	static int count = 0;
	static int s = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		var st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());

		nums = new int[n];
		int i = 0;
		for (String num : br.readLine().split(" ")) {
			nums[i++] = Integer.parseInt(num);

		}

		var isUsed = new boolean[n];

		backTracking(0, true, isUsed);
		backTracking(0, false, isUsed);

		System.out.println(s == 0 ? count - 1 : count);
	}

	private static void backTracking(int i, boolean isUsing, boolean[] isUsed) {
		isUsed[i] = isUsing;
		if (i == isUsed.length - 1) {
			var sum = 0;
			for (int j = 0; j < isUsed.length; j++) {
				sum += isUsed[j] ? nums[j] : 0;
			}
			count += sum == s ? 1 : 0;
			return;
		}

		backTracking(i + 1, false, isUsed);
		backTracking(i + 1, true, isUsed);
		isUsed[i] = false;
	}
}
