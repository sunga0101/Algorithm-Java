
import java.io.*;
import java.util.Scanner;

/* 7개의 자연수, 홀수만 필터링해서 1.최소값 구하고 2. 모두 더하기.
                            3. 홀수가 없으면 -1 출력하기
* */
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int iVal;
        int oddSum = 0;
        int oddMin = Integer.MAX_VALUE;
        for (int i = 0; i < 7; i++) {
            iVal = sc.nextInt();
            if (iVal % 2 != 0) { // isOdd
                oddSum += iVal;
                if (iVal < oddMin) {
                    oddMin = iVal;
                }
            }
        }
        if (oddSum == 0) { // 홀수가 없었을 때
            System.out.println(-1);
        }
        else {
            System.out.printf("%d\n%d",oddSum,oddMin);
        }
    }
}

