
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] code = new int[4];
        int cnt = 0;
        for (int j = 0; j < 3; j++) {
            cnt = 0;
            for (int i = 0; i < 4; i++) {
                code[i] = sc.nextInt(); // 한 윷짝당 한 라인

                if (code[i] == 1) {
                    cnt++;
                }
            }
            if (cnt == 0) {
                System.out.println("D");
            } else if (cnt == 1) {
                System.out.println("C");
            } else if (cnt == 2) {
                System.out.println("B");
            } else if (cnt == 3) {
                System.out.println("A");
            } else if (cnt == 4) {
                System.out.println("E");
            }
        }
    }
}
