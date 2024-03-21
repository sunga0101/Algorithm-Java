import java.util.*;
class Solution
{
    public int solution(String s)
    {
        int answer = -1;
        int idx = 0;
        Stack<Character> st = new Stack<>();
        st.push(s.charAt(idx));
        
        for (int i=1;i<s.length();i++){
            char c = s.charAt(i);
            if (!st.isEmpty() && st.peek() == c){
                st.pop();
            }
            else {
                st.push(c);
            }
        }
        
        if (st.isEmpty()) answer = 1;
        else answer = 0;
        return answer;
    }
}