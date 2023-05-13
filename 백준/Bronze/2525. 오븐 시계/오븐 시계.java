
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken()); //hours
        int m = Integer.parseInt(st.nextToken()); //minutes
        int iInput = Integer.parseInt(br.readLine());

        h += iInput/60;
        m +=iInput%60;

        if (m >= 60) {
            h += m / 60;
            m %= 60;
        }
        if (h >=24) {
            h %= 24;
        }
        System.out.printf("%d %d",h,m);
    }
}
