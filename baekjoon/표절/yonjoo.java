import java.io.*;
import java.util.*;

/*
결과 타입이 int가 아니고 long 이었음
*/

public class Main {

    private Long solution(final int[] solutions){
        long answer = 0;
        Arrays.sort(solutions);

        for(int i = 0; i < solutions.length; i++){

            int lt = i, rt = solutions.length - 1;
            int mid;

            int bound = 0;
            while(lt <= rt){
                mid = (lt + rt)/2;
                if(solutions[i] * 10 >= solutions[mid]*9){
                    bound = mid;
                    lt = mid + 1;
                }
                else {
                    rt = mid - 1;
                }
            }

            answer += bound - i;
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] solutions = new int[N];
        for(int i = 0; st.hasMoreTokens(); solutions[i++] = Integer.parseInt(st.nextToken())){}

        System.out.println(T.solution(solutions));

    }


}
