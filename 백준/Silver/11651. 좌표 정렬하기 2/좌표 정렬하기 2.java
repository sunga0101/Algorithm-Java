import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        Integer[][] arr = new Integer[N][2];
        String[] s;

        for (int i=0;i<N;i++){
            s= br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(s[0]);
            arr[i][1] = Integer.parseInt(s[1]);
        }

        Arrays.sort(arr, new Comparator<Integer[]>(){
            @Override
            public int compare(Integer[] o1, Integer[] o2){
                if (o1[1].equals(o2[1]))
                    return o1[0]-o2[0];

                else return o1[1]-o2[1];
            }
        });

        for (int i=0;i<N;i++){
            bw.write(arr[i][0]+" "+arr[i][1]+"\n");
        }

        bw.flush();
        br.close();

    }
}
