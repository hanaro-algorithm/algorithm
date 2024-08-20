import java.io.*;
import java.util.*;


public class Main {

    static boolean[] visited;
    static int[] numbers;
    static int ans;

    public void DFS(int depth, int  N, int start, int sum){
        if(depth == N){
            if(!visited[sum]){
                ans++;
                visited[sum] = true;
            }
            return;
        }

        for(int i = start; i < 4; i++){ // i = 0 인거랑 i = start 인거랑 효율성/중복 차이 큼
            DFS(depth + 1, N,  i ,sum + numbers[i]);
        }
    }

    public int solution(int N){
        if(N == 1) return 4;

        visited = new boolean[N * 50 + 1]; // Set vs boolean[] : N <= 20 이라서 boolean[]
        ans = 0;

        numbers = new int[]{1, 5, 10, 50};

        DFS(0, N, 0, 0);

        return ans;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());



        System.out.println(T.solution(N));

    }
}
