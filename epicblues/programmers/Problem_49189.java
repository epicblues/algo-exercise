import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Problem_49189 {

  public int solution(int n, int[][] edge) {

    List<List<Integer>> graph = new ArrayList<>(n + 1);
    for (int i = 0; i < n + 1; i++) {
      graph.add(new LinkedList<>());
    }

    for (int[] line : edge) {
      graph.get(line[0]).add(line[1]);
      graph.get(line[1]).add(line[0]);
    }
    int maxLength = 0;

    int[] distance = new int[n + 1];
    var queue = new LinkedList<Integer>();
    queue.add(1);
    while (!queue.isEmpty()) {
      int from = queue.poll();
      for (int next : graph.get(from)) {
        if (next == 1 || distance[next] != 0) {
          continue;
        }
        distance[next] = distance[from] + 1;
        if (maxLength < distance[next]) {
          maxLength = distance[next];
        }
        queue.add(next);
      }
    }
    int answer = 0;
    for (int i = 1; i < n + 1; i++) {
      if (distance[i] == maxLength) {
        answer++;
      }
    }
    return answer;
  }

}
