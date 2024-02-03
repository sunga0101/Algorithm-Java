

import java.io.*;
import java.util.*;
import java.math.*;
public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][] board;
    static boolean[][] visited;
    static int n,m;
    static int res = Integer.MAX_VALUE;


    public static void main(String[] args) throws IOException {
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        board = new int[n+1][m+1];
        visited = new boolean[n+1][m+1];

        for (int i=1;i<=n;i++){
            s = br.readLine().split("");
            for (int j=1;j<=m;j++){
                board[i][j] = Integer.parseInt(s[j-1]);
            }
        }
        BFS();
        bw.write(board[n][m]+"");
        bw.flush();
        br.close();

    }

    public static void BFS() throws IOException {
        int[] dx = {1,0,-1,0};
        int[] dy = {0,-1,0,1};

        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(1,1));
        visited[1][1] = true;

        while(!q.isEmpty()){
            Node node = q.poll();
            int x = node.x;
            int y = node.y;
            for (int k=0;k<4;k++){
                int nx = x+dx[k];
                int ny = y+dy[k];
                if (nx < 0 || ny < 0 || nx > n || ny > m)
                    continue;
                if (visited[nx][ny] || board[nx][ny] == 0)
                    continue;

                q.offer(new Node(nx,ny));
                board[nx][ny]=board[x][y]+1;
                visited[nx][ny] = true;

            }
        }
    }

}

class Node{
    int x;
    int y;
    public Node(int x, int y){
        this.x = x;
        this.y = y;
    }
}