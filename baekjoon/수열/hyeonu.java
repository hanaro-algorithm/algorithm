import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        int sum = 0, cur = 0;

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            if(i < K)
                sum += arr[i];
        }
        cur = sum;
        for(int i = K; i < N; i++){
            cur = cur - arr[i-K] + arr[i];
            if(sum < cur)
                sum = cur;
        }
        System.out.println(sum);
    }
}