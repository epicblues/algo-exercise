import java.util.LinkedList;

class Solution {
	public int solution(int[] queue1, int[] queue2) {
		int answer = -2;

		LinkedList<Integer> list1 = new LinkedList<>();
		LinkedList<Integer> list2 = new LinkedList<>();

		int maxElement = 0;
		long sum = 0;
		long sumOfPartOne = 0;
		for (int i : queue1) {
			list1.addLast(i);
			sum += i;
			sumOfPartOne += i;
			maxElement = Math.max(maxElement, i);
		}

		long sumOfPartTwo = 0;
		for (int i : queue2) {
			list2.addLast(i);
			sum += i;
			sumOfPartTwo += i;
			maxElement = Math.max(maxElement, i);
		}


		if (maxElement > sum / 2 || sum % 2 == 1) {
			answer = -1;
		} else {
			answer = 0;
		}
		while (answer != -1 && sumOfPartOne != (sum / 2)) {
			answer++;
			if (sumOfPartOne > sumOfPartTwo) {
				Integer operValue = list1.removeFirst();
				sumOfPartOne -= operValue;
				sumOfPartTwo += operValue;
				list2.addLast(operValue);
			} else {
				Integer operValue = list2.removeFirst();
				sumOfPartTwo -= operValue;
				sumOfPartOne += operValue;
				list1.addLast(operValue);
			}

			if (answer > (queue1.length * 3)) {
				return -1;
			}
		}

		return answer;
	}
}
