
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static char[][] picRGB, picRB;
    static boolean[][] visitRGB, visitRB;
    static int size;
    static int cntRGB, cntRB;
    
    public static void main(String[] args) throws IOException {
        Main color = new Main();
        color.start();
    }

    public void start() throws IOException {
        solve();
    }

    public void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());

        picRGB = new char[size][size]; //  적록색약이 아닌 사람이 보는 그림
        picRB = new char[size][size];  //  적록색약이 보는 그림

        visitRGB = new boolean[size][size];
        visitRB = new boolean[size][size];

        cntRB = 0;
        cntRGB = 0;

        // 데이터 입력
        for (int i = 0; i < size; i++) {
            String s = br.readLine();
            for (int j = 0; j < size; j++) {
                picRGB[i][j] = s.charAt(j);

                if (s.charAt(j) == 'G')
                    picRB[i][j] = 'R';
                else
                    picRB[i][j] = s.charAt(j);
            }
        }

        //bfs 실행
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                // 적록색약 아닌경우
                if(!visitRGB[i][j]) { // 방문 전이라면
                    bfs(i, j, picRGB[i][j], picRGB, visitRGB);
                    cntRGB++;
                }
                // 적록색약인 경우
                if(!visitRB[i][j]) { // 방문 전이라면
                    bfs(i, j, picRB[i][j], picRB, visitRB);
                    cntRB++;
                }
            }
        }// 모든 좌표 다 돌고 결과출력
        System.out.println(cntRGB+" "+cntRB);
    }

    public void bfs(int x, int y, char value,char[][] pic, boolean[][] visit ){
        final int[] dx = {-1,1,0,0};
        final int[] dy = {0,0,1,-1};
        visit[x][y] = true; // 방문한 곳 표시

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x,y});

        while (! queue.isEmpty()){
            int[] v =queue.poll();
            for (int k = 0; k < 4; k++) {
                int moveX = v[0] + dx[k];
                int moveY = v[1] + dy[k];

                if (moveX < 0 || moveY < 0 || moveX >= size || moveY >= size)
                    continue;
                if (visit[moveX][moveY])
                    continue;

                if (pic[moveX][moveY]==value){
                    visit[moveX][moveY] = true;
                    queue.offer(new int[]{moveX,moveY});
                }
            }
        }
    }
}
