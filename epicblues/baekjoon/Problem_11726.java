import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_11726 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// DP bottom up으로 해보자
		int n = Integer.parseInt(br.readLine());
		var table = new int[1001];

		table[1] = 1;
		table[2] = 2;

		//

		for (int i = 3; i <= n; i++) {

			table[i] = (table[i - 2] + table[i - 1]) % 10007;
		}

		System.out.println(table[n]);
	}
}
