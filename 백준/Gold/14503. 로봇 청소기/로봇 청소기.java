
/*
* 1.현재 위치를 청소한 후,
* 2.왼쪽으로 돌면서 (최대 4번 체크)
* 3-1.한 곳이라도 청소하지 않은 곳이 있다면 -> 그 방향으로 한칸 이동
*       => (처음으로 돌아가서 현재위치 청소...)
* 3-2.한 바퀴를 다 돌아서 제자리되었는데도 (4번 체크) 청소할 곳을 못 찾았다면 -> 한칸 뒤로 이동
*       => (벽이면? 종료)
*       => (벽아니면? 1번으로 가서 다시 탐색) 그 상태에서 뒤로 후진.
* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int[][] map;
    static int N,M,r,c,nx,ny,d,dir;
    static int count=0;
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 입력 데이터
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]); // 행
        M = Integer.parseInt(s[1]); // 열
        map = new int[N][M];

        s = br.readLine().split(" ");
        r = Integer.parseInt(s[0]); // x
        c = Integer.parseInt(s[1]); // y
        dir = Integer.parseInt(s[2]); // 청소기의 방향 0:북 1:동 2:남 3:서

        for (int i = 0; i < N; i++) {
            s = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(s[j]);
            }
        }
        BFS();
        System.out.println(count);
    }

    public static void BFS(){
        final int[] dx = {-1,0,1,0};
        final int[] dy = {0,1,0,-1};

        Queue<int[]> queue = new LinkedList<>(); // 청소를 하러 이동해서 도착한 좌표들
        queue.offer(new int[]{r,c,dir}); // 탐색 시작위치와 방향

        map[r][c] = 2; // 청소했음을 표시
        count++;

        while (!queue.isEmpty()){
            int[] visit= queue.poll();
            int x = visit[0];
            int y = visit[1];
            int d = visit[2];
            int cnt = 0; // 상하좌우 중 몇곳을 확인했는지

            while(cnt<4) {// 4방향 확인
                int k = (d+3) % 4; // 현재 방향에서 90도 반시계회전
                nx = dx[k]+x;
                ny = dy[k]+y;

                // 빈칸이 있는 경우
                if (map[nx][ny]==0 ) { // 벽이나, 이미 청소된 곳이 아님
                    // 반시계 방향으로 90 회전한다.
                    queue.offer(new int[]{nx,ny,k});
                    map[nx][ny] = 2; // 청소했음을 표시
                    count++; // 청소했으니 카운트
                    break;
                }
                else {
                    d = k; // 현재 최신방향 업데이트
                }
                cnt++; // 상하좌우 카운트
            }

            // 4방향 다 확인했는데 청소할 곳이 없으면
            if (cnt == 4) { // break 안되고 cnt++ 4번된 경우
                // 현재 방향 그대로 한칸뒤로
                // 북(0)-> 2(1,0), 동(1)->3(0,-1),남(2)->0(-1,0) 서(3)->1(0,1)
                int curD = (d+2)%4;
                if (map[x+dx[curD]][y+dy[curD]] == 1) // 벽이면
                    break;
                else
                    queue.offer(new int[]{x+dx[curD],y+dy[curD],d});
            }
        }
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
