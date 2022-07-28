package javatest.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
Class3
Silver4
Greedy
 */
public class Bj11399 {
	static int[] timeForEachPeople;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		timeForEachPeople = new int[n];	//각 사람이 인출하는 데 걸리는 시간
		for (int i = 0; i < n; i++) {
			timeForEachPeople[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(timeForEachPeople);
		int neededTimeOfAll = 0;
		int previousNeededTime = 0;
		for (int i = 0; i <n; i++) {
			previousNeededTime += timeForEachPeople[i];
			neededTimeOfAll += previousNeededTime;
		}

		System.out.println(neededTimeOfAll);
	}
}
