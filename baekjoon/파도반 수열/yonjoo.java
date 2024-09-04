import java.io.*;
import java.util.*;


public class Main {

    long solution(int N){

        if(N <= 3) return 1;

        long[] arr = new long[N + 1];
        arr[1] = 1;
        arr[2] = 1;
        arr[3] = 1;

        for(int i = 4; i <=N; i++){
            arr[i] = arr[i-3] + arr[i-2];
        }

        return arr[N];
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        int N;
        for(int i = 0; i < t; i++){
            N = Integer.parseInt(br.readLine());
            sb.append(T.solution(N) + "\n");
        }

        System.out.println(sb.toString().trim());

    }
}
