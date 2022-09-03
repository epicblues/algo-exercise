import java.util.Deque;
import java.util.LinkedList;

public class Problem_42883 {
	public String solution(String number, int k) {
		Deque<Character> checkedNums = new LinkedList<>();

		int count = 0;
		int uncheckedPointer = 0;
		while (count < k && uncheckedPointer < number.length()) {
			char targetNum = number.charAt(uncheckedPointer);
			if (checkedNums.isEmpty()) {
				checkedNums.addLast(targetNum);
				uncheckedPointer++;
				continue;
			}
			char beforeNum = checkedNums.getLast();
			if (beforeNum < targetNum) {
				checkedNums.removeLast();
				count++;
				continue;
			}
			checkedNums.addLast(targetNum);
			uncheckedPointer++;

		}

		while (uncheckedPointer < number.length()) {
			checkedNums.addLast(number.charAt(uncheckedPointer++));
		}

		while (count < k) {
			checkedNums.removeLast();
			count++;
		}

		var answer = new StringBuilder();
		for (char ch : checkedNums) {
			answer.append(ch);
		}

		return answer.toString();
	}
}
