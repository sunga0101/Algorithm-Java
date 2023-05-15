
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        Main bubble = new Main();
        bubble.start();
    }

    public  void start() throws IOException {
        solve();
    }

    public void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int Iinput = Integer.parseInt(br.readLine());
        int[] arr = new int[Iinput];
        for (int i = 0; i < Iinput; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        sort(arr);
        for (int j = 0; j < arr.length; j++) {
            System.out.println(arr[j]);
        }
    }

    public int[] sort(int arr[] ){
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length-i-1; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        return arr;
    }
}
