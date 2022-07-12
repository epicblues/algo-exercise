package javaTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj2675 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int r = Integer.parseInt(st.nextToken());
            char[] charArray = st.nextToken().toCharArray();
            String result = "";
            for (char c : charArray) {
                for (int j = 0; j < r; j++) {
                    result += c;
                }
            }
            System.out.println(result);
        }
    }
}
