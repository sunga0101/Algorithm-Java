

import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String s = br.readLine();
        Stack<Character> st = new Stack<>();
        int result = 0;
        for (int i=0;i<s.length();i++){
            if (s.charAt(i) == '('){
                st.push('(');
            }
            else if (s.charAt(i) == ')'){
                if (s.charAt(i-1) == '(') {// 레이저인 경우
                    st.pop();
                    result += st.size();
                }
                else if (s.charAt(i-1) != '(') { // 막대가 끝나는 경우
                    result += 1;
                    st.pop();
                }
            }
        }
        bw.write(result+"");
        bw.flush();
        br.close();

    }
}
