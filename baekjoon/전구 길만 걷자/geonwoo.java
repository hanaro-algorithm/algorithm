import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_S2_17359_전구길만걷자 {
	static int N, min;
	static int [][] blub;
	static boolean [] used;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		// 전구의 맨 앞, 맨 뒤를 저장할 2차원 배열
		blub = new int[N][2];
		// 순열을 사용할 때, 사용한 전구인지를 저장할 1차원 배열
		used = new boolean[N];
		// 전구의 상태가 바뀌는 횟수
		int ans = 0;
		// 배치에 따라 전구 상태가 바뀌는 최소 횟수
		min = Integer.MAX_VALUE;
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			
			// 각 전구마다 배치를 제외하고 상태가 바뀌는 횟수를 미리 구한다.
			char past = str.charAt(0);
			for (int j = 0; j < str.length(); j++) {
				char c = str.charAt(j);
				
				if(c != past) ans++;
				
				past = c;
			}
			
			// 전구의 맨 앞, 맨 뒤 상태를 저장한다.
			blub[i][0] = str.charAt(0) - '0';
			blub[i][1] = str.charAt(str.length()-1) - '0';
		}
		
		// 순열을 통해 모든 순서쌍을 확인한다.
		perm(0, 0, -1);
		
		System.out.println(min+ans);
		
	}

	private static void perm(int depth, int cnt, int tail) {
		// 모든 전구를 배치했을 때 min을 갱신한다.
		if(depth == N) {
			min = Math.min(min, cnt);
			
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if(used[i]) continue;
			
			// 전구 사용 처리
			used[i] = true;
			int head = blub[i][0];
			// 현재 선택한 전구의 맨 앞과 이전 전구의 맨 뒤가 다르거나, 처음으로 선택한 전구가 아닐 경우 cnt+1 한다.
			if(head != tail && tail != -1) cnt++;
			
			perm(depth+1, cnt, blub[i][1]);
			
			// 백트래킹을 사용하여 +1 해줬던 cnt를 다시 빼준다.
			if(head != tail && tail != -1) cnt--;
			// 마찬가지로 전구 미사용 처리를 해준다.
			used[i] = false;
		}
		
	}

}
