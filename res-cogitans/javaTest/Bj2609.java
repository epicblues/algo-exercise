import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Bj2609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n1 = Integer.parseInt(st.nextToken());
        int n2 = Integer.parseInt(st.nextToken());

        System.out.println(getGCD(n1, n2));
        System.out.println(getLCM(n1, n2));
    }

    public static int getGCD(int n1, int n2) {
        if (n1 == n2) {
            return n1;
        }
        int gcd = 1;

        int small = (n1 > n2) ? n2 : n1;
        int big = (n1 > n2) ? n1: n2;

        List<Integer> cdList = getCD(small);

        for (Integer cd : cdList) {
            if (big % cd == 0) {
                gcd = cd;
            }
        }

        return gcd;
    }

    private static List<Integer> getCD(int n) {
        List<Integer> cdList = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (n % i == 0) {
                cdList.add(i);
            } 
        }

        return cdList;
    }

    public static int getLCM(int n1, int n2) {
        if (n1 == n2) {
            return n1;
        }

        int small = (n1 > n2) ? n2 : n1;
        int big = (n1 > n2) ? n1: n2;

        for (int i = 1; ; i++) {
            int m = big * i;

            if (m % small == 0) {
                return m;
            }
        }
    }
}