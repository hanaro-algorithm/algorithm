import java.io.*;
import java.util.*;

public class Main {

    static int N, M, B;
    static int[][] array;

    private void solution(int n, int m, int b, int[][] arr){
        int answerTime= Integer.MAX_VALUE;
        int answerHeight = 0;
        int MIN = 0;
        int sum = b;
        for(int[] row : arr){
            for(int i : row){
                sum += i;
            }
        }


        int avg = sum/(n * m); //최대 높이

        while(avg >= 0){
            MIN = 0;
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    if(arr[i][j] < avg){
                        MIN += avg - arr[i][j];
                        continue;
                    }
                    if(arr[i][j] > avg){
                        MIN += 2*(arr[i][j] - avg);
                        continue;
                    }
                }
            }

            if(MIN < answerTime) {
                answerTime = MIN;
                answerHeight = avg;
            }
            avg -= 1;
        }

        System.out.println(answerTime + " " +  answerHeight);
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        array = new int[N][M];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        T.solution(N, M, B, array);


    }
}
