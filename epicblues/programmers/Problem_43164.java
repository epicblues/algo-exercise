import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Problem_43164 {

  static String[][] ticketStorage;
  HashMap<String, List<Ticket>> map;
  List<String> path = new ArrayList<>();
  List<String> answerPath = new ArrayList<>();

  Comparator<List<String>> pathComparator = (l1, l2) -> {
    for (int i = 0; i < l1.size(); i++) {
      var l1Str = l1.get(i);
      var l2Str = l2.get(i);
      if (l1Str.compareTo(l2Str) == 0) {
        continue;
      }
      return l1Str.compareTo(l2Str);
    }
    return 0;
  };

  public String[] solution(String[][] tickets) {
    ticketStorage = tickets;
    map = new HashMap<>();

    for (String[] ticket : tickets) {
      map.putIfAbsent(ticket[1], new LinkedList<>());
      map.putIfAbsent(ticket[0], new LinkedList<>());
      var list = map.get(ticket[0]);
      list.add(new Ticket(ticket[1]));
      map.put(ticket[0], list);
    }

    path.add("ICN");

    var departure = "ICN";

    dfs(departure);

    return answerPath.toArray(new String[0]);
  }

  public void dfs(String departure) {
    if (path.size() == ticketStorage.length + 1) {
      answerPath = answerPath.isEmpty() || pathComparator.compare(answerPath, path) > 0 ? List.copyOf(path) : answerPath;
      path.remove(path.size() - 1);
      return;
    }
    
    var nextPath = map.get(departure);

    for (Ticket ticket : nextPath) {
      if (ticket.isUsed) {
        continue;
      }
      ticket.isUsed = true;
      path.add(ticket.target);
      dfs(ticket.target);
      ticket.isUsed = false;
    }

    path.remove(path.size() - 1);
  }

  static class Ticket {

    boolean isUsed = false;
    String target;

    Ticket(String target) {
      this.target = target;
    }
  }

}
