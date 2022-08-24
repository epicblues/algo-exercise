import java.util.*;

class Problem_77484 {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];        
        var table = new HashSet<Integer>();
        for(int num : win_nums) {
            table.add(num);
        }
        int zeroCount = 0;
        int lowestRank = 7;
        for(int num : lottos) {
            if(num == 0) {
                zeroCount++;
                continue;
            }
            if(table.contains(num)) {
                lowestRank--;
            }
        }
        answer[1] = lowestRank == 7 ? 6 : lowestRank;
        answer[0] = lowestRank - zeroCount;
        answer[0] = answer[0] == 7 ? 6 : answer[0];
        
        
        return answer;
    }
}
