
import java.util.Scanner;
import java.util.Stack;

public class Main {
    static Stack<String> stack;
    public static String check(String[] s){
        for (int j = 0; j < s.length; j++) {
            if (s[j].equals("(")) {
                stack.push(s[j]);
            }
            else if  (stack.isEmpty()) {
                return "NO";

            } else {
                stack.pop();
            }
        }
        if (stack.isEmpty()) return "YES";
        else return "NO";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            stack = new Stack<>();
            String[] s = sc.next().split("");
            System.out.println(check(s));
        }
    }
}
