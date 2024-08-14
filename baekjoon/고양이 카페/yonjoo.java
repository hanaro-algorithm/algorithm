import java.io.*;
import java.util.*;

public class Main {


    public int solution(int[] numbers, int bound){

        /*
        변수
         */
        int lt = 0, rt = numbers.length - 1;
        int answer = 0;


        /*
        이분탐색, 
        
        [두 수의 합]문제와의 차이점
            - 고양이카페 : 분기점이 2개(초과 or 이하)
            - 두 수의 합 : 분기점이 3개 (일치 or 초과 or 미만)
         */
        while(lt < rt){
            int a = numbers[lt];
            int b = numbers[rt];

            if(a + b <= bound ){ //조건 만족 (bound 값 이하)
                answer += 1;
                lt += 1;
                rt -= 1;
            }
            else { // 만족 X (bound 값 초과)
                rt -= 1;
            }
        }


        /*
        정답
         */
        return answer;
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

        Arrays.sort(weights);


        /*
        main, 출력부
         */
        System.out.println(T.solution(weights, K));

    }
}
