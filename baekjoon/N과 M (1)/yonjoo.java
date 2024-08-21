import java.io.*;
import java.util.*;


/*

########### DFS 모르는 상태로 풀기 ##########
########### DFS 모르는 상태로 풀기 ##########

import java.util.*;
public class Main {
    static int M, N;
    public static void initialize(int[] c){
        for(int i = 0; i < c.length; i++){
            c[i] = -1;
        }
    }

    public static boolean check(int[] c){ // 다 체크되면 OK
        for(int i = 0; i < c.length; i++){
            if(c[i] == -1) return false;
        }
        return true;
    }




    public static void find(int cur, int[] arr, int[] ck){
        if(cur == M){
            for(int i : arr){
                System.out.print(i + " ");

            }
            System.out.println();
        }
        else{
            for(int i = 1; i <= N; i++){
                if(ck[i] == -1){
                    arr[cur] = i;
                    ck[i] = 1;
                    find(cur +1, arr, ck);
                    ck[i] = -1;
                    arr[cur] = -1;
                }
                else continue;
            }
        }

    }




    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        M = m;
        N = n;

        int[] arr = new int[m];
        int[] ck = new int[n+1];
        initialize(arr);
        initialize(ck);

        find(0, arr, ck);




    }
}


*/


public class Main {

    static boolean[] visited;
    public void DFS(int depth, int N, int M, String str){
        if(depth == M){
            System.out.println(str.trim());
            return;
        }

        for(int i = 1; i <= N; i++){
            if(!visited[i]){ //이게 백트래킹인가.....????
                visited[i] = true;
                DFS(depth + 1, N, M, str + i + " ");
                visited[i] = false;
            }
        }

    }

    public String[] solution(int N, int M){
        String[] answer = {};

        visited = new boolean[N+1];
        visited[0] = true;

        DFS(0, N, M, "");

        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] str = T.solution(N, M);
        for(String s : str){
            System.out.println(str);
        }

    }
}
