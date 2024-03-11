class Solution {
    public int solution(String[][] board, int h, int w) {
        int H = board.length;
        int W = board[0].length;
        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};
        String color = board[h][w];
        int cnt =0;
        
        for (int i=0;i<4;i++){
            int dh = h+dx[i];
            int dw = w+dy[i];
            
            if (dh>=0 && dh<H && dw>=0 && dw<W ){
                if (board[dh][dw].equals(color)) cnt++;
            }
        }
        return cnt;
    }
}