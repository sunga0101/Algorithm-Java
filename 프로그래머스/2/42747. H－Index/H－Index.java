import java.util.*;
class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        int h = 0;
        int n = citations.length;
        int count = 0;
        
        for (int i=0;i<citations[n-1];i++){ // h 값 최소0~최대6
            h = i;
            count = 0;
            for (int j=0;j<n;j++){
                if (citations[j]>=h){
                    count++;
                }
            }
            if (count>=h) continue;
            else {
                h-=1;
                break;
            }
        }
        
        return h;
    }
}