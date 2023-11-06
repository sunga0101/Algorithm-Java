

import java.io.*;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static String[] solution(String[] str){
        Arrays.sort(str, Collections.reverseOrder());
        return str;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = br.readLine().split("");
        str = solution(str);
        String result = "";
        for (String s: str) {
            result+=s;
        }
        bw.write(result);
        bw.flush();
        br.close();
    }
}
