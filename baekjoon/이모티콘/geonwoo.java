import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_G4_14226_이모티콘 {
	static int S, ans;
	
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		
		S = scann.nextInt();
		
		bfs();
		
		System.out.println(ans);

	}

	private static void bfs() {
		Queue<int []> q = new ArrayDeque<>();
		// 2차원 boolean 배열을 만들어 큐에 중복으로 들어가지 않게 한다. [이모티콘 개수, 클립보드 개수]
		boolean [][] v = new boolean[1001][1001];
		q.add(new int[] {1, 0});
		v[1][0] = true;
		
		// 소요된 시간
		int time = 0;
		
		while(!q.isEmpty()) {
			int size = q.size();
			
			for (int i = 0; i < size; i++) {
				int [] cur = q.poll();
				
				// 현재 이모티콘의 개수
				int emo = cur[0];
				// 클립보드에 저장된 이모티콘의 개수
				int clip = cur[1];
				
				// 현재 이모티콘의 개수가 S와 같으면 종료한다.
				if(emo == S) {
					ans = time;
					return;
				}
				
				// 현재 이모티콘 + 클립보드의 이모티콘 더한 값
				int copy = emo + clip;
				int delete = emo-1;
				
				// 1번 연산
				// [현재 이모티콘 수][현재 이모티콘 수] 방문 기록이 없으면 방문 처리 후 큐에 넣는다.
				if(!v[emo][emo]) {
					v[emo][emo] = true;
					q.add(new int[] {emo, emo});
				}
				
				// 2번 연산
				// 클립보드가 비어있지 않고, copy가 1000을 넘지 않고, 방문 기록이 없으면 처리 후 큐에 넣는다.
				if(clip != 0 && copy <= 1000 && !v[copy][clip]) {
					v[copy][clip] = true;
					q.add(new int[] {copy, clip});
				}
				
				// 3번 연산
				// delete가 2보다 크고, 방문 기록이 없으면 처리 후 큐에 넣는다.
				if(delete >= 2 && !v[delete][clip]) {
					v[delete][clip] = true;
					q.add(new int[] {delete, clip});
				}
				
			}
			
			time++;
			
		}
		
		
	}

}
