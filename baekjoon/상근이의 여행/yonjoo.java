import java.io.*;
import java.util.*;

public class Main {

    static boolean[] flag;
    static int result;

    private int bfs(int point, final List<List<Integer>> nodeList){

        flag[0] = true;

        Queue<Integer> q = new LinkedList<>();

        Integer init = nodeList.get(point).get(0);
        q.offer(init);
        flag[point] = true;
        flag[init] = true;

        while(!q.isEmpty()){
            int curr = q.poll();

            result += 1;

            List<Integer> currChildren = nodeList.get(curr);
            for(Integer i : currChildren){
                if(flag[i]) continue;

                q.offer(i);
                flag[i] = true;
            }
        }

        return result;
    }

    private int solution(int nodes, List<List<Integer>> nodeList) {

        int answer= 0;
        for(int node = 1; node <= nodes; node++){
            
            //어차피 모든 노드는 간선으로 연결되어 있으니 아무 노드 하나만 찍어서 bfs 돌려도 ㅇㅋ
            if(!flag[node]){
                answer = bfs(node, nodeList);
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            String[] in = br.readLine().split(" ");
            int nodes = Integer.parseInt(in[0]);
            int flights = Integer.parseInt(in[1]);


            result = 0;
            flag = new boolean[nodes + 1];
            List<List<Integer>> nodeList = new ArrayList<>();

            for(int j = 0; j < nodes + 1; j++){
                nodeList.add(new ArrayList<>());
            }

            for(int j = 0; j < flights; j++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                nodeList.get(a).add(b);
                nodeList.get(b).add(a);
            }

            sb.append(T.solution(nodes, nodeList) + "\n");
        }

        System.out.println(sb);

    }
}
