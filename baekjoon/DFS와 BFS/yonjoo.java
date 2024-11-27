import java.io.*;
import java.util.*;


public class Main {

    static boolean[] visited;
    static List<List<Integer>> list;

    public String BFS(int start){
        String answer = "";
        StringBuilder sb = new StringBuilder();

        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;

        while(!q.isEmpty()){
            int curr = q.poll();

            sb.append(curr).append(" ");

            for(Integer i : list.get(curr)){
                if(!visited[i]){
                    q.offer(i);
                    visited[i] = true;
                }
            }
        }

        return sb.toString().trim();
    }

    public String DFS(int depth, int vertex, int start, String ans){
        visited[start] = true;

        if(depth == vertex){
            return ans;
        }
        else{
            List<Integer> children = list.get(start);
            for(Integer child : children){
                if(!visited[child]){
                    visited[child] = true;
                    ans = DFS(depth + 1, vertex, child, ans + child + " ");
                }
            }
        }

        return ans;
    }

    public String DFS2(int start){
        StringBuilder sb = new StringBuilder();

        Stack<Integer> stack = new Stack<>();
        stack.push(start);

        while(!stack.isEmpty()){
            int curr = stack.pop();
            if(visited[curr]) continue;

            visited[curr] = true;
            sb.append(curr).append(" ");

            List<Integer> children = new ArrayList<>(list.get(curr));
            Collections.reverse(children); //노드 번호 작은 순서대로 뽑으려면 reverse 해야함

            for(int child : children){
                if(!visited[child]){
//                    sb.append(child).append(" ");
                    stack.push(child);
                }
            }
        }
        return sb.toString().trim();
    }

    public void solution(int start, int vertex, int[][] edges){
        int answer = 0;

        visited = new boolean[vertex + 1]; // + 1 잊지 말기

        //인접 리스트
        list = new ArrayList<>();
        for(int i = 0; i < vertex + 1; i++){
            list.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            list.get(edge[0]).add(edge[1]);
            list.get(edge[1]).add(edge[0]);
        }

        //인접리스트 정렬
        for(List<Integer> li : list){
            Collections.sort(li);
        }


//        System.out.println(DFS(0, vertex, start, start + " "));
        System.out.println(DFS2(start));
        visited = new boolean[vertex + 1]; // + 1 잊지 말기
        System.out.println(BFS(start));

    }



    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int vertex = Integer.parseInt(st.nextToken());
        int edges = Integer.parseInt(st.nextToken());
        int startingPoint = Integer.parseInt(st.nextToken());

        int[][] edge = new int[edges][2];
        for(int i = 0; i < edges; i++){
            String[] in = br.readLine().split(" ");
            edge[i][0] = Integer.parseInt(in[0]);
            edge[i][1] = Integer.parseInt(in[1]);
        }

        T.solution(startingPoint, vertex,edge);
    }
}
