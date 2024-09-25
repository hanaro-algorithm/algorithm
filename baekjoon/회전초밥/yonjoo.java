import java.io.*;
import java.util.*;


public class Main {

    private int solution(int N, int d, int k, int c, int[] arr){

        int answer = 0;
        int[] cnt = new int[d + 1];
        int sushi = 0;
        for(int i = 0; i < k; i++){
            cnt[arr[i]] += 1;

            if(cnt[arr[i]] == 1) sushi += 1;
        }
        if(cnt[c] == 0){
            sushi += 1;
        }
        answer = sushi;

        for(int i = 0; i < N; i++){
            int index = (i + k ) % N;

            int add = arr[index];
            int sub = arr[i];

            cnt[add]++;
            cnt[sub]--;


            if(cnt[sub] == 0) sushi--;
            if(cnt[add] == 1) sushi++;
            if(cnt[c] == 0) {
                answer = Math.max(answer, sushi + 1);
            }else{
                answer = Math.max(answer, sushi);
            }

        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();

        //접시의 수 N, 초밥의 가짓수 d, 연속해서 먹는 접시의 수 k, 쿠폰 번호 c

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(T.solution(N, d, k, c, arr));
    }
}
