

import java.io.*;
import java.util.*;
import java.math.*;
public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, cnt;
    static int[][] board;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        visited = new boolean[n][n];
        for (int i=0;i<n;i++){
            String[] s = br.readLine().split("");
            for (int j=0;j<n;j++){
                board[i][j] = Integer.parseInt(s[j]);
            }
        }

        int result = 0;
        LinkedList<Integer> cntList = new LinkedList<>();
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                cnt = 0;
                if (DFS(i,j)){
                    result++;
                    cntList.add(cnt);
                }
            }
        }
        bw.write(result+"\n");
        Collections.sort(cntList);
        for (int i:cntList){
            bw.write(i+"\n");
        }
        bw.flush();
        br.close();
    }

    public static boolean DFS(int x,int y){
        if (x<0||x>=n||y<0||y>=n) return false;
        if (board[x][y]==1 && !visited[x][y]){
            visited[x][y] = true;
            cnt++;
            DFS(x+1,y);
            DFS(x-1,y);
            DFS(x,y+1);
            DFS(x,y-1);
            return true;
        }
        return false;
    }

}