/*
*  TODO
*   1. 3차원 배열 만들기
*       1-1. 판 순서 정하기 5!가지 경우: 백트래킹
*       1-2. 판 90도 회전 4가지 경우: 백트래킹
*   2. 출입구가 1인지 확인
*       2-1. 출입구가 1일 때만 탐색
*   3. BFS 탐색 - 갈 수 있는 곳은 6개 (기존 동일 4곳 + 윗판/아랫판)
*
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int[][][] map;
    static int[][][] currentMap;
    static int N=5, M=5;
    static boolean[] isused = new boolean[5];
    static int[] order = new int[5]; // 순서 배열
    static int[] direct = new int[5]; // 방향 배열
    static boolean[][][] visited;
    static int minimun = Integer.MAX_VALUE;
    static class POS {
        int z,x,y,cnt;
        public POS(int x,int y,int z, int cnt){
            this.x = x;
            this.y = y;
            this.z = z;
            this.cnt = cnt;
        }
    }

    public static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] s;
        // 초기 3차원 맵 설정
        map = new int[5][5][5];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                s = br.readLine().split(" ");
                for (int k = 0; k < 5; k++) {
                    map[i][j][k] = Integer.parseInt(s[k]);
                }
            }
        }
        mapOrder(0);
        if (minimun == Integer.MAX_VALUE) sb.append(-1); // 입출구 조건 아닐때
        else sb.append(minimun);
        System.out.println(sb);
    }

    // [][] 배열의 순서 경우의수 (120번)
    public static void mapOrder(int k){
        // base condition
        if (k==5){ // 5번째 판까지 체크 완료
            currentMap = new int[5][5][5];
            for (int i = 0; i < order.length; i++) {
                // 각 층마다 rotate 경우의 수 체크
                mapRotate(0);
            }
            return;
        }
        for (int i = 0; i < N; i++) {
            if (!isused[i]){
                isused[i]=true;
                order[k] = i;
                mapOrder(k+1);
                isused[i]=false;
            }
        }
    }

    // [][] 배열의 회전 경우의수(중복 가능) 4^5번 1024번
    public static void mapRotate(int k){
        // base condition
        if (k==5){ // 4가지 방향 확인 완료
            for (int i = 0; i < order.length; i++) {
                int floor = order[i];
                int NfloorDir = direct[floor]; //  N번째 층의 방향 (0,1,2,3)
                rotate(i,floor,NfloorDir); // 회전
            }
            // currentMap에 현재 경우의 미로 담겨있음
            if(currentMap[0][0][0] == 1 && currentMap[4][4][4]==1) // 출입구 조건
                BFS();
            return;
        }
        for (int i = 0; i < 4; i++) {
                direct[k] = i;
                mapRotate(k+1);
        }
    }

    // 최소 경우 카운트
    public static void BFS(){
        // 6가지 탐색방향 (동서남북위아래)
        final int[] dz = {0, 0, 0, 0,-1, 1}; // 위 아래
        final int[] dx = {-1,1, 0, 0, 0, 0}; // 동 서
        final int[] dy = {0, 0,-1, 1, 0, 0}; // 남 북
        visited = new boolean[5][5][5];

        Queue<POS> queue = new LinkedList<POS>();
        queue.offer(new POS(0,0,0,0)); // 시작위치? 입구 [0][0][0]
        visited[0][0][0] = true;

        while (!queue.isEmpty()){
            POS pos = queue.poll();
            int posX = pos.x;
            int posY = pos.y;
            int posZ = pos.z;

            // 출구일때
            if(posX == 4 && posY == 4 && posZ == 4) {
                if (minimun > pos.cnt) minimun = pos.cnt;
                if (minimun == 12) { // 최단거리이므로 더이상 탐색 안하고 종료
                    System.out.println(12);
                    System.exit(0);
                }
                break;
            }
            for (int k = 0; k < 6 ; k++) {
                int moveX = dx[k] + posX;
                int moveY = dy[k] + posY;
                int moveZ = dz[k] + posZ;
                if(moveX < 0 || moveY < 0 || moveZ < 0 ||
                        moveX >= 5 || moveY >= 5|| moveZ >= 5 )
                    continue;
                if (visited[moveZ][moveX][moveY]) continue;
                if (currentMap[moveZ][moveX][moveY]==0) continue;

                // 그렇지 않으면
                queue.offer(new POS(moveX,moveY,moveZ,pos.cnt+1));
                visited[moveZ][moveX][moveY] = true;
            }
        }
    }

    public static void rotate(int i, int floor, int NfloorDir) {
        for (int r = 0; r < 5; r++) {
            for (int c = 0; c < 5; c++) {
                if (NfloorDir == 0) { // 0
                    currentMap[i][r][c] = map[floor][r][c];
                }
                if (NfloorDir == 1) { // 90
                    currentMap[i][c][4 - r] = map[floor][r][c];
                }
                if (NfloorDir == 2) { // 180
                    currentMap[i][4 - r][4 - c] = map[floor][r][c];
                }
                if (NfloorDir == 3) { // 270
                    currentMap[i][4 - c][r] = map[floor][r][c];
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        solve();
    }
}
