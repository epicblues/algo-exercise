import java.util.Arrays;

class Solution {
	public int scoreGap = 0;
	public int[] answer = {-1};

	public int[] solution(int n, int[] info) {

		int[] count = new int[info.length];
		dfs(0, n, 10, count, info);
		return answer;
	}

	private void dfs(int score, int remain, int currIdx, int[] count, int[] apeach) {

		if (currIdx < 0 || remain == 0) {
			return;
		}
		//win
		if (apeach[currIdx] < remain) {
			int currRemain = remain - (apeach[currIdx] + 1);
			count[currIdx] = apeach[currIdx] + 1;
			int currScore = score + (10 - currIdx);
			int currInfoScore = getApeachScore(apeach, count);
			if (currScore - currInfoScore > scoreGap) {
				scoreGap = currScore - currInfoScore;
				answer = Arrays.copyOf(count, count.length);
				answer[answer.length - 1] = currRemain;
			}
			dfs(currScore, currRemain, currIdx - 1, count, apeach);
			count[currIdx] = 0;
		}

		//lose
		dfs(score, remain, currIdx - 1, count, apeach);
	}

	private int getApeachScore(int[] apeach, int[] count) {
		int score = 0;
		for (int i = 0; i < apeach.length; i++) {
			if (apeach[i] >= count[i] && apeach[i] != 0) {
				score += (10 - i);
			}
		}
		return score;
	}
}
