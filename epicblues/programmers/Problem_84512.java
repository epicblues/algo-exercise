// https://school.programmers.co.kr/learn/courses/30/lessons/84512

class Solution {
    public int solution(String word) {

        var table = Map.of(
            'A', 0,
            'E', 1,
            'I', 2,
            'O', 3,
            'U', 4
        );

        var length = word.length();
        var answer = 0;
        for (int i = 0; i < length; i++) {
            var target = word.charAt(i);
            var sum = table.get(target);
            sum *= summary(sum, i + 1);
            answer += ++sum;
        }

        return answer;
    }

    public int summary(int target, int stage) {
        if(stage == 5) {
            return 1;
        }
        if (stage == 4) {
            return 6;
        }

        return 1 + 5 * summary(target, stage + 1);
    }
}
