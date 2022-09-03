package javatest.programmers;

/*
Level1, 키패드 누르기
https://school.programmers.co.kr/learn/courses/30/lessons/67256
 */
public class Prg67256 {
	/*
		0  1  2
		3  4  5
		6  7  8
		9  10 11
	*/
	static int lPos = 9;
	static int rPos = 11;
	static boolean isLeft = false;

	public String solution(int[] numbers, String hand) {

		if (hand.equals("left")) {
			isLeft = true;
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < numbers.length; i++) {
			switch (numbers[i]) {
				case 1, 4, 7: {
					sb.append(leftArea(numbers[i] - 1));
					break;
				}
				case 3, 6, 9: {
					sb.append(rightArea(numbers[i] -1));
					break;
				}
				default: {
					if (numbers[i] == 0) {
						sb.append(middleArea(10));

					} else {
						sb.append(middleArea(numbers[i] - 1));
					}
					break;
				}
			}
		}

		return sb.toString();
	}

	private char leftArea(int button) {
		lPos = button;
		return 'L';
	}

	private char rightArea(int button) {
		rPos = button;
		return 'R';
	}

	// 1, 4, 7, 10
	static int[][] distance = {
		{1, 0, 1, 2, 1, 2, 3, 2, 3, 4, 3, 4},
		{2, 1, 2, 1, 0, 1, 2, 1, 2, 3, 2, 3},
		{3, 2, 3, 2, 1, 2, 1, 0, 1, 2, 1, 2},
		{4, 3, 4, 3, 2, 3, 2, 1, 2, 1, 0, 1}
	};

	private char middleArea(int button) {
		int lDistance = 5;
		int rDistance = 5;
		switch (button) {
			case 1: {
				lDistance = distance[0][lPos];
				rDistance = distance[0][rPos];
				break;
			}
			case 4: {
				lDistance = distance[1][lPos];
				rDistance = distance[1][rPos];
				break;
			}
			case 7: {
				lDistance = distance[2][lPos];
				rDistance = distance[2][rPos];
				break;
			}
			case 10: {
				lDistance = distance[3][lPos];
				rDistance = distance[3][rPos];
				break;
			}
			default:
				throw new IllegalArgumentException();
		}

		boolean isForLeft = false;

		if (lDistance == rDistance) {
			if (isLeft) {
				lPos = button;
				isForLeft = true;
			} else {
				rPos = button;
			}
		} else {
			if (lDistance < rDistance) {
				isForLeft = true;
				lPos = button;
			} else {
				rPos = button;
			}
		}

		return (isForLeft) ? 'L' : 'R';
	}
}
