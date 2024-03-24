import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        int smallIdx = 0;
        Arrays.sort(people);
        
        for (int i=people.length-1;i>=0;i--){ // 몸무게 최고부터 내려감
            if (people[i] ==0)
                break;
            if (people[i]+people[smallIdx]<=limit){
                people[smallIdx] = 0;
                smallIdx++;
            }
            answer++;
        }
        
        return answer;
    }
}