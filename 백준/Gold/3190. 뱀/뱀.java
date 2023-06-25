import java.io.*;
import java.util.*;

public class Main {
    static int N,K,L,curDir=0,curTime=0,r=1,c=1;
    static int[][] map;
    static Queue<String[]> dirQ = new LinkedList<>();
    static List<int[]> snake = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine()); // map 행과 열 길이
        K = Integer.parseInt(br.readLine()); // 사과 갯수
        map = new int[N+1][N+1];

        // 사과 위치 저장
        for (int i = 0; i < K; i++) {
            String[] s = br.readLine().split(" ");
            int x = Integer.parseInt(s[0]); // 사과의 x좌표
            int y = Integer.parseInt(s[1]); // 사과의 y좌표
            map[x][y] = 1;
        }
        // 방향전환 큐
        L = Integer.parseInt(br.readLine()); // 방향전환 갯수
        for (int i = 0; i < L; i++) {
            String[] s = br.readLine().split(" ");
            String time = s[0]; // 전환할 시간
            String dir = s[1]; // 전환 방향
            dirQ.offer(new String[]{time,dir});
        }
        // 초기 위치(r,c)=(1,1), 방향 dir -> (0,1)
        snake.add(new int[]{1,1});
        dfs();

        bw.write(curTime+"");
        bw.flush();
        br.close();
    }

    static public void dfs(){ // 상하좌우에 있는지?
        // D방향 좌표이동 순서 : (1,0)(0,-1)(-1,0)(0,1)  +1씩
        // L방향 좌표이동 순서 : (0,1)(-1,0)(0,-1)(1,0) -1씩
        final int[] dx = {1,0,-1,0};
        final int[] dy= {0,1,0,-1};

        while(true){  // break에 걸릴때까지 계속
            curTime++; // 1초에 while문 한번
            // 다음 좌표로 이동
            r = r + dx[curDir];
            c = c+dy[curDir];

            // 종료조건 먼저 체크
            // 1. 뱀 머리가 이동한 곳이 벽인가    2. 뱀 머리가 이동한 곳이 뱀 몸인가
            if(r < 1 || c < 1 || r >= N + 1 || c >= N + 1) break;
            for (int i = 0; i < snake.size(); i++) {
                if (r==snake.get(i)[1] && c==snake.get(i)[0]) return;
            }

            // 사과 있는지 확인 & 뱀 위치 저장
            snake.add(new int[]{c,r});
            if (map[c][r] == 1) map[c][r] = 0; // 꼬리 그대로
            else  snake.remove(0); // 꼬리 제거

            // 방황 전환 시간되면 방향 전환
            if (!dirQ.isEmpty()) {
                int next = Integer.parseInt(dirQ.peek()[0]);
                if (curTime == next) {
                    String direct = dirQ.poll()[1];
                    if (direct.equals("D"))         curDir = (curDir + 1) % 4;
                    else if (direct.equals("L"))    curDir = (curDir + 3) % 4;
                }
            }
        }
    }
}
