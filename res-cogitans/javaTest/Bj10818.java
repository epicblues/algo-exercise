package javaTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj10818 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int minimum = 1000001;
		int maximum = -1000001;
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		while (st.hasMoreTokens()) {
			int i = Integer.parseInt(st.nextToken());
			if (i > maximum) {
				maximum = i;
			}
			if (i < minimum) {
				minimum = i;
			}
		}
		System.out.println(minimum + " " + maximum);
	}
}
