package javatest.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj2475 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int sum = 0;
        while(st.hasMoreTokens()) {
            int num = Integer.parseInt(st.nextToken());
            sum += num * num;
        }

        System.out.println(sum % 10);
    }
}