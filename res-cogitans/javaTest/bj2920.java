package javaTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj2920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int previous = -1;
        boolean isAccesding = true;
        for (int i = 0; i < 8; i++) {
            String charAt = st.nextToken();

            int numI = Integer.parseInt(charAt);

            if (i == 0) {
                if (numI == 1) {
                    isAccesding = true;
                    previous = 1;
                }
                else if (numI == 8) {
                    isAccesding = false;
                    previous = 8;
                }
                else {
                    System.out.println("mixed");
                    return;
                }
            }
            else {
                if (isAccesding) {
                    if (numI == previous + 1) {
                        if (numI == 8) {
                            System.out.println("ascending");
                            return;
                        }
                        previous++;
                    }
                    else {
                        System.out.println("mixed");
                        return;    
                    }
                }
                if (!isAccesding) {
                    if (numI == previous - 1) {
                        if (numI == 1) {
                            System.out.println("descending");
                            return;
                        }
                        previous--;
                    }
                    else {
                        System.out.println("mixed");
                        return;    
                    }
                }
            }
        }
    }
}
