package javaTest.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Bj10814 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int seq = 0;

        Member[] members = new Member[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            members[i] = new Member(age, name, ++seq);
        }

        Arrays.sort(members);

        for (Member member : members) {
            System.out.println(member);
        }
    }

    static class Member implements Comparable<Member> {
        int age;
        String name;
        int id;

        public Member(int age, String name, int id) {
            this.age = age;
            this.name = name;
            this.id = id;
        }

        @Override
        public String toString() {
            return age + " " + name;
        }

        @Override
        public int compareTo(Member m) {
            if (age < m.age) {
                return -1;
            }
            else if (age > m.age) {
                return 1;
            }
            else {
                if (id < m.id) {
                    return -1;
                }
                else if (id > m.id) {
                    return 1;
                }
            }
            return 0;
        }
    }
}
