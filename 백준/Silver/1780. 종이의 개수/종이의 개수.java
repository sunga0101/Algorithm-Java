
import java.util.Scanner;

public class Main {
    static int res[] = new int[3]; // 0,1,-1(res[2]로)
    static int[][] paper;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        paper = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++){
                paper[i][j] = sc.nextInt();
                if (paper[i][j] == -1) paper[i][j]= 2;
            }
        divide(n, 0, 0);
        // -1값들을 2로 바꿔서
        System.out.println(res[2]);
        System.out.println(res[0]);
        System.out.println(res[1]);
    }

    public static void divide(int n, int x, int y){
        // (n,n)에서 +x, +y 만큼 분할한 사분면 비교
        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++)
                if (paper[i][j] != paper[x][y]) {
                    divide(n / 3, x, y); // x,y
                    divide(n / 3, x + n / 3, y); // 1/3x,y
                    divide(n / 3, x + (2 * n / 3), y); // 2/3x,y
                    divide(n / 3, x, y + n / 3); // x,1/3y
                    divide(n / 3, x, y + (2 * n / 3)); // x,2/3y
                    divide(n / 3, x + n / 3, y + n / 3); // 1/3x,1/3y
                    divide(n / 3, x + (2 * n / 3), y + (2 * n / 3)); // 2/3x,2/3y
                    divide(n / 3, x + n / 3, y + (2 * n / 3)); // 1/3x,2/3y
                    divide(n / 3, x + (2 * n / 3), y + n / 3); // 2/3x,1/3y
                    return;
                }
        }
        res[paper[x][y]]++; // 배열로 카운트
    }
}
