

import java.io.*;
import java.util.*;
import java.math.*;
public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());
        int f = Integer.parseInt(br.readLine());
        String s = String.valueOf(n);

        
            s = s.substring(0, s.length()-2); // 맨 뒤 두자리 제거
            int updateN = Integer.parseInt(s) * 100;
            for (int i=0;i<100;i++){
                if (updateN%f==0){
                    String str = String.valueOf(updateN);
                    bw.write(str.substring(str.length()-2,str.length())+"");
                    break;
                }
                else updateN++;
            }

        
        bw.flush();
        br.close();
    }
}