
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
        func(0); // 맨처음 -> 0개니까
    }

    public static void func(int k){ // 현재 k개까지 수를 정했을 때 arr[k]를 정하는 함수
        if(k==m){ // m개 모두 택했으면 종료
            for (int i = 0; i < m; i++) {
                System.out.print(arr[i]+" ");
            }
            System.out.println();
        }
        for (int i = 1; i <= n; i++) {
            if(!isused[i]){ // arr[k]를 정한 후에 체크하고, func(k+1) 호출
                arr[k]=i;
                isused[i]=true;
                func(k+1);
                isused[i]=false; // 원상 복구
            }
        }
    }
}


