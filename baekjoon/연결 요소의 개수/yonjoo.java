import java.util.*;
import java.io.*;

public class Main {

    static List<List<Integer>> list;
    static boolean[] visited;

    static int count = 0;

    private void BFS(int start){
        Queue<Integer> q = new LinkedList<>();

        q.offer(start);
        visited[start] = true;

        while(!q.isEmpty()){
            int curr = q.poll();

            for(Integer node : list.get(curr)){
                if(visited[node]) continue;
                visited[node] = true;
                q.offer(node);
            }
        }

        count += 1;
    }

    private void DFS(int start){

        for(int node : list.get(start)){
            if(visited[node]) continue;
            visited[node] = true;
            DFS(node);
        }
    }

    private int solution(int N, int M){

        visited = new boolean[N + 1];

        for(int i = 1; i <= N; i++){
            if(visited[i]) continue;
            BFS(i);
        }

        return count;

    }

    private int solution2(int N, int M){

        visited = new boolean[N + 1];

        for(int i = 1; i <= N; i++){
            if(visited[i]) continue;
            visited[i] = true;
            DFS(i);
            count++; // DFS 안에서 카운팅 ㄴㄴ, DFS 밖에서 카운팅
        }
        return count;
    }
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;


        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        for(int i = 0; i <= N; i++) list.add(new ArrayList<>());
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            list.get(s).add(e);
            list.get(e).add(s);
        }


        System.out.println(T.solution2(N, M));

    }
}