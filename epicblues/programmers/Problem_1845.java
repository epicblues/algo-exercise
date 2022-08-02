import java.util.*;
class Problem_1845 {
    public int solution(int[] nums) {
        var map = new HashMap<Integer, Integer>();
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int maxCount = nums.length / 2;
        
        int answer = maxCount < map.size() ? maxCount : map.size();
        return answer;
    }
}
