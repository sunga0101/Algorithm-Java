
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args)  {

        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        int iVal = sc.nextInt();
        int iInput;
        int sum=0;

        for (int i = 0; i < iVal; i++) {
            iInput = sc.nextInt();
            if (iInput != 0) {
                stack.push(iInput);
            }
            else {
                stack.pop();
            }
        }
        if (stack.isEmpty()) {
            System.out.println(0);
            return;
        }

        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        // empty 되면
        System.out.println(sum);
    }
}
