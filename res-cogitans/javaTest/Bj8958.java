package javaTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj8958 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[] answers = new String[n];
        for (int i = 0; i < n; i++) {
            answers[i] = br.readLine();
        }

        for (String answer : answers) {
            if (answer == null || answer == "") {
                continue;
            }
            System.out.println(getScore(answer));
        }
    }

    private static int getScore(String answer) {
        char[] answerArray = answer.toCharArray();
        int score = 0;
        int streak = 0;
        for (int i = 0; i < answerArray.length; i++) {
            if (answerArray[i] == 'O') {
                streak++;
                score += streak;
            }
            else {
                streak = 0;
            }
        }
        return score;
    }
}