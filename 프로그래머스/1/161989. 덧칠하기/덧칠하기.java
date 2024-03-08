import java.util.*;

class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 1;
        Queue<Integer> q = new LinkedList<>();
        for (int i: section){
            q.add(i);
        }
        
        
        int start = section[0];
        while(!q.isEmpty()){
            int end = start+m;
            int cur = q.peek();
            if (end>cur) q.poll();
            else {
                start = cur;
                answer++;

            }

        }
        return answer;
    }
}