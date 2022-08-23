import java.util.Stack;

public class Problem_12906 {
	public int[] solution(int[] arr) {
		var stack = new Stack<Integer>();
		stack.push(arr[arr.length - 1]);
		for (int i = arr.length - 2; i >= 0; i--) {
			int num = arr[i];
			if (stack.peek() != num) {
				stack.push(num);
			}
		}

		var answer = new int[stack.size()];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = stack.pop();
		}
		return answer;

	}
}
