import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {


   public double solution(int n, int m){
       double initialZ = (double)m * 100 /n;

       if(initialZ >= 99) return -1;

    //double -> long
       long start = 1;
       long end = Integer.MAX_VALUE;

       long lt = start;
       long rt = end;
       long mid = 0;

       long res = 0;

       
       //binary search, 구체적이 target의 존재여부 확인하지 않고 가능한만큼 땡기기
       while(lt <= rt){
           mid = (lt + rt)/2;

           int z = (int)((m + mid) * 100/(n + mid));

           //초기 확률값보다 클 경우에 res값 업데이트, mid 위치 줄여나가다가 마지막으로 업데이트 된 값이 정답
           if(initialZ < z) {rt = mid - 1; res = mid;}
           else lt = mid + 1;
       }
       
       return res;
   }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());


        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());


        //main
//        System.out.println(T.solution(cards, numbers));
        int res = (int)T.solution(n, m);

        System.out.println(res);
    }
}
