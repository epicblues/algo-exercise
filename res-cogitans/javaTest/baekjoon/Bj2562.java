package javaTest.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Bj2562 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = new int[9];
        for (int i = 0; i < 9; i++) {
            inputs[i] = Integer.parseInt(br.readLine());
        }

        int[] sorted = inputs.clone();
        Arrays.sort(sorted);

        int greatest = sorted[8];
        System.out.println(greatest);

        for (int i = 0; i < 9; i++) {
            if (inputs[i] == greatest) {
                System.out.println(i + 1);
            }
        }
    }
}
