package javatest.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Bj2164 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		CardPile cardPile = new CardPile(n);
		while (cardPile.hasMoreThanOneElement()) {
			cardPile.process();
		}

		System.out.println(cardPile.cards.getFirst());
	}

	static class CardPile {
		LinkedList<Integer> cards = new LinkedList<>();

		public CardPile(int n) {
			for (int i = 1; i <= n; i++) {
				cards.add(i);
			};
		}

		public void process() {
			cards.removeFirst();
			Integer removed = cards.removeFirst();
			cards.addLast(removed);
		}

		public boolean hasMoreThanOneElement() {
			return cards.size() > 1;
		}
	}
}
/*
1 2 3 4 5 6
3 4 5 6 2
5 6 2 4
2 4 6
6 4
4
 */