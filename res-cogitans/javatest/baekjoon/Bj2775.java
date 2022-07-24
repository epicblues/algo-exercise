package javatest.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Bj2775 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < t; i++) {
			int result = ResidenceUnit.getResidentOf(new ResidenceUnit(Integer.parseInt(br.readLine()), Integer.parseInt(br.readLine())));
			sb.append(result).append("\n");
		}

		System.out.println(sb);
	}

	static Map<ResidenceUnit, Integer> cache = new HashMap<>();

	static class ResidenceUnit {
		static Set<ResidenceUnit> instancePool = new HashSet<>();

		int floor;
		int room;

		public ResidenceUnit(int floor, int room) {
			this.floor = floor;
			this.room = room;
		}

		static int getResidentOf(ResidenceUnit residenceUnit) {
			if (cache.containsKey(residenceUnit)) {
				return cache.get(residenceUnit);
			}
			int resident = 0;
			if (residenceUnit.floor == 0) {
				resident = residenceUnit.room;
			} else {
				for (int i = 0; i <= residenceUnit.room; i++) {
					resident += ResidenceUnit.getResidentOf(new ResidenceUnit(residenceUnit.floor - 1, i));
				}
			}
			cache.put(residenceUnit, resident);
			return resident;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o)
				return true;
			if (!(o instanceof ResidenceUnit))
				return false;

			ResidenceUnit that = (ResidenceUnit)o;

			if (floor != that.floor)
				return false;
			return room == that.room;
		}

		@Override
		public int hashCode() {
			int result = floor;
			result = 31 * result + room;
			return result;
		}
	}
}
