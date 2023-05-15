
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] board;
    static boolean[][] visited;
    static int  M, N, posCnt;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int posX, posY;

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            posCnt = Integer.parseInt(st.nextToken()); // positionCount
            board = new int[M][N];
            visited = new boolean[M][N];

            for (int j = 0; j < posCnt; j++) {
                st = new StringTokenizer(br.readLine());
                posX = Integer.parseInt(st.nextToken());
                posY = Integer.parseInt(st.nextToken());
                board[posX][posY] = 1; // 배추 위치 설정
            }

            int cnt = 0; // 지렁이 갯수
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < N; k++) {
                    if (board[j][k] == 1 && !visited[j][k]) {
                        bfs(j, k);
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
        }
    }

    private static void bfs(int x, int y) {

        final int[] dx = { -1, 1, 0, 0 };
        final int[] dy = { 0, 0, -1, 1 };

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x,y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] visit = queue.poll();
            int visitX = visit[0];
            int visitY = visit[1];

            for (int k = 0; k < 4; k++) {
                int moveX = visitX + dx[k];
                int moveY = visitY + dy[k];

                if(moveX < 0 || moveY < 0 || moveX >= M || moveY >= N)
                    continue;
                if(visited[moveX][moveY])
                    continue;
                if(board[moveX][moveY] == 0)
                    continue;

                // 그렇지않으면 추가
                queue.offer(new int[]{moveX, moveY});
                visited[moveX][moveY] = true;
            }
        }
    }
}
