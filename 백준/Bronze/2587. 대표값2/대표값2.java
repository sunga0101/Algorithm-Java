
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int[] iArr = new int[5];
        for (int i = 0; i < 5; i++) {
            iArr[i] = sc.nextInt();
        }

        Arrays.sort(iArr);
        System.out.println(Arrays.stream(iArr).sum()/5); // 평균 자연수값
        System.out.println(iArr[2]); // 정렬 후 중앙값

    }
}
