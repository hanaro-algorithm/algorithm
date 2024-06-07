import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.parseInt(br.readLine());

        String inputArr = br.readLine();
        Integer[] arr = Arrays.stream(inputArr.split(" ")).map((item) -> Integer.parseInt(item)).toArray(Integer[]::new);


        Stack<Integer> stack;
        List<Integer>  answer = new ArrayList<>();
        for(int i = 0; i < arr.length; i+= 1){

            stack  = new Stack<>();
            stack.push(arr[i]);

            for(int j = i+1; j < arr.length; j+= 1){
                Integer last = stack.peek();
                Integer now = arr[j];

                if(last < now){
                    stack.push(now);
                }
            }

            if(answer.size() < stack.size()){
                answer = new ArrayList<>(stack);
            }
        }


//        answer.stream().forEach(o-> System.out.print(o + " "));
        System.out.println(answer.size());

    }
}