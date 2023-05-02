import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int iLen = sc.nextInt();
        int iVal = sc.nextInt();
        int res;
        for (int i = 0; i < iLen; i++) {
            res = sc.nextInt();
            if (res < iVal) {
                System.out.printf("%d ", res);
            }

        }

    }
}
