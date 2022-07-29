import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_15964 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		var st = new StringTokenizer(br.readLine());
		long a = Long.parseLong(st.nextToken());

		long b = Long.parseLong(st.nextToken());

		System.out.println((a + b) * (a - b));

	}
}
