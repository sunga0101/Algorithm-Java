import java.io.*;
import java.util.Arrays;
import java.util.Scanner;



public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int cnt = 0;
        int temp;

        int[] card = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};

        for (int j = 0; j < 10; j++) {
            int iStart = sc.nextInt();
            int iEnd = sc.nextInt();
            cnt = 0;
            // Reverse
            for (int k = iStart; cnt < (iEnd-iStart+1)/2 ; cnt++) {
                temp = card[k+cnt];
                card[k+cnt] = card[iEnd-cnt];
                card[iEnd-cnt] = temp;
            }
            //System.out.println("j: "+j);
            //System.out.println(Arrays.toString(card));
        }

        for (int i=1; i<=20; i++){
            System.out.printf("%d ",card[i]);
        }
    }
}

