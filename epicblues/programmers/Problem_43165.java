class Problem_43165 {
    
    int counter = 0;
    int targetNum;
    
    public int solution(int[] numbers, int target) {
        targetNum = target;
        // dfs 백트래킹
        
        int stage = 0;
        
        dfs(stage, 0, numbers, true);
        dfs(stage, 0 , numbers, false);
           
        
        return counter;
    }
    
    public void dfs(int stage, int sum, int[] numbers, boolean isPlus) {
        sum = isPlus ? sum + numbers[stage] : sum - numbers[stage];
        if(stage == numbers.length - 1) {
            // 끝에 도달했다.
            counter = targetNum == sum ? counter + 1 : counter;
           
        } else {
            dfs(stage + 1, sum, numbers, true);
            dfs(stage + 1, sum, numbers, false);
        }
        
        
        sum = isPlus ? sum - numbers[stage] : sum + numbers[stage];
    }
    
}
