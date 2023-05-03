
import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int iLoof = sc.nextInt();
        for (int j = 0; j < iLoof; j++) { // j = 몇 층
            for (int i = iLoof-j; i >= 1 ; i--) { // reverse 층 수 만큼 별 찍기
                System.out.print("*");
            }
            System.out.print("\n");
        }
    }
}

