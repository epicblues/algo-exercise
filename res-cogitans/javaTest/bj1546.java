package javaTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1546 {
    
    public static void main(String[] args) throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // int subjectCount = Integer.parseInt(br.readLine());
        // StringTokenizer st = new StringTokenizer(br.readLine());

        // int[] scores = new int[subjectCount];

        int subjectCount = 3;
        int[] scores = {40, 80, 60};

        // for (int i = 0; i < subjectCount; i++) {
        //     scores[i] = Integer.parseInt(st.nextToken());
        // }

        int theGreatest = getGreatestOf(scores);
        double sum = 0;

        for (int score: scores) {
            sum += getNewScoreOf(score, theGreatest);
        }

        System.out.println(sum/subjectCount);
    }

    private static int getGreatestOf(int[] numbers) {
        int max = 0;
        for (int number : numbers) {
            if (number >= max) {
                max = number;
            }
        }
        System.out.println(max);
        return max;
    }

    private static double getNewScoreOf(int score, int greatest) {
        return score * 100 / greatest;
    }
}