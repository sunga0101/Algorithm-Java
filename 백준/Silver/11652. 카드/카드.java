

import java.io.*;
import java.util.*;
public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int max = Integer.MIN_VALUE;
        Long maxKey = Long.MIN_VALUE;

        HashMap<Long,Integer> map = new HashMap<Long,Integer>(); // key: 카드숫자 value : 카드 빈도
        for (int i=0;i<N;i++){
            long k = Long.parseLong(br.readLine());
            map.put(k,map.getOrDefault(k,0)+1);

            if (max < map.get(k)) {
                max = map.get(k);
                maxKey = k;
            }
            else if (max == map.get(k)){
                maxKey = Math.min(maxKey, k);
            }

        }

        bw.write(maxKey+"\n");
        bw.flush();
        br.close();

    }
}
