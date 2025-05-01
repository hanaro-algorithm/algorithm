import java.util.*;
import java.io.*;

public class Main {

    static int[] prefixSum;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        arr = new int[N + 1];
        prefixSum = new int[N + 1];


        /**
         * 왼쪽 -> 오른쪽
         */
        for(int i = 0; i < N; i++){
            prefixSum[i + 1] = prefixSum[i] + Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        int total = prefixSum[N] - prefixSum[1];
        int max = 0;
        int maxIndex = 0;
        for(int i = 2; i < N; i++){
            int sum = prefixSum[N] - prefixSum[i];
            if(sum > max){
                max = sum;
                maxIndex = i;
            }
        }

        total += max - (prefixSum[maxIndex] - prefixSum[maxIndex - 1]);

        answer = Math.max(answer, total);


        /**
         * 왼쪽 <- 오른쪽
         */
        total = prefixSum[N-1] - prefixSum[1];
        max = 0;
        maxIndex = 0;
        for(int i = N-1; i > 0; i--){
            int sum = prefixSum[i] - prefixSum[0];
            if(sum > max){
                max = sum;
                maxIndex = i;
            }
        }

        total += max - (prefixSum[maxIndex] - prefixSum[maxIndex - 1]);

        answer = Math.max(answer, total);


        /**
         *  -> 가운데 <-
         */
        for(int i = 2 ; i <= N-1; i++){
            int a = prefixSum[i] - prefixSum[1];
            int b = prefixSum[N-1] - prefixSum[i - 1];
            answer = Math.max(answer, a + b);
        }

        System.out.println(answer);

    }
}