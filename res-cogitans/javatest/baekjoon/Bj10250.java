package javatest.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj10250 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());        //테스트 케이스의 수
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int h = Integer.parseInt(st.nextToken());    //가로
			int w = Integer.parseInt(st.nextToken());    //세로
			int n = Integer.parseInt(st.nextToken());    //몇 번째 손님인지

			int floor = ((n % h == 0) ? h : n % h) * 100;
			int room = (n - 1) / h + 1;
			sb.append(floor + room).append("\n");
		}

		System.out.println(sb);
	}
}
