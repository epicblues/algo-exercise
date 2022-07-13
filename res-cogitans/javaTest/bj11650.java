package javaTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj11650 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Coordinate[] coordinates = new Coordinate[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            coordinates[i] = new Coordinate(x, y);
        }

        Arrays.sort(coordinates);

        for (Coordinate coordinate : coordinates) {
            System.out.println(coordinate);
        }
    }

    public static class Coordinate implements Comparable<Coordinate> {
        
        int x;
        int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Coordinate c) {
            if (x == c.x && y == c.y) {
                return 0;
            }

            if (x < c.x) {
                return -1;
            }
            else if (x > c.x) {
                return 1;
            }
            else {
                if (y < c.y) {
                    return -1;
                }
                else {
                    return 1;
                }
            }
        }

        @Override
        public String toString() {
            return x + " " + y;
        }
    }
}
