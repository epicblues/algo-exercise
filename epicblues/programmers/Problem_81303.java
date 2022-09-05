import java.util.Deque;
import java.util.LinkedList;

public class Problem_81303 {

  public String solution(int n, int k, String[] cmd) {

    Node head = new Node(0);

    Node front = head;
    Node cursor = null;

    if (k == 0) {
      cursor = head;
    }
    for (int i = 1; i < n; i++) {
      Node node = new Node(i);
      front.next = node;
      node.prev = front;
      if (i == k) {
        cursor = node;
      }
      front = node;
    }

    Deque<Node> deletedStack = new LinkedList<>();

    for (String command : cmd) {
      var key = command.charAt(0);

      if (key == 'U') {
        int offset = Integer.parseInt(command.split(" ")[1]);
        for (int i = 0; i < offset; i++) {
          if (cursor.prev == null) {
            break;
          }
          cursor = cursor.prev;
        }
        continue;
      }

      if (key == 'D') {
        int offset = Integer.parseInt(command.split(" ")[1]);
        for (int i = 0; i < offset; i++) {
          if (cursor.next == null) {
            break;
          }
          cursor = cursor.next;
        }
        continue;
      }

      if (key == 'C') {
        deletedStack.push(cursor);
        if (cursor.prev != null) {
          cursor.prev.next = cursor.next;
        }

        if (cursor.next != null) {
          cursor.next.prev = cursor.prev;
          cursor = cursor.next;
        } else {
          cursor = cursor.prev;
        }
        continue;
      }

      if (key == 'Z') {

        var restoredNode = deletedStack.pop();
        if (restoredNode.prev != null) {
          restoredNode.prev.next = restoredNode;
        }
        if (restoredNode.next != null) {
          restoredNode.next.prev = restoredNode;
        }
      }
    }

    var answerTable = new boolean[n];

    while (!deletedStack.isEmpty()) {
      answerTable[deletedStack.pop().data] = true;
    }

    var answerBuilder = new StringBuilder(n);

    for (int i = 0; i < n; i++) {
      answerBuilder.append(answerTable[i] ? 'X' : 'O');
    }

    return answerBuilder.toString();
  }

  static class Node {

    int data;
    Node prev;
    Node next;

    Node(int data) {
      this.data = data;
    }
  }

}
