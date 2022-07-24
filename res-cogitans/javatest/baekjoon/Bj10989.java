package javatest.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj10989 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] toSort = new int[n];
		int[] cnt = new int [10001];
		for (int i = 0; i < n; i++) {
			toSort[i] = Integer.parseInt(br.readLine());
			cnt[toSort[i]]++;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < cnt.length; i++) {
			while (cnt[i] != 0){
				sb.append(i).append("\n");
				cnt[i]--;
			}
		}
		System.out.println(sb);
	}
}
