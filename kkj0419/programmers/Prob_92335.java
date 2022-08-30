import java.util.HashSet;
import java.util.Set;

class Solution {
	public Set<Long> valueSet = new HashSet<>();

	public int solution(int n, int k) {
		int answer = 0;
		String convertedString = convertToString(n, k);
		String[] valueArray = convertedString.split("0");

		for (String value : valueArray) {
			if (!value.equals("") && isPrimeNumber(Long.valueOf(value))) {
				answer++;
			}
		}

		return answer;
	}

	private boolean isPrimeNumber(long number) {
		if (valueSet.contains(number)) {
			return true;
		}
		if (number == 1) {
			return false;
		}

		boolean flag = true;
		for (long i = 2; i * i <= number; i++) {
			if (number % i == 0) {
				flag = false;
				break;
			}
		}

		if (flag) {
			valueSet.add(number);
			return true;
		}
		return false;
	}

	private String convertToString(int n, int k) {
		StringBuilder sb = new StringBuilder();
		while (n >= k) {
			int value = n % k;
			sb.append(value);
			n /= k;
		}
		sb.append(n);

		return sb.reverse().toString();
	}
}
