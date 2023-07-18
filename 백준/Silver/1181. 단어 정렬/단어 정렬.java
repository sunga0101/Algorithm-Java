
import java.io.*;
import java.util.*;

public class Main {
    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        ArrayList<List<String>> list = new ArrayList<>();
        for (int i = 0; i <= 50; i++) { // 0~50
            list.add(new ArrayList<>()); // 각 길이별로 단어 추가할 1~50길이 크기의 리스트
        }

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            int len = word.length();
            if (!list.get(len).contains(word)) // 중복 제거
                list.get(len).add(word);
        }

        for (List<String> str : list){
            Collections.sort(str);
            for (String s :str)
                bw.write(s+"\n");
        }
        bw.flush();
        br.close();
    }

    public static void main(String[] args) throws IOException {
        solve();
    }
}
