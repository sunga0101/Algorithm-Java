
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int M, N;
    static int[][] board;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        Main tomato = new Main();
        tomato.solve();
    }

    public void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken()); // 행
        N = Integer.parseInt(st.nextToken()); // 열

        // 데이터 입력
        int res = 0;
        board = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                }
            }

        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 1) { // 익은 토마토를 큐에 넣는다
                    queue.offer(new int[]{i, j});
                }
            }
        }
        while(!queue.isEmpty()) {
            int[] visit = queue.poll();
            int visit_X = visit[0];
            int visit_Y = visit[1];

            for(int i=0; i<4; i++) { // 상하좌우 돌면서
                int moveX = visit_X + dx[i];
                int moveY = visit_Y + dy[i];

                if(moveX < 0 || moveX > N-1 || moveY < 0 || moveY > M-1)
                    continue;
                if(board[moveX][moveY] != 0) // 익지 않은 토마토를 찾아서 큐에 넣는다
                    continue;

                //그렇지 않으면
                board[moveX][moveY] = board[visit_X][visit_Y] + 1; // 가중치 더하기
                queue.offer(new int[] {moveX, moveY});
            }
        }
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(board[i][j] == 0) {
                    System.out.println(-1);
                    System.exit(0);
                }
                res = Math.max(res, board[i][j]); // 최대로 걸린 날짜 -> 최소일자
            }
        }
        System.out.println(res-1);
    }
}
