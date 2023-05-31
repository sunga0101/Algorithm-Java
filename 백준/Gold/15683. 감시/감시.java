/*
 * 1. 알고 싶은 것 -> #의 개수
 * 2. 모든 경우의수의 #의 개수 알기
 * 3. 각 cctv 경우를 만들어야
 *   - 1. 백트래킹 이용..?
 *       - 1. 경우 만들고 배열에 #넣고 카운트
 *   - 2. 각 타입별로 경우의 수 다름
 *       - 재귀를 어디서 호출해야..
 * */
import java.io.*;
import java.util.ArrayList;

public class Main {

    public static int N,M,count;
    public static int min = Integer.MAX_VALUE;
    public static int[][] board;
    public static int[] tvCntArr = new int[7]; // 각 cctv 개수 배열 (1~5번 각 cctv)
    public static ArrayList<CCTV> cctvList = new ArrayList<CCTV>();
    static class CCTV{
        int x, y, tvType;
        public CCTV(int x, int y) {
            this.x = x; // x좌표
            this.y = y; // y좌표
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public void setTvType(int tvType) {
            this.tvType = tvType;
        }

        public int getTvType() {
            return tvType;
        }
    }

    public static void main(String[] args) throws IOException {
        CCTV cctv;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]); // 세로
        M = Integer.parseInt(s[1]); // 가로
        board = new int[N][M];
        for (int i = 0; i < N; i++) {
            s = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                int tv = Integer.parseInt(s[j]);
                board[i][j] = tv;
                if (tv >= 1 && tv < 6 ) {
                    cctv = new CCTV(i,j); // 객체 좌표
                    cctv.setTvType(tv-1); // 객체 tv타입 (1타입을 0으로, 2타입을 1로,,,)
                    cctvList.add(cctv);
                    tvCntArr[tv] += 1; // 각 cctv, 벽 개수 +1
                }
            }
        }    // ------ 입력받고 객체 생성까지

        func(0); // 0번 객체부터
        bw.write(min+"");
        bw.flush();
        br.close();
    }


    public static void func(int k){
        int tmpBoard[][] = new int[N][M];
        int n = cctvList.size(); // cctv 총 개수

        // base condition
        if (k==n){ // 모두 확인했으면
            count = 0;
            // 1~6번타입 모두 다 본 후 보드 돌면서
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if(board[i][j]==0) // 보드판이 -1인 경우 -> CCTV 체크
                        count++;  // 보드판이 0인 경우 -> 사각지대
                }
            }
            if (count < min) min = count;
            return;
        }

        // 재귀 호출 전에 이전 cctv의 맵을 그리고 호출해야..
        // 타입에 따라 ->  반복 개수 for i-> 타입 (1-> 4번,  2-> 2번,...)
        CCTV tv = cctvList.get(k);
        int tvType = tv.getTvType();

        final int[] direction = {4,2,4,4,1};
        for (int i = 0; i < direction[tvType]; i++) {
            initBoard(tmpBoard, board); // cntrl+C

            // 유형별 체크
            if (tv.getTvType()== 0){ // 1유형 cctv (1방향 체크)
                paint(tv,i); // case 1 이거나 2 이거나 3 이거나 0
            }
            else if (tv.getTvType()== 1){ // 2유형 cctv (2방향 체크)
                paint(tv,i); // case 0,2(좌우) 이거나 case 1,3(위아래)
                paint(tv,i+2);
            }
            else if (tv.getTvType()== 2){ // 3유형 cctv (2방향 체크)
                paint(tv,i); // case 0,1(위오른) 이거나 case 1,2(오른아래) 이거나 case 2,3(아래왼) 이거나 case 3,0(왼위)
                paint(tv,i+1); // 3,4의 경우는 4-> 0이 되도록 mod
            }
            else if (tv.getTvType()== 3){ // 4유형 cctv (3방향 체크)
                paint(tv,i); // case 0,1,2(왼쪽 제외) 이거나 case 0,1,3(아래 제외) 이거나 case 0,2,3(오른쪽 제외) 이거나 case 1,2,3(위 제외)
                paint(tv,i+2);
                paint(tv,i+3);
            }
            else {         // 5유형 (4방향 체크)
                paint(tv,i);// case 0,1,2,3
                paint(tv,i+1);
                paint(tv,i+2);
                paint(tv,i+3);
            }
            func(k+1); // 다음 cctv 객체로
            //board 체크했으니 초기화
            initBoard(board, tmpBoard); // cntrl+v
        }
    }

    public static void paint(CCTV cctv, int direct){ // i는 객체 , direct는 cctv 방향 0,1,2,3 중에 하나
        int tp = cctv.getTvType(); // 타입 사용안함..
        int x = cctv.getX();
        int y = cctv.getY();
        direct %= 4;

        switch (direct){
            case 0: // 위쪽 방향
                for (int i = x-1; i>=0 ; i--) { // y축 : i-1부터 0까지
                    if(board[i][y] == 6)
                        break;
                    board[i][y] = -1;
                }
                break;
            case 1: // 오른쪽 방향
                for (int i = y+1; i<M ; i++) { // x축 : i+1부터 M까지
                    if(board[x][i] == 6)
                        break;
                    board[x][i] = -1;
                }
                break;
            case 2: // 아래쪽 방향
                for (int i = x+1; i<N ; i++) { // y축 : i+1부터 N까지
                    if(board[i][y] == 6)
                        break;
                    board[i][y] = -1;
                }
                break;
            case 3:// 왼쪽 방향
                for (int i = y-1; i >= 0 ; i--) { // x축 : i-1부터 0까지
                    if(board[x][i] == 6)
                        break;
                    board[x][i] = -1;
                }
                break;
        }
    }

    static void initBoard(int[][] a, int[][] b){ // initBoard(a,b) b 데이터 -> a로 cntrl c 후,
        // initBoard(b,a) a 데이터 -> b로 cntrl v 하는 것
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                a[i][j] = b[i][j];
            }
        }
    }
}
