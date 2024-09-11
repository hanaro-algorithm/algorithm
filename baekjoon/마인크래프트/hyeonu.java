import java.io.*;
import java.util.*;

class Main{
    static int N, M;
    static int[] seq;
    static boolean[] visit;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        seq = new int[M];
        visit = new boolean[N + 1];
        bt(0);
    }

    static void bt(int dep){
        if(dep == M){ // 길이 다 참
            for(int i = 0; i < M; i++){
                System.out.print(seq[i] + " ");
            }
            System.out.println();
            return;
        }

        for(int i = 1; i <= N; i++){
            if(!visit[i]){ // 방문X
                visit[i] = true;
                seq[dep] = i; // 수열에 값 추가
                bt(dep + 1); // 수열 다음칸 재귀
                visit[i] = false; // 백트래킹) 취소 -> 다음 차원에서 다시 고를 수 있게
            }
        }
    }
}
