

import java.io.*;
import java.util.*;
import java.math.*;
public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static boolean[][] visited;
    static int[][] adjArr;
    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int i=0;i<T;i++){
            int n = Integer.parseInt(br.readLine());
            adjArr = new int[n+1][n+1];
            visited = new boolean[n+1][n+1];
            String[] s = br.readLine().split(" ");
            for (int j=1;j<=n;j++){
                int snum = Integer.parseInt(s[j-1]);
                adjArr[j][snum] = 1;
            }

            int cnt = 0;
            for (int x=1;x<n+1;x++){
                for (int y=1;y<n+1;y++){
                    if (!visited[x][y] && adjArr[x][y]==1){
                        DFS(x,y);
                        cnt++;
                    }
                }
            }
            bw.write(cnt+"\n");

        }
        bw.flush();
        br.close();
    }

    public static void DFS(int x, int y){
        visited[x][y] = true;
        int n = adjArr.length - 1;

        for (int i=1;i<=n;i++){
            if (adjArr[y][i]==1 && !visited[y][i]){
                DFS(y,i);
                break;
            }
        }
    }
}