import java.util.Arrays;


class Solution {
    
     public static boolean filter(int num) {
        int extra;
        while (num > 0) {
            extra = num % 10; // 맨 뒷자리
            if (extra == 0 || extra == 5) {
                num = num / 10;
            } else {
                return false;
            }
        }
        return true;
    }
    
    
    public int[] solution(int l, int r) {
        int[] answer = new int[r];
        int cnt = 0;
        for (int i = l; i <= r; i++) {
            if (filter(i)) {
                answer[cnt] = i;
                cnt=cnt+1;
            }
        }
        answer = Arrays.stream(answer)
                .filter(i -> i != 0)
                .toArray();

        if (answer.length == 0) {
            int[] res = {-1};
            return res;

        }
        
        return answer;
    }
}