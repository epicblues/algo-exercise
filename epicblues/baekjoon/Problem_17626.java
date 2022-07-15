import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_17626 {
	static int[] table;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		double n = Integer.parseInt(br.readLine());
		// DP용 memo table
		table = new int[(int)n + 1];

		System.out.println(getMinimumFourSquare((int)n));

	}

	// TopDown DP
	private static int getMinimumFourSquare(int target) {

		// 이미 계산된 숫자면 바로 반납
		if (table[target] > 0) {
			return table[target];
		}
		if (isPerfectSquare(target)) {
			table[target] = 1;
			return table[target];
		}

		int maxSqrt = getClosestSqrtInt(target);

		var resultTable = new boolean[9];

		for (int i = maxSqrt; i > 0; i--) {
			int next = target - (int)Math.pow(i, 2);
			int candidate = 1 + getMinimumFourSquare(next);
			if (candidate == 2) {
				table[target] = 2;
				return table[target];
			}
			resultTable[candidate] = true;
		}

		if (resultTable[3]) {
			table[target] = 3;
			return 3;
		}

		table[target] = 4;
		return 4;
	}

	private static boolean isPerfectSquare(double num) {
		double sqrt = Math.sqrt(num);
		return getClosestSqrtInt(num) == sqrt;
	}

	private static int getClosestSqrtInt(double num) {
		double sqrt = Math.sqrt(num);
		return (int)Math.floor(sqrt);
	}
}
