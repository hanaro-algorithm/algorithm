import java.io.*;
import java.util.*;


public class Main {

    public int[] solution(int[] arr, int[][] range){
        int[] answer = new int[range.length];

        //arr = 실수 횟수를 미리 계산한 array

        //차이 계산
        for(int i = 0; i < range.length; i++){
            int start = range[i][0];
            int end = range[i][1];

            answer[i] = arr[end] - arr[start];
        }

        //답
        return answer;
    }


    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        /*
        입력
         */
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        int last = Integer.parseInt(st.nextToken());
        int curr;
        arr[0] = 0;
        arr[1] = 0;
        for(int i = 2; i <= N; i++){
            curr = Integer.parseInt(st.nextToken());
            arr[i] = arr[i-1];
            if(curr < last){
                arr[i] += 1;
            }
            last = curr;
        }


        int Q = Integer.parseInt(br.readLine());
        int[][] range = new int[Q][2];
        for(int i = 0; i < Q; i++){
            st = new StringTokenizer(br.readLine());
            range[i] = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        }


        /*
        main
         */
        int[] ans = T.solution(arr, range);
        for(int i : ans){
            System.out.println(i);
        }
    }
}
