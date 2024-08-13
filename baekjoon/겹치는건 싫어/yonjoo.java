import java.io.*;
import java.util.*;

public class Main {

    public int solution(int[] arr, int n, int k){

        int lt = 0, rt = 0;
        int[] cnt = new int[1000001];
        int result = 0;


        while(rt < n){

            while(rt < n && cnt[arr[rt]] < k){
                cnt[arr[rt++]]++;
            }

            result = Math.max(result, rt - lt);
            cnt[arr[lt++]]--;

        }

        return result;
    }

    
    public int solution3(int[] numbers, int K){

        /*
        변수
         */
        int lt = 0, rt = 0;
        int answer = 0;

        Map<Integer, Integer> map = new HashMap<>();

        /*
        이분탐색
         */
        while(rt < numbers.length){
            int num = numbers[rt];
            int cnt = map.getOrDefault(num, 0);

            if(cnt >= K){
                answer = Math.max(answer, rt - lt);
                map.put(numbers[lt], map.get(numbers[lt]) - 1);
                lt++;

                continue;
            }

            map.put(num, cnt + 1);
            rt++;

        }

        /*
        정답
         */
        return answer = Math.max(answer, rt - lt);
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /*
        입력부
         */
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());


        st = new StringTokenizer(br.readLine());
        int[] weights = new int[N];
        for(int i = 0; i < N; weights[i++] = Integer.parseInt(st.nextToken())){}


        /*
        main, 출력부
         */
        System.out.println(T.solution3(weights, K));

    }
}
