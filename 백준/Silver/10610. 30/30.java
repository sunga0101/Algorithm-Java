

import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String[] s = br.readLine().split("");
        int len = s.length;
        long sum = 0;
        String result="";
        int[] arr = new int[len];

        for (int i=0;i<len;i++){
            arr[i] = Integer.parseInt(s[i]);
            sum+=arr[i];
        }
        Arrays.sort(arr);
        if (arr[0]!=0) result = "-1";
        else if (sum%3!=0) result = "-1";
        else {
            for (int i=len-1;i>=0;i--){
                result+=arr[i];
            }
        }



        bw.write(result);
        bw.flush();
        br.close();
    }

}
