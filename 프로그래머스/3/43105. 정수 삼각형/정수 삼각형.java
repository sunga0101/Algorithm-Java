class Solution {
    public int solution(int[][] triangle) {
        int lev = triangle.length; // 높이
        int[][] val = new int[lev+1][lev+1];
        int[][] w = new int[lev+1][lev+1];
        w[1] = triangle[lev-1];
        
        for (int i=lev-1;i>=0;i--){
            val[lev-i] = triangle[i];
        }
        
        
        for (int i=2;i<lev+1;i++){
            for (int j=0;j<val[i].length;j++){
                w[i][j] = val[i][j]+Math.max(w[i-1][j],w[i-1][j+1]); 
            }
        }
        
        int answer = w[lev][0];
        return answer;
    }
}