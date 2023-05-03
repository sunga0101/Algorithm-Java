
import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int iLoof = sc.nextInt();
        for (int j = 0; j < iLoof; j++) { // j = 몇 층
            for (int i = 0; i <j ; i++) { // 층 수-1 만큼 공백 찍기
                System.out.print(" ");
            }
            for (int k = iLoof-j; k > 0; k--) {
                System.out.print("*");
            }
            System.out.print("\n");
        }
    }
}