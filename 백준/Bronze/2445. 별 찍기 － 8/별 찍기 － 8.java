
import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for (int i = 0; i < N-1; i++) {
            for (int j = 0; j < i+1; j++) {
                System.out.print("*");
            }
            for (int k = 2 * N - 2 - 2 * i; k > 0; k--) {
                System.out.print(" ");
            }
            for (int l= 0; l < i+1; l++) {
                System.out.print("*");
            }
            System.out.print("\n");
        }
        for (int i = 1; i <= N; i++) {
            for (int j = N  - i; j >= 0; j--) {
                System.out.print("*");
            }
            for (int k = 0; k < 2 * i - 2; k++) {
                System.out.print(" ");
            }
            for (int l= N-i; l >=0; l--) {
                System.out.print("*");
            }
            System.out.print("\n");
        }
    }
}