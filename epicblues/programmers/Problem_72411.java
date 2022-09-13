
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.TreeSet;

public class Problem_72411 {

  static HashMap<Integer, HashMap<String, Integer>> table = new HashMap<>();
  int maxSize;
  int minSize;

  public String[] solution(String[] orders, int[] course) {

    var answerTable = new LinkedList<String>();

    for (int size : course) {
      table.put(size, new HashMap<>());
    }

    minSize = course[0];
    maxSize = course[course.length - 1];

    for (String order : orders) {
      for (int i = 0; i < order.length(); i++) {
        // DFS
        var buffer = new TreeSet<Character>();
        DFS(i, order, buffer);
      }
    }

    for (int size : course) {
      int maxCount;
      var targetTable = table.get(size);
      if (targetTable.isEmpty()) {
        continue;
      }
      maxCount = targetTable.values().stream().max(Comparator.naturalOrder()).get();
      if (maxCount < 2) {
        continue;
      }
      targetTable.forEach((k, v) -> {
        if (v == maxCount) {
          answerTable.addLast(k);
        }
      });
    }

    answerTable.sort(Comparator.naturalOrder());

    return answerTable.toArray(new String[0]);
  }

  private void DFS(int index, String order, TreeSet<Character> buffer) {
    var nextChar = order.charAt(index);
    buffer.add(nextChar);

    if (table.containsKey(buffer.size())) {
      var keyBuilder = new StringBuilder();
      buffer.forEach(keyBuilder::append);
      var key = keyBuilder.toString();
      var targetTable = table.get(buffer.size());
      targetTable.put(key, targetTable.getOrDefault(key, 0) + 1);
    }
    if (buffer.size() == maxSize) {
      buffer.remove(nextChar);
      return;
    }
    for (int i = index + 1; i < order.length(); i++) {
      DFS(i, order, buffer);
    }

    buffer.remove(nextChar);

  }

}
