;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.TreeSet;

public class Problem_7785 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    var table = new TreeSet<String>(Comparator.reverseOrder());

    for (int i = 0; i < n; i++) {

      var name = br.readLine().split(" ")[0];

      if (!table.contains(name)) {
        table.add(name);
        continue;
      }

      table.remove(name);
    }

    var answer = new StringBuilder();

    for (String name : table) {
      answer.append(name).append("\n");
    }

    answer.deleteCharAt(answer.length() - 1);

    System.out.println(answer);

  }

}
