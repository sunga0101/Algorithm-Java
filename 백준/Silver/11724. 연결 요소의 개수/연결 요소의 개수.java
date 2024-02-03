

import java.io.*;
import java.util.*;
import java.math.*;
public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int n;
    static int[][] adjArr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]); // 정점 개수
        int m = Integer.parseInt(s[1]); // 간선 출력 횟수

        // 인접 행렬
        adjArr = new int[n+1][n+1];
        for (int i=0;i<m;i++){
            s = br.readLine().split(" ");
            int v1 = Integer.parseInt(s[0]);
            int v2 = Integer.parseInt(s[1]);
            adjArr[v1][v2] = 1;
            adjArr[v2][v1] = 1;
        }

        // 방문 체크
        visited = new boolean[n+1];

        int result = 0;
        for (int i=1;i<=n;i++){
            if (!visited[i]) {
                DFS(i);
                result++;
            }
        }
        bw.write(result+"");
        bw.flush();
        br.close();
    }

    public static void DFS(int i){
        for (int j=1;j<=n;j++){
            if (adjArr[i][j]==1 && !visited[j]){
                visited[j] = true;
                DFS(j);
            }
        }
    }


}