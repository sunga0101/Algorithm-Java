class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int fix = 0;
        int zeroCnt = 0;
        for (int i=0;i<6;i++){
            if (lottos[i]==0) zeroCnt++;
            for (int j=0;j<6;j++){
                if (lottos[i]==win_nums[j]){
                    lottos[i]=-1;
                    win_nums[j]=-1;
                    fix++;
                    break;
                }
            }
        }
        System.out.println(fix);
        System.out.println(zeroCnt);
        
        int[] answer = new int[2];
        
        if (fix<=1) answer[1] = 6;
        else answer[1] = 7-fix;
        
        zeroCnt += fix;
        if (zeroCnt<=1) answer[0] = 6;
        else answer[0] = 7-zeroCnt;
        
        return answer;
    }
}