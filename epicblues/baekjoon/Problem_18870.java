import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class Problem_18870 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		TreeSet<Integer> set = new TreeSet<>();
		var nums = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(nums[i]);
			set.add(num);
		}
		Map<Integer, Integer> realMap = new HashMap<>();
		for (int i = 0; !set.isEmpty(); i++) {
			realMap.put(set.pollFirst(), i);
		}
		var answer = new StringBuilder();
		for (String s : nums) {
			int num = Integer.parseInt(s);
			answer.append(realMap.get(num)).append(" ");
		}
		answer.deleteCharAt(answer.length() - 1);
		System.out.println(answer);

	}
}
