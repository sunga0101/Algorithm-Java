import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int lostN = lost.length;
        int reserveN = reserve.length;
        HashSet<Integer> lostHash = new HashSet<>();
        HashSet<Integer> reserveHash = new HashSet<>();
        
        // 1. reverse에 lost 학생 있는지 체크 후 제외
        for (int i : reserve)
            reserveHash.add(i);
        for (int i : lost) {
            if (reserveHash.contains(i))
                reserveHash.remove(i);
            else
                lostHash.add(i);
        }
        
        // 2. 앞뒤에서 체육복 빌리기
        for (int j : reserveHash) {
            if (lostHash.contains(j-1)) // 앞사람이 체육복 있으면
                lostHash.remove(j-1);
            else if (lostHash.contains(j+1)) // 앞사람이 체육복 있으면
                lostHash.remove(j+1);
            
        }
        
        return n-lostHash.size();
    }
}