package javatest.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
백준 11047 동전
Class3, Sliver4, Greedy, https://www.acmicpc.net/problem/11047
 */
public class Bj11047 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());            //주어지는 동전 종류의 수
		int target = Integer.parseInt(st.nextToken());        //목표 금액 수치

		int[] coins = new int[n];
		for (int i = 0; i < n; i++) {
			coins[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(coins);

		int coinCount = 0;                                    //해답, 총 동전 개수
		int index = n - 1;
		while (target > 0) {
			coinCount += target /coins[index];
			target %= coins[index--];
		}

		System.out.println(coinCount);
	}
}
