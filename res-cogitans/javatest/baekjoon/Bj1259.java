package javatest.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj1259 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        while (true) {
            input = br.readLine();
            if (input.equals("0")) {
                break;
            }
            if (isPalindrome(input)) {
                System.out.println("yes");
            }
            else {
                System.out.println("no");
            }
        }
    }

    public static boolean isPalindrome(String s) {
        if (s.length() == 1) {
            return true;
        }

        for (int i = 0; i < s.length() / 2 + 1; i++) {
            if (s.charAt(i) != s.charAt(s.length() -i - 1)) {
                return false;
            }
        }
        return true;
    }
}
