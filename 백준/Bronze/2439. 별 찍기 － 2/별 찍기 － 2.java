

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int iLoof = sc.nextInt();
        for (int j = 1; j <= iLoof; j++) { // j = 몇 층

            for (int i = iLoof-j; i >= 1 ; i--) { // i = 공백 몇 개
                System.out.print(" ");
            }
            for (int k =0;k< j;k++) { // 층 수 만큼 별 찍기
                System.out.print("*");
            }
            System.out.print("\n");
        }
    }
}

