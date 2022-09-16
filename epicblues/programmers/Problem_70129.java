class Problem_70129 {
    public int[] solution(String s) {

        var transCounter = 0;
        var zeroCounter = 0;

        while(!s.equals("1")) {
            var oneCount = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '1') {
                oneCount++;
            } else {
                zeroCounter++;
            }
        }
        s = Long.toString(oneCount, 2);
        transCounter++;
        }

        int[] answer = {transCounter, zeroCounter};
        return answer;
    }
}
