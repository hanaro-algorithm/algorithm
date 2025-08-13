import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_G4_16197_두동전 {
	static int N, M;
	static char [][] map;
	static int [] dr = {-1, 0, 1, 0};
	static int [] dc = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		
		int [][] coins = new int[2][2];
		int idx = 0;
		
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j);
				
				if(map[i][j] == 'o') {
					coins[idx][0] = i;
					coins[idx++][1] = j;
					map[i][j] = '.';
				}
			}
		}
		
		int ans = bfs(coins[0][0], coins[0][1], coins[1][0], coins[1][1]);
		
		System.out.println(ans);
		
	}

	private static int bfs(int sr1, int sc1, int sr2, int sc2) {
		Queue<int []> q = new ArrayDeque<>();
		q.add(new int[] {sr1, sc1, sr2, sc2});
		
		Set<String> set = new HashSet<>();
		set.add(""+sr1+sc1+sr2+sc2);
		
		int turn = 0;
		
		while(!q.isEmpty()) {
			int size = q.size();
			
			for (int i = 0; i < size; i++) {
				int [] cur = q.poll();
				
				for (int d = 0; d < 4; d++) {
					
					int nr1 = cur[0] + dr[d];
					int nc1 = cur[1] + dc[d];
					int nr2 = cur[2] + dr[d];
					int nc2 = cur[3] + dc[d];
					
					// 동시에 떨어지는 경우
					if(!check(nr1, nc1) && !check(nr2, nc2)) continue;
					// 하나만 떨어지는 경우
					else if(!check(nr1, nc1) && check(nr2, nc2) || !check(nr2, nc2) && check(nr1, nc1)) {
						return turn+1;
					}
					
					// 둘다 벽에 걸리는 경우(안움직임)
					if(map[nr1][nc1] == '#' && map[nr2][nc2] == '#') continue;
					else if(map[nr1][nc1] == '#' && map[nr2][nc2] != '#') {
						if(cur[0] == nr2 && cur[1] == nc2) continue;
						nr1 = cur[0];
						nc1 = cur[1];
					} else if(map[nr1][nc1] != '#' && map[nr2][nc2] == '#') {
						if(cur[2] == nr1 && cur[3] == nc1) continue;
						nr2 = cur[2];
						nc2 = cur[3];
					}
					
					String s = ""+nr1+nc1+nr2+nc2;
					
					if(set.contains(s)) continue;
					
					set.add(s);
					q.add(new int[] {nr1, nc1, nr2, nc2});
					
				}
				
			}
			
			if(++turn >= 10) return -1;
			
		}
		
		return -1;
	}

	private static boolean check(int r, int c) {
		return r>=0 && r<N && c>=0 && c<M;
	}

}
