import java.io.*;
import java.util.*;


public class Main {

    static int N, S;
    static int[] arr;
    static boolean[] visited;
    static int result;
    

    void dfs(int start) {
        int front = start - arr[start];
        int back = start + arr[start];
        
        //왼쪽으로
        if(back <= N && !visited[back]) {
            visited[back] = true;
            result++;
            dfs(back);
        }
        
        //오른쪽으로
        if(front > 0 && !visited[front]) {
            visited[front] = true;
            result++;
            dfs(front);
        }
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        visited = new boolean[N + 1];

        result = 1;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        S = Integer.parseInt(br.readLine());

        visited[S] = true;
        T.dfs(S);

        System.out.println(result);

    }
}
