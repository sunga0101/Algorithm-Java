class Solution {
    public int[] solution(String[] park, String[] routes) {
        int W = park[0].length(); //가로길이
        int H = park.length; //세로길이
        String[][] board = new String[H][W];
        
        
        int x=0;
        int y=0;
        
        for (int i=0;i<H;i++){
            board[i] = park[i].split("");
            for (int j=0;j<W;j++){
                if (board[i][j].equals("S")) {
                    x=i; // 시작지점
                    y=j;
                }
            }
        }
        
        for (int i=0;i<routes.length;i++){
            char dir = routes[i].charAt(0);
            int dist = routes[i].charAt(2)-'0';
            
            int cx = x;
            int cy = y;
            
            for (int j=0;j<dist;j++){
                if (dir == 'E'){
                    y++;
                    if (y>=W || board[x][y].equals("X")){
                        x = cx;
                        y = cy;
                        break;
                    }
                    
                }
                else if (dir == 'S'){
                    x++;
                    if (x>=H || board[x][y].equals("X")){
                        x = cx;
                        y = cy;
                        break;
                    }
                }
                else if (dir == 'W'){
                    y--;
                    if (y<0 || board[x][y].equals("X")){
                        x = cx;
                        y = cy;
                        break;
                    }
                }
                else {
                    x--;
                    if (x<0 || board[x][y].equals("X")){
                        x = cx;
                        y = cy;
                        break;
                    }
                }
            }
        }
        
        int[] answer = {x,y};
        return answer;
    }
}