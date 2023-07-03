import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    private static int x,y,h,days = 0; // 상자의 크기
    static int[][][] board = new int[h][y][x];
    static Queue<int[]> queue;

    public static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = br.readLine().split(" ");

        x = Integer.parseInt(s[0]);
        y = Integer.parseInt(s[1]);
        h = Integer.parseInt(s[2]);
        board = new int[h][y][x];
        queue = new LinkedList<>();

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < y; j++) {
                s = br.readLine().split(" ");
                for (int k = 0; k < x; k++) {
                    board[i][j][k] = Integer.parseInt(s[k]); // 익은 토마토를 넣어둠
                    if (board[i][j][k]==1) queue.add(new int[]{i,j,k,0}); // h,y,x,0day
                }
            }
        }

        BFS();
        bw.write(days+"");
        bw.flush();
        br.close();
    }

    public static void BFS(){
        final int[] dx = {-1,1,0,0,0,0};
        final int[] dy = {0,0,-1,1,0,0};
        final int[] dz = {0,0,0,0,-1,1};

        while (!queue.isEmpty()){
            int[] visitInfo = queue.poll();
            if (visitInfo[3] != days) days=visitInfo[3]; // 지금 확인한 토마토의 day가 지금 day보다 이후면 업데이트
            for (int k = 0; k < 6; k++) {
                int nh = visitInfo[0]+dz[k];
                int ny = visitInfo[1]+dy[k];
                int nx = visitInfo[2]+dx[k];

                // 1. 범위 밖에 있을 때 2. 이미 익은 토마토일때
                if (nx < 0 || nx >= x || ny < 0 || ny >= y || nh < 0 || nh >= h) continue;
                if (board[nh][ny][nx]!=0) continue;

                // 그렇지 않으면
                board[nh][ny][nx]=1;
                queue.add(new int[]{nh,ny,nx,visitInfo[3]+1}); // 다음날에는 토마토가 익는다
            }
        }

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < y; j++) {
                for (int k = 0; k < x; k++) {
                    if (board[i][j][k] == 0)  // 하나라도 안익었다면
                        days=-1;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        solve();
    }
}
