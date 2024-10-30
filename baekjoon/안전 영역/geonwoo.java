import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_S1_2468_안전영역 {

    static int N;
    static int [][] map;
    static boolean [][] v;
    static int [] dr = {-1, 1, 0, 0};
    static int [] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        // 최대 영역 개수를 저장할 변수
        int ans = 0;
        // 지점의 최소, 최댓값을 구한다.
        int maxH = 1;
        int minH = 1;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                maxH = Math.max(maxH, map[i][j]);
                minH = Math.min(minH, map[i][j]);
            }
        }
        
        // 최소높이-1 부터 최대높이-1까지 비를 내려보면서 그 떄의 안전 영역의 개수를 구한다.
        for (int i = minH-1; i < maxH; i++) {
        	v = new boolean[N][N];
        	 ans = Math.max(ans, bfs(i));
		}
       
        System.out.println(ans);

    }

    private static int bfs(int n) {
    	int cnt = 0;
    	
    	for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				// 물에 잠겼거나, 이미 확인했던 지점이면 넘어간다.
				if(map[r][c] <= n || v[r][c]) continue;
				
		        Queue<int[]> q = new LinkedList<>();
		        v[r][c] = true;
		        q.add(new int[] {r, c});

		        while(!q.isEmpty()) {
		            int [] cur = q.poll();

		            for (int d = 0; d < 4; d++) {
		                int nr = cur[0]+dr[d];
		                int nc = cur[1]+dc[d];
		                
		                // 맵을 벗어나지 않고, 방문하지 않았고, 잠기지 않는 영역이라면 큐에 넣어준다.
		                if(check(nr, nc) && !v[nr][nc] && map[nr][nc] > n) {
		                	v[nr][nc] = true;
		                	q.add(new int[] {nr, nc});
		                }

		            }

		        }
		        
		        // 물에 잠기지 않는 영역을 구하면 cnt를 +1 해준다.
		        cnt++;
				
			}
		}
    	
    	return cnt;
    }

	private static boolean check(int r, int c) {
		return r>=0 && r<N && c>=0 && c<N;
	}

}