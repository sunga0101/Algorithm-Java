class Solution {
    public int solution(String s) {
        int xCnt=1;
        int yCnt=0;
        int answer = 0;
        while(s.length()>1){
            char x = s.charAt(0);
            
            if (xCnt+yCnt>= s.length()) {
                break;
            }
            if (x == s.charAt(xCnt+yCnt)){
                xCnt++;
            }
            else yCnt++;
            
            if (xCnt == yCnt) { 
                s = s.substring(xCnt+yCnt,s.length());
                xCnt=1;
                yCnt=0;
                System.out.println("잘라");
                answer++;
            }
        }
        
        if (s.length()>0) answer++;
        return answer;
    }
}