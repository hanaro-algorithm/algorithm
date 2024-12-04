import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();

        Stack<int[]> stack = new Stack<>();
        int total = 0;

        for (int i = 0; i < n; i++) {
            int work = scan.nextInt();

            if(work == 1){
                int score = scan.nextInt();
                int time = scan.nextInt();
                stack.push(new int[]{score, time});
            }

            if(!stack.isEmpty()){
                int[] currentTask = stack.pop();
                currentTask[1]--;

                if(currentTask[1] == 0){
                    total += currentTask[0];
                } else{
                    stack.push(currentTask);
                }
            }
        }

        System.out.println(total);
    }
}