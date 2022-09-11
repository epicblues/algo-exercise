import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Problem_2295 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    var nums = new Integer[n];
    for (int i = 0; i < n; i++) {
      nums[i] = Integer.parseInt(br.readLine());
    }

    Arrays.sort(nums, Comparator.reverseOrder());

    var minimumNumber = nums[n - 1];
    for (int i = 0; i < n; i++) {
      var candidate = nums[i];
      for (int j = i + 1; j < n; j++) {
        var firstCombination = nums[j];
        if (firstCombination + 2 * minimumNumber > candidate) {
          continue;
        }
        for (int k = j; k < n; k++) {
          var secondCombination = nums[k];
          if (firstCombination + secondCombination + minimumNumber > candidate) {
            continue;
          }
          for (int l = k; l < n; l++) {
            var thirdCombination = nums[l];
            if (firstCombination + secondCombination + thirdCombination == candidate) {
              System.out.println(candidate);
              return;
            }
          }
        }
      }
    }
  }

}
