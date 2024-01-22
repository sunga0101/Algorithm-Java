

import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        String input = "";
        while((input = br.readLine()) != null) {
            int[] arr = new int[4];
            for (int i=0;i<input.length();i++){
                if (input.charAt(i) == ' ') arr[3]+=1;
                else if (input.charAt(i)>='a' && input.charAt(i)<='z') arr[0]+=1;
                else if (input.charAt(i)>='A' && input.charAt(i)<='Z') arr[1]+=1;
                else arr[2]+=1;
            }
            for (int i:arr){
                System.out.print(i+" ");
            }
            System.out.println();
        }

    }
}
