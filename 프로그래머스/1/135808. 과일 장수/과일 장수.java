import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int result = 0;
        int cnt = score.length; // 총 사과 개수
        Arrays.sort(score);
        
        int v = 1;
        while (cnt-m*v >= 0){
            result += score[cnt-m*v]*m;
            v++;
        }
        
        
        return result;
    }
}