package javatest.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj7568 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Person[] people = new Person[n];

		StringTokenizer st;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			people[i] = new Person(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		for (int i = 0; i < n; i++) {
			System.out.println(getRank(people, i));
		}
	}

	private static int getRank(Person[] people, int targetIndex) {
		int rank = 1;
		for (int i = 0; i < people.length; i++) {
			if (i == targetIndex) continue;
			if (people[targetIndex].compareTo(people[i]) < 0) {
				rank++;
			}
		}
		return rank;
	}

	static class Person implements Comparable<Person> {
		int weight;
		int height;

		public Person(int weight, int height) {
			this.weight = weight;
			this.height = height;
		}

		@Override
		public int compareTo(Person other) {
			if (this.weight > other.weight && this.height > other.height) {
				return 1;
			}
			if (this.weight < other.weight && this.height < other.height) {
				return -1;
			}
			return 0;
		}
	}
}
