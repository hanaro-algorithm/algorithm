import java.io.*;
import java.util.*;

public class Main {

    static boolean[] flag;
    static int answer = 0;
    static int N, M;
    static int[][] weights;
    
    /*
    public void comb(int d, int s){
        if(d == 5){
            //static 변수에 값 대입 or "print"
            return;
        }
        
        for(int i = s; i < 100; i++){
            //visited[i] = true;
            comb(d + 1, s + 1);
            //visited[i] = false;
        }
    }
    */

    public void bfs(int depth, int start){

        /*
        변수(조합의 최대 만족도)
         */
        int cnt = 0;


        /*
        종료조건
         */
        if(depth == 3){ // 조합 원소의 갯수가 3개일 때 break;
            for(int member = 0; member < N; member++){
                int max = 0; // member의 조합 내 최대 만족도
                for(int chicken = 0; chicken < M; chicken++){
                    if(flag[chicken]){ // <-- 조합
                        max = Math.max(max, weights[member][chicken]);
                    }
                }
                cnt += max; // member들 끼리의 최대 만족도 합
            }

            answer = Math.max(answer, cnt); //최대값 업데이트
            return;
        }


        /*
        종료 아닌 조건?
        조합 만들기
         */
        for(int i = start; i < M; i++){
            if(flag[i]) continue;

            flag[i] = true;
            bfs(depth + 1, i + 1);
            flag[i] = false;
        }

    }
    public int solution(int[][] numbers, int n, int m){

        /*
        변수
         */
        N = n;
        M = m;
        weights = numbers;
        flag = new boolean[M]; //M : 치킨 수

        /*
        BFS 로 조합(Combination) : 조합 중에서 가장 만족도 합이 큰 값 구하기
         */
        bfs(0, 0);



        //BFS 결과값(최댓값)
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        /*
        입력부
         */
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] weight = new int[n][m];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                weight[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        /*
        main, 출력부
         */
        System.out.println(T.solution(weight, n, m));

    }
}
