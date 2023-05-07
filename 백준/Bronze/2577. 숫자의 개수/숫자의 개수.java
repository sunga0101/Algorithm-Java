
import java.util.Scanner;

public class Main {
    // max = 1000 000 000
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] iNum = new int[10]; // 0~9
        int extra = 0;
        int res = sc.nextInt() * sc.nextInt() * sc.nextInt();

        while (res > 0) {
            extra = res % 10 ;
            res = res / 10;
            iNum[extra]+=1;
        }
        for (int i : iNum) {
            System.out.println(i);
        }
    }
}
