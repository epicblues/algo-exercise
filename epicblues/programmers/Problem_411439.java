import java.util.*;

class Problem_411439 {
    public int solution(int[] nums) {
        var set = new HashSet<Integer>();
        for( int num : nums) {
            set.add(num);
        }
        
        return set.size() > nums.length / 2 ? nums.length / 2 : set.size();
    }
}
