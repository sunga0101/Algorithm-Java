
import java.io.*;
import java.util.Scanner;

public class Main {

    private static int calculateYS(int time) {
        int sum = 0;
        sum = (time / 30) * 10 + 10;
        return sum;
    }

    private static int calculateMS(int time) {
        int sum = 0;
        sum = (time / 60) * 15 + 15;
        return sum;
    }


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int iCnt = sc.nextInt();
        int sumYS=0; // 영식
        int sumMS=0; // 민식
        int time;

        for (int i = 0; i < iCnt; i++) {
            time = sc.nextInt();
            sumMS+= calculateMS(time);
            sumYS+= calculateYS(time);
        }
        if ( sumYS == sumMS ) {
            System.out.printf("Y M %d", sumMS);
        } else if (sumYS > sumMS) {
            System.out.printf("M %d", sumMS);
        } else {
            System.out.printf("Y %d", sumYS);
        }
    }
}