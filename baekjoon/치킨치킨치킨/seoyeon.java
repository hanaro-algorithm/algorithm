import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] person = new int[n][m];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                person[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        int result=Integer.MIN_VALUE;

        for(int i = 0; i < M; i++){
            int tmp=0;

            for(int j=i; j < M; j++){
                for(int k = j; k < M; k++){
                    if(i == j || j == k || k == i)
                        continue;

                    int sum=0;
                    int max=0;

                    //회원 수 만큼 반복
                    for(int n = 0; n < N; n++){
                        //선택한 치킨 중 선호도 높은 값 선정
                        max = Math.max(person[n][i], person[n][j]);
                        max = Math.max(max, person[n][k]);
                        sum += max;
                        max = 0;
                    }

                    if(result < sum)
                        result = sum;
                }
            }
        }

        System.out.print(result);
    }
}