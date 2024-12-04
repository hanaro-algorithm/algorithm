import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < n; i++){
            int input = Integer.parseInt(br.readLine());

            if(input == 0){
                if(!st.isEmpty()){
                    st.pop();
                }
                continue;
            }

            st.push(input);
        }

        int sum = 0;
        while(!st.isEmpty()){
            sum += st.pop();
        }

        System.out.println(sum);
    }
}