import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int sumXY,sum;
        int[] dist = new int[3];
        do  {
            String[] s = br.readLine().split(" ");
            dist[0]=Integer.parseInt(s[0]);
            dist[1]=Integer.parseInt(s[1]);
            dist[2]=Integer.parseInt(s[2]);
            sum=dist[0]+dist[1]+dist[2];

            Arrays.sort(dist);
            sumXY=(dist[0]*dist[0])+(dist[1]*dist[1]);
            if (sumXY != 0){
            if (dist[2]*dist[2]==sumXY) sb.append("right\n");
            else sb.append("wrong\n");}
        } while (sum != 0);
        System.out.println(sb);
    }
}