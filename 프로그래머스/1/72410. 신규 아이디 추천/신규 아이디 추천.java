import java.util.*;

class Solution {
    public String solution(String new_id) {
        
        String answer = "";
        new_id = new_id.toLowerCase(); // 1단계
        
        for (int i=0;i<new_id.length();i++){ // 2단계
            char ch = new_id.charAt(i);
            if (ch =='.' || ch=='_' || ch=='-'||
                ( ch <= '9' && ch >= '0') || 
                (ch >='a' && ch<='z'))
                answer+=ch;
        }
        
        while (answer.contains("..")){ // 3단계
            answer = answer.replace("..",".");
        }
        
        if (answer.charAt(0)=='.') 
            answer = answer.substring(1,answer.length());
        if (answer.length() >1 && answer.charAt(answer.length()-1)=='.') 
            answer = answer.substring(0,answer.length()-1); // 4단계
        if (answer.length() ==0) answer="a"; // 5단계
        
        if (answer.length() >= 16) {
            answer=answer.substring(0,15);
            if (answer.charAt(14)=='.') answer = answer.substring(0,14); // 6단계
        }
        
        if (answer.length() <= 2) {
            char last = answer.charAt(answer.length()-1);
            int rep = 3-answer.length();
            answer += String.valueOf(last).repeat(rep) ; // 7단계
        }

        
        
        return answer;
    }
}