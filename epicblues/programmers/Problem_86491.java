import java.util.Arrays;

public class Problem_86491 {
  
  public int solution(int[][] sizes) {

		if (sizes.length == 1) {
			return sizes[0][0] * sizes[0][1];
		}
		Arrays.sort(sizes, (a, b) -> {
			int frontMax = Math.max(a[0], a[1]);
			int lastMax = Math.max(b[0], b[1]);

			if (frontMax == lastMax) {
				return Integer.compare(Math.min(a[0], a[1]), Math.min(b[0], b[1]));
			}

			return -Integer.compare(frontMax, lastMax);
		});

		// 각 최소 size 중에 제일 작은 수 구하기

		int minMax = 0;

		for (int i = 1; i < sizes.length; i++) {
			var size = sizes[i];
			var min = Math.min(size[0], size[1]);
			minMax = Math.max(min, minMax);
		}

		return Math.max(sizes[0][0], sizes[0][1]) * minMax;
	}
}
