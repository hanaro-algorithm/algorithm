import java.io.*;
import java.util.*;

public class Main {

    public int solution(int[] tensions){

        int lt = 0, rt = 0;
        int result = 0;


        for(int i = tensions.length - 1; i >= 0; i--){
            result = Math.max(result, tensions[i] * (tensions.length - i));
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] tensions = new int[n];

        for(int i = 0; i < n; tensions[i++] = Integer.parseInt(br.readLine())){}
        Arrays.sort(tensions);

        System.out.println(T.solution(tensions));


    }
}
