import java.util.*;
class Solution {
    public int solution(int[] ingredient) {
        int count = 0;
        ArrayList<Integer> list = new ArrayList<>();
        
        for (int i: ingredient){
            list.add(i);
            while(list.size()>=4){
                int cr = list.size()-1;
                if (list.get(cr-3)==1 &&
                   list.get(cr-2)==2 &&
                   list.get(cr-1)==3 &&
                   list.get(cr)==1 ){
                        list.remove(cr);
                        list.remove(cr-1);
                        list.remove(cr-2);
                        list.remove(cr-3);
                    count++;
                    }
                else break;
                }
            }
        
        return count;
    }
}