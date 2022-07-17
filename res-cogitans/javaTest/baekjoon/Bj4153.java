package javaTest.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Bj4153 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] length = new int[3];
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            length[0] = Integer.parseInt(st.nextToken());
            if (length[0] == 0) {
                break;
            }
            length[1] = Integer.parseInt(st.nextToken());
            length[2] = Integer.parseInt(st.nextToken());

            Arrays.sort(length);

            if (isRATri(length)) {
                System.out.println("right");
            }
            else {
                System.out.println("wrong");
            }
        }
    }

    private static boolean isRATri(int[] length) {
        if (length[0] * length[0] + length[1] * length[1] == length[2] * length[2]) {
            return true;
        }
        return false;
    }
}
