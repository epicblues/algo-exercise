import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem_11725 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    List<Integer>[] graph = new List[n+1];
    
    for (int i = 1; i < graph.length; i++) {
      graph[i] = new LinkedList<>();
    }

    for (int i = 0; i < n - 1; i++) {
      var line = br.readLine().split(" ");

      int v1 = Integer.parseInt(line[0]);
      int v2 = Integer.parseInt(line[1]);

      graph[v1].add(v2);
      graph[v2].add(v1);
    }

    Queue<Integer> queue = new LinkedList<Integer>();

    queue.offer(1);

    var parentTable = new int[n + 1];

    while (!queue.isEmpty()) {
      var parent = queue.poll();

      for (int child : graph[parent]) {
        if (child == parentTable[parent]) {
          continue;
        }
        parentTable[child] = parent;
        queue.offer(child);
      }
    }

    var answer = new StringBuilder();
    for (int i = 2; i <= n; i++) {
      answer.append(parentTable[i]).append('\n');
    }
    answer.deleteCharAt(answer.length() - 1);

    System.out.println(answer);

  }

}
