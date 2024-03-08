import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] rank = new int[k+1];
        int[] mini = new int[score.length];
        int minimum = score[0];
        
        if (k<= score.length){
            for (int i=0;i<k; i++){
                rank[i] = score[i];
                if (minimum>=rank[i])
                    minimum = rank[i];
                mini[i]=minimum;
            }
            Arrays.sort(rank);

            for (int i=k;i<score.length;i++){
                rank[0]=score[i];
                Arrays.sort(rank);
                rank[0]=0;
                mini[i]=rank[1];
            }
        }
        else {
            for (int i=0;i<score.length; i++){
                if (minimum>=score[i])
                    minimum = score[i];
                mini[i]=minimum;
            }
        }
        return mini;
    }
}