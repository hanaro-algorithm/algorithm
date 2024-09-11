import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_S1_14889_스타트와링크 {
	static int N, min;
	static int [][] map;
	static Set<Integer> set;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		min = Integer.MAX_VALUE; 
		map = new int[N][N];
		// 스타트팀으로 선택한 사람의 번호를 저장할 set
		set = new HashSet<>();
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 브루트포스 + 백트래킹으로 모든 경우를 확인해본다.
		dfs(0);
		
		System.out.println(min);
		
	}

	private static void dfs(int start) {
		// 스타트팀을 모두 고른 경우, 능력치의 차이를 계산해본다.
		if(set.size() == N/2) {
			// 스타트 팀 능력치의 합
			int sum = 0;
			// 링크 팀 능력치의 합
			int sum2 = 0;
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(i == j) continue;
					
					// i, j번째 사람 모두 스타트팀인 경우
					if(set.contains(i) && set.contains(j)) {
						sum += map[i][j];
					// i, j번째 사람 모두 링크팀인 경우
					} else if(!set.contains(i) && !set.contains(j)) {
						sum2 += map[i][j];
					}
				}
			}
			
			// 최솟값 갱신
			min = Math.min(min, Math.abs(sum - sum2));
			// 최솟값은 0까지 나올 수 있기 때문에 0이 되면 프로그램을 종료한다.
			if(min == 0) {
				System.out.println(0);
				System.exit(0);
			}
			
			return;
		}
		
		for (int i = start; i < N; i++) {
			set.add(i);
			dfs(i+1);
			set.remove(i);
		}
		
	}

}
