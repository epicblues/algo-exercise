import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws IOException {

		//input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			int input = Integer.parseInt(br.readLine());
			queue.add(input);
		}

		//cal
		long sum = 0;
		int a = queue.poll();
		while (!queue.isEmpty()) {
			int b = queue.poll();
			int addCount = a + b;
			sum += addCount;
			queue.add(addCount);

			a = queue.poll();
		}
		System.out.println(sum);
	}

}
