import java.util.List;
import java.util.Stack;

public class Problem_2_2 {

  public int solution(String s) {
    int answer = 0;
    var opener = List.of('(','[','{');
    var closer = List.of(')',']','}');

    // 1000 * 1000

    loop:
    for(int i = 0; i < s.length(); i++) {
      var stack = new Stack<Character>();
      for(int index = i; index < i + s.length(); index++) {
        int realIndex = index >= s.length() ? index - s.length() : index;
        var ch = s.charAt(realIndex);
        if(opener.contains(ch)) {
          stack.push(ch);
          continue;
        }
        if(stack.isEmpty()) {
          continue loop;
        }
        var popped = stack.pop();
        var openerIndex = opener.indexOf(popped);
        var closerIndex = closer.indexOf(ch);

        if(openerIndex != closerIndex) {
          continue loop;
        }
      }
      if(stack.isEmpty()) {
        answer++;
      }
    }

    return answer;
  }

}
