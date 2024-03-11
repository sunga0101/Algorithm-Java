import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i=0;i<participant.length;i++){
            map.put(participant[i], map.getOrDefault(participant[i],0)+1);
        }
        for (int i=0;i<completion.length;i++){
            if (map.containsKey(completion[i])){
                if (map.get(completion[i])==1)
                    map.remove(completion[i]);
                else map.replace(completion[i], map.get(completion[i]) - 1);
            }
        }
        
        String name="";
        Set<String> set = map.keySet();
        for (String s : set){
            name = s;
        }
        return name;
    }
}