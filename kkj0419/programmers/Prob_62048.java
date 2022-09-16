class Solution {
	public long solution(int w, int h) {
    long answer;

		Long width = Long.valueOf(w);
		Long height = Long.valueOf(h);
		int quot = findQuotient(w, h);

		answer = width * height - (quot * findEnableRects(w / quot, h / quot));

		return answer;
	}

	private long findEnableRects(int w, int h) {
		long count = 0;

		for (int i = 0; i < h; i++) {
			double left = i * (double)w / h, right = (i + 1) * (double)w / h;
			count += (Math.ceil(right) - Math.floor(left));

		}
		return count;
	}


	private int findQuotient(int w, int h) {
		int dividend = Math.max(w, h);
		int divisor = Math.min(w, h);

		int remainder = -1;
		while (remainder != 0) {
			remainder = dividend % divisor;

			dividend = divisor;
			divisor = remainder;
		}
		return dividend;
	}
}
