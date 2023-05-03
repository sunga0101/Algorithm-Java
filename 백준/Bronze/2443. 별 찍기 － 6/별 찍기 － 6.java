
import java.io.*;
import java.util.Scanner;



public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        for (int i = 0; i<N; i++) {
            for (int j = 0; j <i; j++) {
                System.out.print(" ");
            }
            
            for ( int k = 2*N-1-2*i; k>0 ;k-- ) {
                System.out.print("*");
            }
            
            System.out.print("\n");
            }
        }

    }