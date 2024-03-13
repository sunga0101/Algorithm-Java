import java.util.*;
class Solution {
    public int[] solution(int[] num_list) {
        List<Integer> list = new ArrayList<>();
        for (int i:num_list){
            list.add(i);
        }
        Collections.reverse(list);
        
        for (int i = 0; i < num_list.length; i++) {
            num_list[i] = list.get(i);
        }
        return num_list;
    }
}