
import java.util.Scanner;

public class Main {
    static int white = 0;
    static int blue = 0;
    static int res[] = new int[2];
    static int[][] paper;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        paper = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                paper[i][j] = sc.nextInt();
        divide(n, 0, 0);
        System.out.println(res[0]);
        System.out.println(res[1]);
    }

    public static void divide(int n, int x, int y){
        // (n,n)에서 +x, +y 만큼 분할한 사분면 비교
        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++)
                if (paper[i][j] != paper[x][y]) {
                    divide(n / 2, x, y);
                    divide(n / 2, x + n / 2, y);
                    divide(n / 2, x, y + n / 2);
                    divide(n / 2, x + n / 2, y + n / 2);
                    return;
                }
        }
        res[paper[x][y]]++; // 배열로 카운트
    }
}
