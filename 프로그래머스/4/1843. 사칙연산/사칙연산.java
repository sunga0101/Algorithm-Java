class Solution {
    static int[][][] dp;
    static int[] numbers;
    static String[] oper;

    public int solution(String arr[]) {
        int n = arr.length/2; // 숫자 갯수 세기 위해
        
        // dp 세팅
        dp = new int[2][200][200];
        for (int i=0;i<n+1;i++){
            for (int j=0;j<n+1;j++){ // 0: 최댓값, 1: 최솟값
                dp[0][i][j] = Integer.MIN_VALUE;
                dp[1][i][j] = Integer.MAX_VALUE;
            }
        }
        
        // 각 배열 세팅
        numbers = new int[n+1];
        oper = new String[n];
        for (int i=0;i<arr.length;i++){
            if (i%2==0) { // 숫자일 때
                numbers[i/2] = Integer.parseInt(arr[i]);
            }
            else oper[i/2] = arr[i]; // 연산자일 때
        }
        
        return solve(0,0,n);
    }
    
    public int solve(int flag, int s, int e){
        // 나 자신인 경우
        if (s==e) return dp[flag][s][e] = numbers[s];

        // 이전에 구해둔 경우
        if (flag==0 && dp[flag][s][e] != Integer.MIN_VALUE) 
            return dp[flag][s][e];
        if (flag==1 && dp[flag][s][e] != Integer.MAX_VALUE) 
            return dp[flag][s][e];
        

        // 구하기
        dp[flag][s][e] = 0; // 방문 표시
        int result = (flag == 0) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        
        if (flag==0){ // 최댓값 구하기
            for (int op=s;op<e;op++){
                if (oper[op].equals("-")) // A(최대)-B(최소)
                    result = Math.max(result, solve(0,s,op)-solve(1,op+1,e));
                else // A(최대)+B(최대) 
                    result = Math.max(result, solve(0,s,op)+solve(0,op+1,e));
            }
        }
        if (flag==1){ // 최솟값 구하기
            for (int op=s;op<e;op++){
                if (oper[op].equals("-")) // A(최소)-B(최대)
                    result = Math.min(result, solve(1,s,op)-solve(0,op+1,e));
                else // A(최소)+B(최소) 
                    result = Math.min(result, solve(1,s,op)+solve(1,op+1,e));
            }
        }
        
        dp[flag][s][e] = result;
        return dp[flag][s][e];
    }
}