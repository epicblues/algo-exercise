package javatest.programmers;

/*
Level1, 부족한 금액 계산하기
https://school.programmers.co.kr/learn/courses/30/lessons/82612
 */
public class Prg82612 {
	static long[] priceCache = new long[2501];

	public long solution(int price, int money, int count) {
		priceCache[1] = price;

		long currentPrice = getPriceFor(price, count);

		return (currentPrice - money <= 0) ? 0 : currentPrice - money;
	}


	static long getPriceFor(int originalPrice, int countNow) {
		if (priceCache[countNow] == 0) {
			priceCache[countNow] = getPriceFor(originalPrice, countNow - 1) + originalPrice * countNow;
		}
		return priceCache[countNow];
	}
}
