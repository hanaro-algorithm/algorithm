import java.io.*;
import java.util.*;


// 에러 많음, 재풀이 요망

public class Main {

    static Integer pivot = 1;
    static String str = "";
    static Stack<Integer> stack ;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.parseInt(br.readLine());



        stack = new Stack<>();
        stack.push(0);

        boolean flag = false;
        for(int i = 0; i < n-1; i++){
            Integer num = Integer.parseInt(br.readLine());

            if(stack.size() == 0 || stack.peek() < num){
                addNum( num);
            }

            if(stack.peek() == num){
                stack.pop();
                str += "-\n";
            }

            if(stack.peek() > num){
                flag = !flag;
                break;
            }
        }

        if(flag){
            System.out.println("NO");
        }
        else{
            str += "-";
            System.out.println(str);
        }


    }

    public static void addNum( Integer target){
        while(pivot <= target){
            stack.push(pivot++);
            str += "+\n";
        }
        return;
    }


}