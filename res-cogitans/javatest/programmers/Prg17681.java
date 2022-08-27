package javatest.programmers;

/*
Level1, 비밀 지도
https://school.programmers.co.kr/learn/courses/30/lessons/17681
 */
public class Prg17681 {
	public static void main(String[] args) {
		int[] arg1 = {16,33,33,22,31,50};
		int[] arg2 = {27,56,19,14,14,10};

		String[] solution = new Prg17681().solution(6, arg1, arg2);

		for (String s : solution) {
			System.out.println(s);
		}
	}

	public String[] solution(int n, int[] arr1, int[] arr2) {
		String[] answer = new String[n];
		StringBuilder sb;

		for (int i = 0; i < n; i++) {
			sb = new StringBuilder();
			String binary1 = Integer.toBinaryString(arr1[i]);
			String binary2 = Integer.toBinaryString(arr2[i]);
			binary1 = fillEmptySpace(n, binary1);
			binary2 = fillEmptySpace(n, binary2);

			for (int j = 0; j < n; j++) {
				if (binary1.charAt(j) == '0' && binary2.charAt(j) == '0') {
					sb.append(' ');
				} else {
					sb.append('#');
				}
			}
			answer[i] = sb.toString();
		}

		return answer;
	}

	private String fillEmptySpace(int size, String target) {
		if (target.length() < size) {
			StringBuilder tmpSb = new StringBuilder();
			int needToFill = size - target.length();

			while (needToFill > 0) {
				tmpSb.append("0");
				needToFill--;
			}

			target = tmpSb.append(target).toString();
		}
		return target;
	}
}
