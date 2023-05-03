import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] iArr = new int[3];
        for (int i = 0; i < 3; i++) {
            iArr[i] = sc.nextInt();
        }
        Arrays.sort(iArr); // 오름차순 정렬
        System.out.printf("%d %d %d",iArr[0],iArr[1],iArr[2] );
    }
}
