import java.util.*;
import java.io.*;

public class Main {

    class Node {
        int x;
        int depth;

        Node(int x, int depth){
            this.x = x;
            this.depth  = depth;
        }
    }
    static int A, B, N, M;
    static boolean[] visited;
    static List<Integer> list = new ArrayList<>();

    private void BFS(int start, int depth){
        Node node = new Node(start, depth);

        Queue<Node> q = new LinkedList<>();

        q.offer(node);
        visited[start] = true;
        while(!q.isEmpty()){
            Node curr = q.poll();

            for(int d = 0; d < 8; d++){
                int nx = curr.x;
                switch (d){
                    case 0:
                        nx += 1;
                        break;
                    case 1:
                        nx += -1;
                        break;
                    case 2:
                        nx += A;
                        break;
                    case 3:
                        nx -= A;
                        break;
                    case 4:
                        nx += B;
                        break;
                    case 5:
                        nx -= B;
                        break;
                    case 6:
                        nx += (A - 1) * curr.x;
                        break;
                    case 7:
                        nx += (B - 1) * curr.x;
                        break;
                }

                if(nx > 100000 || nx < 0){
                    continue;
                }

                if(visited[nx] || nx > 100000 || nx < 0) continue;
                visited[nx] = true;
                if(nx == M){
                    list.add(curr.depth + 1);
                }
                else q.offer(new Node(nx, curr.depth + 1));
            }
        }
    }
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        //예외 1 , 시작점 == 끝 지점
        if (N == M) {
            System.out.println(0);
            return;
        }

        visited = new boolean[100001];

        T.BFS(N, 0);
        System.out.println(Collections.min(list));

    }
}