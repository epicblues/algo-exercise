package javatest.programmers;
/*
Level1, 숫자 문자열과 영단어
https://school.programmers.co.kr/learn/courses/30/lessons/81301
 */
public class Prg81301 {
	public int solution(String s) {
		int index = 0;

		StringBuilder sb = new StringBuilder();

		while (index < s.length()) {
			char currentChar = s.charAt(index);
			if (s.charAt(index) <= 89) {
				sb.append(currentChar);
				index++;
			} else {
				char toAppend = ' ';
				int indexToAdd = 0;
				switch (currentChar) {
					case 'z':
						toAppend = '0';
						indexToAdd = 4;
						break;
					case 'o':
						toAppend = '1';
						indexToAdd = 3;
						break;
					case 't': {
						if (s.charAt(index + 1) == 'w') {
							toAppend = '2';
							indexToAdd = 3;
						} else {
							toAppend = '3';
							indexToAdd = 5;
						}
						break;
					}
					case 'f': {
						if (s.charAt(index + 1) == 'o') {
							toAppend = '4';
							indexToAdd = 4;
						} else {
							toAppend = '5';
							indexToAdd = 4;
						}
						break;
					}
					case 's': {
						if (s.charAt(index + 1) == 'i') {
							toAppend = '6';
							indexToAdd = 3;
						} else {
							toAppend = '7';
							indexToAdd = 5;
						}
						break;
					}
					case 'e': toAppend='8'; indexToAdd = 5; break;
					default: toAppend='9'; indexToAdd = 4;
				}
				sb.append(toAppend);
				index += indexToAdd;
			}
		}

		return Integer.parseInt(sb.toString());
	}
}

/*
0 z
1 o
2 tw
3 th
4 fo
5 fi
6 si
7 se
8 e
9 n
 */