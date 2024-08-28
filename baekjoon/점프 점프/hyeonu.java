import java.util.*;
import java.io.*;

class Main{
    static int n, s;
    static int[] A;
    static boolean[] visit;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        A = new int[n + 1]; // 1 ~ n
        visit = new boolean[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        s = Integer.parseInt(br.readLine());
        System.out.println(bfs());
    }

    static int bfs(){
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        visit[s] = true;
        int cnt = 1;

        while(!q.isEmpty()){
            int cur = q.poll();
            int[] dir = {A[cur], -A[cur]}; // 양 옆 이동 범위

            for(int i : dir){
                int next = cur + i;
                if(next > 0 && next <= n && !visit[next]){ // 범위 내, 미방문
                    visit[next] = true;
                    q.add(next);
                    cnt++;
                }
            }
        }
        return cnt;
    }

}