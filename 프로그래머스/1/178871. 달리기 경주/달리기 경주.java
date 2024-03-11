import java.util.*;
class Solution {
    public String[] solution(String[] players, String[] callings) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i=0;i<players.length;i++){
            map.put(players[i], i);
        }
        
        for (String player : callings){
            int rank = map.get(player);
            
            String front = players[rank-1];
            
            map.replace(front,rank); // 1순위 하락
            players[rank] = front;
            
            players[rank-1] = player;
            map.replace(player, rank-1); // 1순위 상승
            }
        
        String[] answer = new String[players.length];
        for (String key : map.keySet()){
            answer[map.get(key)] = key;
            }
        
        return answer;
    }
}