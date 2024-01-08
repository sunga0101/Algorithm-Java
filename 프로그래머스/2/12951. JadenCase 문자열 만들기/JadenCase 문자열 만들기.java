import java.util.*;
class Solution {
    public String solution(String s) {
        // 1. 문자열 전부 소문자 전환
        s = s.toLowerCase();
        StringTokenizer st = new StringTokenizer(s," ", true);
        String answer = "";
        while(st.hasMoreTokens()) {
            String next = st.nextToken();
            if (next.equals(" ")) answer+=" "; // 그대로 출력
            else{
                answer+= next.substring(0,1).toUpperCase();
                answer+= next.substring(1);
            }
        }
        
        return answer;
    }
}