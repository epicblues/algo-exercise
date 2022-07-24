package javatest.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Bj18111 {
	static Map<Integer, Integer> blockLevelCounts = new HashMap<>();
	static int b;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());

		int greatest = 0;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				int input = Integer.parseInt(st.nextToken());
				greatest = (greatest < input) ? input : greatest;
				if (blockLevelCounts.containsKey(input)) {
					blockLevelCounts.put(input, blockLevelCounts.get(input) + 1);
				} else {
					blockLevelCounts.put(input, 1);
				}
			}
		}

		Set<Integer> levels = blockLevelCounts.keySet();

		if (levels.size() == 1) {
			System.out.println("0 " + levels.toArray()[0]);
			return;
		}

		int best = Integer.MAX_VALUE;
		int bestLevel = -1;

		for (int i = 0; i <= greatest; i++) {
			Need need = getNeedToMake(i);

			if (need == null) {
				continue;
			}
			if (need.toFill > need.toCut + b) {
				continue;    //해당 레벨로 만들 수 없음(블록 수 부족)
			}
			if (need.getTimeForFinish() < best) {
				best = need.getTimeForFinish();
				bestLevel = i;
			} else if (need.getTimeForFinish() == best) {
				bestLevel = (i > bestLevel) ? i : bestLevel;
			}
		}

		System.out.println(best + " " + bestLevel);
	}

	private static Need getNeedToMake(int level) {
		if (level > 256) {
			return null;
		}

		Set<Integer> levels = blockLevelCounts.keySet();
		int needsToFill = 0;
		int needsToCut = 0;
		for (Integer eachLevel : levels) {
			if (eachLevel == level) {
				continue;
			}
			if (eachLevel > level) {
				needsToCut += (eachLevel - level) * blockLevelCounts.get(eachLevel);
			}
			if (eachLevel < level) {
				needsToFill += (level - eachLevel) * blockLevelCounts.get(eachLevel);
			}
		}

		return new Need(needsToFill, needsToCut);
	}

	static class Need {
		int toFill;
		int toCut;

		public Need(int toFill, int toCut) {
			this.toFill = toFill;
			this.toCut = toCut;
		}

		int getTimeForFinish() {
			return toFill + toCut * 2;
		}
	}
}