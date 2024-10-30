import java.util.*;
import java.io.*;

class Main {
    static int N, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
    static int[] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = new int[N];
        for(int i = 0; i < N; i++)
            A[i] = Integer.parseInt(st.nextToken());
        int[] oper = new int[4];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++)
            oper[i] = Integer.parseInt(st.nextToken());
        dfs(1, A[0], oper);
        System.out.println(max);
        System.out.println(min);
    }
    static void dfs(int dep, int sum, int[] op){
        if(dep == N){
            max = Math.max(max,sum);
            min = Math.min(min,sum);
            return;
        }
        for(int j = 0; j < 4; j++){
            if(op[j] <= 0)
                continue;
            op[j]--;
            if(j == 0)
                dfs(dep+1, sum+A[dep], op);
            if(j == 1)
                dfs(dep+1, sum-A[dep], op);
            if(j == 2)
                dfs(dep+1, sum*A[dep], op);
            if(j == 3)
                dfs(dep+1, sum/A[dep], op);
            op[j]++;
        }

    }

}
