

import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int i=0;i<T;i++){
            String res = "YES";
            String s = br.readLine();
            int len = s.length();

            Stack<Integer> st = new Stack<>();
            for (int j=0;j<len;j++){
                if (s.charAt(j) == '(')
                    st.push(1);
                else {
                    if (!st.isEmpty())
                        st.pop();
                    else {
                        res = "NO";
                        break;
                    }
                }
            }
            if (!st.isEmpty()) res = "NO";
            bw.write(res+"\n");

        }

        bw.flush();
        br.close();

    }
}
