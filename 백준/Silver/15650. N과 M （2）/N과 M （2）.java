
import java.util.Scanner;

public class Main {
    static boolean[] isused = new boolean[10]; // 특정 수가 쓰였는지 체크
    static int[] arr = new int[10]; // 수열 담을 배열
    static int m;
    static int n;

    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // 1부터 n까지의 수
        m = sc.nextInt(); // m개의 수
        func(0,0); // 맨처음 -> 0개니까
    }

    public static void func(int index, int k){
        // base condition
        if (k == m) { // m개가 되면 출력
            for (int i = 0; i < m; i++) {
                System.out.print(arr[i]+" ");
            }
            System.out.println();
        }

        for (int i = index + 1; i <= n; i++) { // 조건 : index ~ n까지 수 중에서 수열
            if (!isused[i]){
                arr[k]=i;
                isused[i] = true;
                func(i,k+1);
                isused[i] = false;
            }
        }
    }
}