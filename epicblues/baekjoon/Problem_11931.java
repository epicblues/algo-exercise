import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_11931 {

  static int[] nums;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    nums = new int[n];
    for (int i = 0; i < n; i++) {
      nums[i] = Integer.parseInt(br.readLine());
    }

    // 퀵 정렬
    quickSortByIndex(0, nums.length - 1);

    var answer = new StringBuilder();
    for (int i = 0; i < n; i++) {
      answer.append(nums[i]).append("\n");
    }
    answer.deleteCharAt(answer.length() - 1);
    System.out.println(answer);
  }

  private static void quickSortByIndex(int start, int end) {
    if (start >= end) {
      return;
    }
    int pivot = (start + end) / 2;
    int pivotValue = nums[pivot];
    // 피벗 숫자를 앞으로 뺀다.
    int temp = nums[pivot];
    nums[pivot] = nums[start];
    nums[start] = temp;

    int leftIndex = start + 1;
    int rightIndex = end;
    while (leftIndex <= rightIndex) {
      int greaterNum = nums[leftIndex];
      int smallerNum = nums[rightIndex];

      if (greaterNum >= pivotValue) {
        leftIndex++;
        continue;
      }

      if (smallerNum < pivotValue) {
        rightIndex--;
        continue;
      }

      temp = nums[leftIndex];
      nums[leftIndex] = nums[rightIndex];
      nums[rightIndex] = temp;

    }

    temp = nums[rightIndex];
    nums[rightIndex] = nums[start];
    nums[start] = temp;

    quickSortByIndex(start, rightIndex - 1);
    quickSortByIndex(rightIndex + 1, end);

  }

}
