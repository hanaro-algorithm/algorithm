import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        Stack<Integer> stack = new Stack<Integer>();

        for (int i = 0; i < n; i++) {
            int num = scan.nextInt();
            if (num == 0) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(num);
            }

        }

        int sum = 0;
        for (int number : stack) {
            sum += number;
        }

        System.out.println(sum);
    }
}