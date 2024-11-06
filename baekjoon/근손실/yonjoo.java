import java.util.*;
import java.io.*;

public class Main {
    static int N,K;
    static int[] kit, arr;
    static boolean[] visited;
    static int answer;

    private static void dfs(int depth) {
        if (depth == N) {
            if(check()){
                answer++;
            }
            return;
        }

        for (int i = 0; i < N; i++) {
            if(!visited[i]){
                visited[i] = true;
                arr[depth] = i;
                dfs(depth + 1);
                visited[i] = false;
            }

        }
    }

    private static boolean check() {
        int muscle = 500;
        for (int i = 0; i < N; i++) {
            muscle += kit[arr[i]] - K;
            if (muscle < 500) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        kit = new int[N];
        arr = new int[N];

        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            kit[i] = Integer.parseInt(st.nextToken());
        }
        dfs(0);
        System.out.println(answer);
    }


}