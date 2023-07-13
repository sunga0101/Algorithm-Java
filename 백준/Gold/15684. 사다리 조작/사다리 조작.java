
import java.io.*;

public class Main {
    static int N,M,H;
    static int[][] ladder;
    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        H = Integer.parseInt(s[2]);
        ladder = new int[H+1][N+1];
        if (M == 0) { // 가로선 없는 경우 모두 직선
            System.out.println(0);
            System.exit(0);
        }
        for (int i = 0; i < M; i++) {
            s = br.readLine().split(" ");
            int x = Integer.parseInt(s[0]);
            int y = Integer.parseInt(s[1]);
            ladder[x][y]=1; // 사다리 가로선 추가 (오른쪽으로 이동해야 함)
            ladder[x][y+1]=-1; // 사다리 가로선 추가 (왼쪽으로 이동해야 함)
        }

        // 가로 사다리가 3개보다 크면 -1
        // 1,2,3개까지는 정상출력
        makeLine(0,0);
        makeLine(0,1);
        makeLine(0,2);
        makeLine(0,3);

        System.out.println(-1);
    }

    public static void makeLine(int count, int k){
        if (count == k){
            // ladder 체크해서
            // 만약 모두 자기 번호로 돌아가면
                if (check()){
                    System.out.println(k);
                    System.exit(0);
                }
            // 불가능하다면
               return;
        }

        for (int i = 1; i <= H; i++) {
            for (int j = 1; j < N; j++) {
                if(ladder[i][j] != 0 || ladder[i][j+1] > 0) continue;
                // 인접한 가로선 있으면 안됨
                ladder[i][j]=1; // 오른쪽으로 이동하는 가로선
                ladder[i][j+1]=-1; // 왼쪽으로 이동하는 가로선
                makeLine(count+1,k);
                // 원상복귀
                ladder[i][j]=0;
                ladder[i][j+1]=0;
            }
        }
    }

    public static boolean check(){
        boolean status = true; // 조건 만족하는 사다리
        for (int i = 1; i <= N; i++) { // 1~N의 세로 사다리
            int nx = 1;
            int ny = i;

            while (nx < H+1){
                if (ladder[nx][ny] > 0) // 오른쪽 이동
                    ny += 1;
                else if (ladder[nx][ny] < 0) // 왼쪽 이동
                    ny -= 1;

                // 한칸 아래로 이동
                nx += 1;
            }
            // 끝까지 내려왔을 때 몇 라인인지 체크
            if (i != ny)
            {
                status = false;
                break; // 하나라도 false면 더이상 체크 안해도 됨
            }
        }
        return status;
    }

    public static void main(String[] args) throws IOException {
        solve();
    }
}
