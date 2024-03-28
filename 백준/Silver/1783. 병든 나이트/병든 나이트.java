

import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]); // y
        int m = Integer.parseInt(s[1]); // x
        int x=0;
        int y=0;
        int cnt = 0;
//        System.out.println("x:"+x+", y:"+y);

        // 4번 이상 가능한지 체크
        if (n<3 || m<7){ // 4번 미만
//            System.out.println("4번 안됨");
            while (x<=m && y<=n && cnt<3){
                if (x+1<m && y+2<n && cnt<3){ // 1번
                    x+=1;
                    y+=2;
                    cnt++;
//                    System.out.println(cnt+"x:"+x+", y:"+y);
                }
                else if (x+1<m && y-2>=0 && cnt<3){
                    x+=1;
                    y-=2;
                    cnt++;
//                    System.out.println("x:"+x+", y:"+y);
                }
                else if (x+2<m && y+1<n && cnt<3){
                    x+=2;
                    y+=1;
                    cnt++;
//                    System.out.println("x:"+x+", y:"+y);

                }
                else if (x+2<m && y-1>=0 && cnt<3){
                    x+=2;
                    y-=1;
                    cnt++;
//                    System.out.println("x:"+x+", y:"+y);
                }
                else break;
            }
        }

        else {
//            System.out.println("4번 됨");
            cnt = 4;
            x=6; // (6,0)
            y=0;
            while (x<m && y<n ){ // (6,8)
                if (x+1<m && y+2<n){ // 1번
                    x+=1;
                    y+=2;
                    cnt++;
//                    System.out.println("x:"+x+", y:"+y);
                }
                else if (x+1<m && y-2>=0){
                    x+=1;
                    y-=2;
                    cnt++;
//                    System.out.println("x:"+x+", y:"+y);
                }
                else if (x+2<m && y+1<n){
                    x+=2;
                    y+=1;
                    cnt++;
//                    System.out.println("x:"+x+", y:"+y);

                }
                else if (x+2<m && y-1>=0){
                    x+=2;
                    y-=1;
                    cnt++;
//                    System.out.println("x:"+x+", y:"+y);
                }
                else break;
            }
        }
        bw.write(cnt+1+"");
        bw.flush();
        br.close();
    }

}
