

import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String number = br.readLine();
        Stack<Integer> st = new Stack<>();
        int zeroCnt=0;
        int oneCnt=0;

        st.push(number.charAt(0)-'0');

        if (number.charAt(0)-'0'==0)
            zeroCnt++;
        else oneCnt++;

        for (int i=1;i<number.length();i++){
            if (!st.isEmpty()){
                int peek = st.peek();
                int val = number.charAt(i)-'0';
                if (peek != val){
                    st.push(val);
                    if (val==0)
                        zeroCnt++;
                    else oneCnt++;
                }
            }
        }
        bw.write(Math.min(zeroCnt,oneCnt)+"");
        bw.flush();
        br.close();
    }

}
