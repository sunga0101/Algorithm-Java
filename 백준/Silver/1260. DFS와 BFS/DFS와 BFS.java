import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int N,M,V;
    static int[][] map;
    static boolean[] visitedDepth;
    static boolean[] visitedBreadth;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        solve();
    }

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        V = Integer.parseInt(s[2]);

        map = new int[1024][1024];
        visitedDepth = new boolean[1024];
        visitedBreadth = new boolean[1024];
        for (int i = 0; i < M; i++) {
            s = br.readLine().split(" ");
            int x = Integer.parseInt(s[0]);
            int y = Integer.parseInt(s[1]);
            map[x][y] = 1;
            map[y][x] = 1;
        }

        dfs(V); // 작은 수부터 나오도록 max부터 탐색
        bw.write("\n");
        bfs(V);
        bw.flush();
        br.close();
    }

    private static void bfs(int x) throws IOException {
        queue.offer(x);
        visitedBreadth[x] = true;

        while (!queue.isEmpty()){
            int visitedX = queue.poll();
            bw.write(visitedX+" ");
            for (int i = 1; i <= N; i++) {
                if (!visitedBreadth[i] && map[visitedX][i]==1){
                    visitedBreadth[i]=true;
                    queue.offer(i);
                }
            }
        }
    }

    private static void dfs(int next) throws IOException {
        visitedDepth[next] = true;
        bw.write(next+" ");

        for (int i = 1; i <= N; i++) {
            if(!visitedDepth[i] && map[next][i]==1)
                dfs(i);
        }
    }
}
