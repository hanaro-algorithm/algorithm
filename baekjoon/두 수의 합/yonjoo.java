import java.io.*;
import java.util.*;

public class Main {


    public int solution(int[] numbers, int target){

        /*
        변수
         */
        int lt = 0, rt = numbers.length - 1;
        int answer = 0;


        /*
        이분탐색, 
        
        [고양이카페]문제와의 차이점
            - 고양이카페 : 분기점이 2개(초과 or 이하)
            - 두 수의 합 : 분기점이 3개 (일치 or 초과 or 미만)
         */
        while(lt < rt){
            int a = numbers[lt];
            int b = numbers[rt];

            if(a + b == target ){ //합이 target
                answer += 1;
                lt += 1;
                rt -= 1;
            }
            else if(a + b < target){ //target보다 작을 때
                lt += 1;
            }
            else { // 클 때
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
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] numbers = new int[n];
        for(int i = 0; i < n; numbers[i++] = Integer.parseInt(st.nextToken())){}

        int target = Integer.parseInt(br.readLine());
        Arrays.sort(numbers);


        /*
        main, 출력부
         */
        System.out.println(T.solution(numbers, target));

    }
}
