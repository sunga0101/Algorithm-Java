import java.util.*;

class Solution {
    static boolean[][] visited;
    static int m,n;
    public int solution(int[][] maps) {
        m = maps.length;
        n = maps[0].length;
        visited = new boolean[m][n];
        return BFS(maps);
    }
    
    public int BFS(int[][] maps){
        int result = Integer.MAX_VALUE;
        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};
        int cnt = -1;
        if (maps[0][0] != 1) return -1;
        if (maps[m-1][n-1] != 1) return -1;
        
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0,0));
        visited[0][0]=true;
        maps[0][0] = 1;
        
        while(!q.isEmpty()){
            Node node = q.poll();
            int x = node.i;
            int y = node.j;
            
            if (x==m-1 && y==n-1 && maps[x][y] == 0) {
                return -1;
            }
            
            for (int k=0;k<4;k++){
                int nx = x+dx[k];
                int ny = y+dy[k];
                
                if (nx>=0&&nx<m&&ny>=0&&ny<n){
                    if(!visited[nx][ny]&&maps[nx][ny]==1){
                    q.offer(new Node(nx,ny));
                    visited[nx][ny]=true;
                    maps[nx][ny] = maps[x][y]+1;
                    }
                }
                
            }
        }
        if (visited[m-1][n-1])    
            return maps[m-1][n-1];
        else return -1;
    }
    
    class Node{
        int i;
        int j;
        public Node(int i,int j){
            this.i=i;
            this.j=j;
        }
    }
}
