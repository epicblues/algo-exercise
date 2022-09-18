import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Problem_14719 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    var blockData = br.readLine().split(" ");
    int h = Integer.parseInt(blockData[0]);
    int w = Integer.parseInt(blockData[1]);
    int answer = 0;

    int[] heights = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

    for (int heightChecker = 1; heightChecker <= h; heightChecker++) {
      boolean isBlocked = false;
      int rainCandidate = 0;

      for (int i = 0; i < w; i++) {
        int height = heights[i];
        if (height >= heightChecker) {
          if (isBlocked && rainCandidate > 0) {
            answer += rainCandidate;
            rainCandidate = 0;
            continue;
          }
          isBlocked = true;
          continue;
        }

        if (isBlocked) {
          rainCandidate++;
        }
      }
    }

    System.out.print(answer);
  }

}
