import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N + 1];
        for(int i = 1; i <= N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] mis = new int[N + 1]; //실수 여부
        int[] S = new int[N + 1]; //실수 누적합
        for(int i = 1; i <= N; i++){
            if(i < N && arr[i] > arr[i+1]) // i+1을 사용하니 N-1까지만, 실수 체크
                mis[i]++;
            S[i] = S[i-1] + mis[i]; // 현재 실수 누적합 = 이전 실수 누적합 + 현재 실수 여부
        }

        int Q = Integer.parseInt(br.readLine());
        for(int i = 0; i < Q; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if (mis[y] == 1) { // 마지막 y 실수 했다면
                System.out.println(S[y] - S[x - 1] - 1); // -1 (마지막은 실수 절대 안함)
            } else {
                System.out.println(S[y] - S[x - 1]);
            }
        }
    }
}