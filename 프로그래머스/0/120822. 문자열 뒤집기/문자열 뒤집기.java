import java.util.*;
class Solution {
    public String solution(String my_string) {
        String answer = "";
        ArrayList<Character> li = new ArrayList<>();
        for (char c:my_string.toCharArray()){
            li.add(c);
        }
        Collections.reverse(li);
        for (char c:li){
            answer+=c;
        }
        return answer;
    }
}