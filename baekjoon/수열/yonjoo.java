import java.io.*;
import java.util.*;


public class Main {

    private int solution(int N, int K, int[] temperatures){
        int answer = Integer.MIN_VALUE;

        int sum = 0;
        for(int i = 0; i < K; i++){
            sum += temperatures[i];
        }
        answer = sum;

        for(int i = K; i < temperatures.length; i++){
            sum = sum -temperatures[i - K] + temperatures[i];
            if(sum > answer) answer = sum;
        }

        return answer;
    }


    public static void main(String[] args) throws IOException {
        Main T = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(T.solution(N, K, arr));
    }
}
