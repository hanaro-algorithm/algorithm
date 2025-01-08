import java.util.Scanner;

public class BOJ_G4_9663_N_Queen {
	static int N, ans;
	static int [] map;
	static boolean [] v;
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		
		N = scann.nextInt();
		// i번째 행의 몇 열에 퀸을 놓았는지 저장할 배열
		map = new int[N];
		// i번째 열에 퀸을 이미 놓았는지 저장할 배열
		v = new boolean[N];
		
		// 0번째 행부터 모든 경우의 수를 구해본다.
		dfs(0);
		
		System.out.println(ans);

	}
	private static void dfs(int depth) {
		// 퀸을 N개 모두 놓았다면 경우의 수를 추가한다.
		if(N == depth) {
			ans++;
			
			return;
		}
		
		// 퀸을 depth번째 행의 0~N 열에 놓아본다.
		for (int i = 0; i < N; i++) {
			// i번째 열에 퀸이 이미 있다면 놓을 수 없다.
			if(v[i]) continue;
			
			// (depth, i) 번째 칸에 퀸을 놓을 수 있는지 확인해본다.
			map[depth] = i;
			if(!check(depth)) continue;
			
			// 놓을 수 있다면 다음 행에 퀸을 놓아본다.
			// 백트래킹 사용
			v[i] = true;
			dfs(depth+1);
			v[i] = false;
		}
		
	}
	private static boolean check(int depth) {
		for (int i = 0; i < depth; i++) {
			// 이전까지 놓은 퀸과 방금 놓은 퀸이 공격이 가능한지 확인해본다.
			// 퀸은 직선, 대각선으로 한 방향에 놓이면 공격할 수 있다.
			// 직선은 위의 dfs() 함수에서 확인했으니, check() 함수에서는 대각선으로 놓였는지 확인한다.
			// 대각선에 놓은 퀸이 존재한다면 false를 리턴한다.
			if(Math.abs(depth - i) == Math.abs(map[depth] - map[i])) {
				return false;
			}
		}
		
		return true;
	}

}
