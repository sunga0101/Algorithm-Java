
import java.io.*;
import java.util.StringTokenizer;

import static java.lang.Math.max;
import static java.lang.Math.min;

// 1. 끄트머리에서 가다보면 나오는 shape -> 1,2,3,4 (dfs)
// 2. T-shape는 예외 -> 사방탐색 중 3개 성공? 본인 포함 4개 의 합
//                             4개 성공? 4개 중 최솟값 제거
public class Main {
    static int N,M,sum=0,cnt;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static int[][] board;
    static boolean[][] visited;

    static final int[] dx = {0,0,1,-1};
    static final int[] dy = {1,-1,0,0};

    public static void main(String[] args) throws IOException {
        solve();
    }

    public static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];

        // board 생성
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // shape -> 1,2,3,4,5의 경우
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                cnt = 0; // 변수 초기화
                sum = board[i][j];

                visited[i][j]=true; // shape 1,2,3,4 경우
                dfs(i,j,cnt+1,sum); // x,y좌표, 현재 몇번째 블럭 카운트인지,현재까지의 합
                visited[i][j] = false;
                
                checkTShape(i,j,cnt+1); // shape 5 경우
                /*          @
                *          @$@  -> $가 현재 board[i][j]
                *           @                        */
            }
        }
        bw.write(max+"");
        bw.flush();
        br.close();
    }

    private static void dfs(int x, int y, int cnt, int sum) {
        // 종료 조건
        if (cnt == 4){
            max = max(sum,max);
            return;
        }

        // 상하좌우 완전탐색
        for (int k = 0; k < 4; k++) {
            int nx = x+dx[k];
            int ny = y+dy[k];

            if (nx<0 || ny<0 || nx>=N || ny >=M) continue;
            if (!visited[nx][ny]){
                visited[nx][ny] = true;
                dfs(nx,ny,cnt+1,sum+board[nx][ny]);
                // 한쪽 방향 탐색 끝나고 나오면
                visited[nx][ny] = false; // 다음 탐색에 영향 없도록
            }
        }
    }

    private static void checkTShape(int i, int j, int cnt) { // ㅜ,ㅓ,ㅗ,ㅏ
        min = Integer.MAX_VALUE; // 초기화
        for (int k = 0; k < 4; k++) {
            int nx = i+dx[k];
            int ny = j+dy[k];
            if (nx<0 || ny<0 || nx>=N || ny >=M) continue;

            // [nx][ny]가 board 안에 있으면
            cnt++; // 카운트
            sum += board[nx][ny];
            min=min(min,board[nx][ny]); // cnt=4일 때 뺄 최소값 블럭
        }
        if (cnt == 5) sum -= min; // 상하좌우 모두 유효할 때
        else if (cnt < 4) return;

        max = max(sum,max);
    }
}
