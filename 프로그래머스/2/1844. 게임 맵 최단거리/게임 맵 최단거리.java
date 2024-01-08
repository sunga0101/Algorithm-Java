import java.util.*;

class Solution {
    static int answer = -1;
    static boolean check[][];
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};
    
    public int solution(int[][] maps) {
        check = new boolean[maps.length][maps[0].length];
        bfs(maps);
        return answer;
    }
    
    public void bfs(int[][] maps){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0,0,1));
        check[0][0] = true;
        
        while (!q.isEmpty()){
            Node cur = q.poll();
            
            if (cur.x == maps.length-1 && 
                cur.y ==maps[0].length-1){
                answer = cur.count;
                return;
            }
            
            for (int i = 0; i<4; i++){
                int nx = cur.x+dx[i];
                int ny = cur.y+dy[i];
                
                if (nx>=0&& nx < maps.length && 
                    ny>=0&& ny <maps[0].length && 
                    !check[nx][ny] && 
                    maps[nx][ny]==1){
                    
                    check[nx][ny] = true;
                    q.add(new Node(nx,ny, cur.count+1));
                }
            }
        }
        
        
        
    }
}

class Node {
    int x,y,count;
    public Node(int x, int y, int count){
        this.x = x;
        this.y = y;
        this.count = count;
    }
}