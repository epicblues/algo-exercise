import static java.util.Collections.binarySearch;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem_72412 {

  public int[] solution(String[] info, String[] queries) {

    var cache = new HashMap<String, Integer>();

    var answer = new int[queries.length];

    var queryCache = new HashMap<String, List<Float>>();

    var lang = List.of("000", "001", "010", "100");
    var otherTypes = List.of("00", "01", "10");
    for (String a : lang) {
      for (String b : otherTypes) {
        for (String c : otherTypes) {
          for (String d : otherTypes) {
            queryCache.put(a + b + c + d, new ArrayList<>());
          }
        }
      }
    }

    var langTable = Map.of("-", "000", "java", "100", "python", "010", "cpp", "001");
    var jobTable = Map.of("-", "00", "frontend", "01", "backend", "10");
    var careerTable = Map.of("-", "00", "junior", "01", "senior", "10");
    var foodTable = Map.of("-", "00", "chicken", "01", "pizza", "10");

    for (String row : info) {
      var recs = row.split(" ");
      for (String a : List.of("000", langTable.get(recs[0]))) {
        for (String b : List.of("00", jobTable.get(recs[1]))) {
          for (String c : List.of("00", careerTable.get(recs[2]))) {
            for (String d : List.of("00", foodTable.get(recs[3]))) {
              float num = Float.parseFloat(recs[4]);
              queryCache.get(a + b + c + d).add(num);
            }
          }
        }
      }
    }

    // 정렬
    for (List<Float> list : queryCache.values()) {
      list.sort(Comparator.naturalOrder());
    }

    for (int i = 0; i < queries.length; i++) {
      var queryBuilder = new StringBuilder();
      var query = queries[i].split(" and ");
      queryBuilder.append(langTable.get(query[0]));
      queryBuilder.append(jobTable.get(query[1]));
      queryBuilder.append(careerTable.get(query[2]));
      queryBuilder.append(foodTable.get(query[3].split(" ")[0]));

      int num = Integer.parseInt(query[3].split(" ")[1]);
      // 이분 탐색으로 최소 인덱스 찾는다.
      var targetList = queryCache.get(queryBuilder.toString());
      // 중복되는 상황을 고려하여 0.1 낮은 숫자를 탐색시킨다.
      // binarySearch에서 탐색이 실패했을 경우, 그 숫자보다 큰 숫자의 첫 번째 숫자의 index + 1을 음수로 반환한다.
      int index = binarySearch(targetList, num - 0.1f);
      answer[i] = targetList.size() + index - 1;
    }

    return answer;
  }

}
