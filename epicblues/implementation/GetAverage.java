package implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;


/* 
 * 평균 구하기 (소수점 첫째 자리수에서 반올림)
 * 입력
 * 3
  3 17 1 39 8 41 2 32 99 2
  22 8 5 123 7 2 63 7 3 46
  6 63 2 3 58 76 21 33 8 1 
 * 출력
 * #1 24
 * #2 29
 * #3 27
 */

public class GetAverage {
  public static void main(String[] args) throws Exception{
    var br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    var answer = new StringBuilder();
    
    for (int i = 0; i < N; i++) {
      var index = i + 1;
      var nums= br.readLine().split(" ");
      var sum = 0.0;
      for (String num : nums) {
        sum += Float.valueOf(num);
      }
      answer.append("#" + index).append(" ").append(Math.round(sum / nums.length)).append("\n");
      
    }
    System.out.println(answer);

  }
}
