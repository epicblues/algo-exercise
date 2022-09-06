import java.util.LinkedList;
import java.util.Queue;

public class Problem_81302 {

  public int[] solution(String[][] places) {
    int[] answer = {1, 1, 1, 1, 1};

    int[] dx = new int[]{0, 0, 1, -1};
    int[] dy = new int[]{1, -1, 0, 0};

    placeLoop:
    for (int k = 0; k < places.length; k++) {
      boolean[][] checked = new boolean[5][5];
      var place = places[k];
      for (int i = 0; i < 5; i++) {

        for (int j = 0; j < 5; j++) {
          if (place[i].charAt(j) != 'P') {
            continue;
          }

          Queue<Point> q = new LinkedList<>();
          q.offer(new Point(0, i, j));
          checked[i][j] = true;

          while (!q.isEmpty()) {
            var target = q.poll();
            if (target.depth > 0 && place[target.row].charAt(target.col) == 'P') {
              answer[k] = 0;
              continue placeLoop;
            }
            if (target.depth == 2) {
              continue;
            }

            // 추가 탐색
            for (int l = 0; l < 4; l++) {
              int newX = target.row + dx[l];
              int newY = target.col + dy[l];

              if (newX >= 0 && newX < 5 && newY >= 0 && newY < 5 && place[newX].charAt(newY) != 'X' && !checked[newX][newY]) {
                checked[newX][newY] = true;
                q.offer(new Point(target.depth + 1, newX, newY));
              }

            }
          }

        }
      }
    }

    return answer;
  }

  static class Point {

    int depth;
    int row;
    int col;

    public Point(int depth, int row, int col) {
      this.depth = depth;
      this.row = row;
      this.col = col;
    }
  }
}
