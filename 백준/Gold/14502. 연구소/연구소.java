/*
1. 어디에 벽을 세울 것인가?
2. 벽의 개수가 3개인 모든 경우 체크
3. 벽 3개 맵에서 바이러스 모두 퍼뜨리기
4. 다 퍼진 맵에서 안전 공간 최대인 경우 찾기
* */
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

import static java.lang.Math.max;

public class Main {
    static int[][] map;
    static int N,M,count=0;
    static int maxCount=Integer.MIN_VALUE;
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력 데이터
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]); // 세로
        M = Integer.parseInt(s[1]); // 가로
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            s= br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(s[j]);
            }
        }

        checkWall(0);
        bw.write(maxCount+"");
        bw.flush();
        br.close();
    }

    public static void checkWall(int k){ // 벽이 3개인 모든 경우를 체크
        //base case
        if (k==3){
            BFS();// 벽이 세개라면 그 맵으로 BFS
            return;
        }

        // 맵 돌면서 백트래킹
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j]==0) {
                    map[i][j] = 1;
                    checkWall(k+1);
                    map[i][j] = 0;
                }
            }
        }
    }

    // 최대 빈킨 갯수 찾기
    private static void BFS() {
        final int[] dx = {0,0,-1,1};
        final int[] dy = {1,-1,0,0};
        Queue<int[]> queue = new LinkedList<>();

        int[][] copiedMap = new int[N][M]; // copy한 맵을 bfs에 사용
        copy(map, copiedMap); // 현재 벽 3개 추가된 맵을 복사

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (copiedMap[i][j]==2) { // 바이러스라면
                    queue.offer(new int[]{i,j});
                }
            }
        }

        while (!queue.isEmpty()){
            int[] visitPos = queue.poll();
            for (int k = 0; k < 4; k++) {
                int nx = dx[k]+visitPos[0];
                int ny = dy[k]+visitPos[1];

                if (nx<0 || ny<0 || nx>= N || ny>= M) continue;
                if (copiedMap[nx][ny]!=0) continue;

                // 0인 경우만
                queue.offer(new int[]{nx,ny});
                copiedMap[nx][ny]=2;
            }
        }

        count = 0; // 매번 초기화
        // 0인 영역 카운트
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (copiedMap[i][j]==0) { // 바이러스라면
                    count++;
                }
            }
        }
        maxCount = max(maxCount,count);
    }


    private static void copy(int[][] map, int[][] copiedMap){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                copiedMap[i][j] = map[i][j];
            }
        }
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
