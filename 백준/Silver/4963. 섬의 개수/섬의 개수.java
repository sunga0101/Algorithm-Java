

import java.io.*;
import java.util.*;
import java.math.*;
public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n,m;
    static int[][] board;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        String str;
        while(!(str = br.readLine()).equals("0 0")) {
            String[] s = str.split(" ");
            m = Integer.parseInt(s[0]);
            n = Integer.parseInt(s[1]);
            board = new int[n][m];
            visited = new boolean[n][m];
            for (int i = 0; i < n; i++) {
                s = br.readLine().split(" ");
                for (int j = 0; j < m; j++) {
                    board[i][j] = Integer.parseInt(s[j]);
                }
            }

            int result = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (DFS(i, j)) {
                        result++;
                    }
                }
            }
            bw.write(result + "\n");
        }
        bw.flush();
        br.close();
    }

    public static boolean DFS(int x,int y){
        if (x<0||x>=n||y<0||y>=m) return false;
        if (board[x][y]==1 && !visited[x][y]){
            visited[x][y] = true;
            //상 하 좌 우 좌상 좌하 우상 우하
            DFS(x-1,y); // 상
            DFS(x+1,y); // 하
            DFS(x,y-1); // 좌
            DFS(x,y+1); // 우
            DFS(x+1,y+1);
            DFS(x+1,y-1);
            DFS(x-1,y-1);
            DFS(x-1,y+1);
            return true;
        }
        return false;
    }

}