import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        Stack<Integer> stack = new Stack<>();
        int n = moves.length;
        int temp;
        int answer = 0;
        
        for (int i=0;i<n;i++){
            temp=0;
            int pos = moves[i]-1;
            for (int j=0;j<board.length;j++){
                if (board[j][pos] != 0){
                    temp = board[j][pos];
                    board[j][pos] = 0;
                    break;
                }
            }
            if (temp != 0) {
               if (!stack.isEmpty() &&stack.peek() == temp){
                   stack.pop();
                   answer += 2;
               }
                else {stack.push(temp);}
            }
        }
        return answer;
    }
}