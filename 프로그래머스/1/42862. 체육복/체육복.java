import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        ArrayList<Integer> li = new ArrayList<>();
        ArrayList<Integer> re = new ArrayList<>();
        for (int i:lost){
            li.add(i);
        }
        for (int i:reserve){
            re.add(i);
        }
        
        Collections.sort(li);
        Collections.sort(re);
        
        for (int i:reserve){
            if (li.contains(i)){
                li.remove(li.indexOf(i));
                re.remove(re.indexOf(i));
            }
        }
        
        for (Integer i:re){
            if (li.contains(i-1)){
                li.remove(li.indexOf(i-1));
            }
            else if (li.contains(i+1)){
                li.remove(li.indexOf(i+1));
            }
        }
        
        
        int answer = li.size();
        return n-answer;
    }
}