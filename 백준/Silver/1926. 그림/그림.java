import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int [][]board;

    public void start() throws Exception{
        solve();
    }

    public static void main(String[] args) throws Exception {
        Main bfs = new Main();
        bfs.start();
    }

    private void solve() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);//ver
//        System.out.println("n"+n);
        int m = Integer.parseInt(input[1]); //hor
//        System.out.println("m"+m);

        int[] result;
        board = new int[n][m];
        for (int i=0; i < n; i++) {
            String []nums = br.readLine().split(" ");
            for (int j=0; j < m; j++) {
                int num = Integer.parseInt(nums[j]);
                board[i][j] = num;
            }
        }

        result = countPaint(board, n, m);
        System.out.printf("%d\n%d", result[0], result[1]);
    }

    private int[] countPaint(int [][]board, int n, int m){
        int[] result = new int[2];

        final int CHECK = 2; // 방문
        final int NOT_YET = 1; // 방문 x
        final int WALL = 0; // 갈 수 없음

        // 상하좌우
        final int[] moveX = {-1,1,0,0}; //행
        final int[] movey = {0,0,1,-1}; //열

        Queue<Integer[]> queue = new LinkedList<>();

        // 시작지점 찾기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j]==NOT_YET){
                    // 첫번째 도착지
                    board[i][j]=CHECK;
                    queue.offer(new Integer[]{i,j}); // 좌표 인덱스

                    int area = 1;
                    while(!queue.isEmpty()){
                       Integer []visited = queue.poll();
                        for (int k = 0; k < 4; k++) { // (-1,0)(1,0)(0,1)(1,0)
                            int x = visited[0]+moveX[k];
                            int y = visited[1]+movey[k];

                            if (x < 0 || y < 0 || x >= n || y >= m)
                                continue;

                            if(board[x][y] != NOT_YET)
                                continue;

                            board[x][y]=CHECK;
                            queue.add(new Integer[]{x,y}); // 좌표 인덱스
                            area+=1; // 넓이 ++
                        }
                    }
                    if (result[1] < area) result[1] = area;
                    ++result[0];
                }
            }
        }
        return result;
    }
    
}
