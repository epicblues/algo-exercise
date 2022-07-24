package javatest.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj1085 {
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());

		int xFastest = getFastest(x, w);
		int yFastest = getFastest(y, h);
		System.out.println((xFastest < yFastest) ? xFastest : yFastest);
	}

	private static int getFastest(int now, int end) {
		if (now > end - now) {
			return end - now;
		}
		return now;
	}
}
