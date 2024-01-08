import java.util.*;
class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        
        int n = elements.length; // 원소 갯수
        Set<Integer> set = new HashSet<>(); // 중복 방지
        
        for (int i=0; i< n; i++){
            int sum=elements[i];
            set.add(sum);
            for (int j=i+1;j<n+i ; j++){
                sum+=elements[j%n];
                set.add(sum);
            }
        }
        
        return set.size();
    }
}