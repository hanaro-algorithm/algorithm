import java.io.*;
import java.util.*;


public class Main {


    public int[] solution(int[] arr, int[][] range){
        int[] answer = new int[range.length];

        //누적합
        int[] arr2 = new int[arr.length];
        arr2[0] = 0;

        for(int i = 1; i < arr2.length; i++){
            arr2[i] = arr[i] + arr2[i-1];
        }

        
        //차이 계산
        for(int i = 0; i < range.length; i++){
            int start = range[i][0];
            int end = range[i][1];

            answer[i] = arr2[end] - arr2[start-1];
        }
        
        //답
        return answer;
    }



    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        
        /*
        입력
         */
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] arr = new int[N+1];
        for(int i = 1; st.hasMoreTokens(); i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[][] range = new int[M][2];
        for(int i = 0; i < M; i++){
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
