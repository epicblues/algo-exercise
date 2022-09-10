import java.util.*;

class Problem_72412 {
  public int[] solution(String[] info, String[] queries) {

    var cache = new HashMap<String, Integer>();

    var answer = new int[queries.length];

    var table = new TreeMap<Integer, List<Integer>>();

    for (String rec : info) {
      var recArr = rec.split(" ");
      var recBuilder = new StringBuilder();
      if (recArr[0].charAt(0) == 'c') {
        recBuilder.append("001");
      } else if (recArr[0].charAt(0) == 'j') {
        recBuilder.append("010");
      } else {
        recBuilder.append("100");
      }
      if (recArr[1].charAt(0) == 'f') {
        recBuilder.append("01");
      } else {
        recBuilder.append("10");
      }
      if (recArr[2].charAt(0) == 'j') {
        recBuilder.append("01");
      } else {
        recBuilder.append("10");
      }
      if (recArr[3].charAt(0) == 'c') {
        recBuilder.append("01");
      } else {
        recBuilder.append("10");
      }

      var score = Integer.parseInt(recArr[4]);

      if (!table.containsKey(score)) {
        table.put(score, new LinkedList<>());
      }
      table.get(score).add(Integer.parseInt(recBuilder.toString(), 2));
    }

    for (int i = 0; i < queries.length; i++) {
      var queryBuilder = new StringBuilder();
      var query = queries[i].split(" and ");
      var lang = query[0].charAt(0);
      if (lang == '-') {
        queryBuilder.append("000");
      } else if (lang == 'c') {
        queryBuilder.append("001");
      } else if (lang == 'j') {
        queryBuilder.append("010");
      } else {
        queryBuilder.append("100");
      }
      var end = query[1].charAt(0);
      if (end == '-') {
        queryBuilder.append("00");
      } else if (end == 'f') {
        queryBuilder.append("01");
      } else {
        queryBuilder.append("10");
      }
      var career = query[2].charAt(0);
      if (career == '-') {
        queryBuilder.append("00");
      } else if (career == 'j') {
        queryBuilder.append("01");
      } else {
        queryBuilder.append("10");
      }
      var food = query[3].charAt(0);
      if (food == '-') {
        queryBuilder.append("00");
      } else if (food == 'c') {
        queryBuilder.append("01");
      } else {
        queryBuilder.append("10");
      }
      var score = Integer.parseInt(query[3].split(" ")[1]);
      var numQuery = Integer.parseInt(queryBuilder.toString(), 2);
      var cacheKey = "" + numQuery + " " + score;
      if (cache.containsKey(cacheKey)) {
        answer[i] = cache.get(cacheKey);
        continue;
      }

      for (List<Integer> list : table.tailMap(score, true).values()) {
        for (int num : list) {
          answer[i] = (num & numQuery) == numQuery ? answer[i] + 1 : answer[i];
        }
        cache.put(cacheKey, answer[i]);
      }

    }

    return answer;
  }

}
