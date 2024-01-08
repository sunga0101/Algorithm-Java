import java.util.*;

class Solution {
    public String solution(String s) {
        String[] str = s.split(" ");
        int[] nArr = new int[str.length];
        for (int i=0; i<str.length; i++){
            nArr[i]=Integer.parseInt(str[i]);
        }
        Arrays.sort(nArr);
        String answer = nArr[0]+" "+nArr[str.length-1];
        return answer;
    }
}