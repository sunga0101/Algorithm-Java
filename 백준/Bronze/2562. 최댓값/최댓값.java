
import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int[] iArr = new int[9];
        int max = -1;
        int idx = -1;

        for (int i = 0; i < 9; i++) {
            iArr[i]=sc.nextInt();
            if (iArr[i] > max) {
                max = iArr[i];
                idx = i;
            }
        }
        System.out.printf("%d\n%d",max,idx+1);

    }
}

