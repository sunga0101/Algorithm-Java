
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] dis = new int[4];
        int res = Integer.MAX_VALUE;
        int x=sc.nextInt();
        int y=sc.nextInt();
        int w=sc.nextInt();
        int h=sc.nextInt();

        dis[0] = w-x;
        dis[1] = h-y;
        dis[2] = x;
        dis[3] = y;

        for (int i = 0; i < 4; i++) {
            if (res>dis[i]){
                res=dis[i];
            }
        }
        System.out.println(res);
    }
}