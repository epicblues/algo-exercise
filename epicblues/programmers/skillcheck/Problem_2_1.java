;
import java.util.LinkedList;

public class Problem_2_1 {

  public int solution(String skill, String[] skill_trees) {
    int answer = 0;
    var skillTable = new HashSet<Character>();
    for (int i = 0; i < skill.length(); i++) {
      skillTable.add(skill.charAt(i));
    }
    loop:
    for (String tree : skill_trees) {
      var queue = new LinkedList<Character>();
      for (int i = 0; i < skill.length(); i++) {
        queue.offer(skill.charAt(i));
      }

      for (int i = 0; i < tree.length(); i++) {
        char ch = tree.charAt(i);
        if (skillTable.contains(ch)) {
          if (queue.poll() != ch) {
            continue loop;
          }

        }
      }

      answer++;

    }

    return answer;
  }
}
