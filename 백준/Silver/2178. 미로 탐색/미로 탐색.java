
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int[][] board;

    public void start() throws IOException {
        solve();
    }

    public void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");
        int n = Integer.parseInt(in[0]);
        int m = Integer.parseInt(in[1]);

        // 데이터 넣기
        board = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] str = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                int num = Integer.parseInt(str[j]);
                board[i][j] = num;
            }
        }
        int result = count(board, n, m);
        System.out.println(result);

    }

    public int count(int[][] board, int n, int m) {

        final int[] dx = {-1, 1, 0, 0};
        final int[] dy = {0, 0, 1, -1};
        final int NOT_YET = 1; // 갈 수 있는 곳

        Queue<Integer[]> queue = new LinkedList<>();
        boolean[][] check = new boolean[n][m];

        // 첫번째 위치 경우
        check[0][0]= true; // 방문
        queue.offer(new Integer[]{0, 0});

        while (!queue.isEmpty()) {
            Integer[] visited = queue.poll();
            int visitX = visited[0];
            int visitY = visited[1];

            for (int k = 0; k < 4; k++) {
                int x = visitX + dx[k];
                int y = visitY + dy[k];

                if (x >= 0 && x < n && y >= 0 && y < m) {
                    if (board[x][y] == NOT_YET && !check[x][y]) {
                        queue.offer(new Integer[]{x, y}); // 방문
                        board[x][y] = board[visitX][visitY] + 1; // 이전 방문한 곳 + 1
                        check[x][y]= true; // 방문함
                        //System.out.printf("board[x][y]: %d, x,y:%d,%d\n",board[x][y], x,y);
                    }
                }
            }
        }
        return board[n-1][m-1];
    }

    public static void main(String[] args) throws IOException {
        Main miro = new Main();
        miro.start();
    }
}