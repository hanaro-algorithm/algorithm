import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S2_18111_마인크래프트 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		// 블록의 높이를 저장할 2차원 배열
		int [][] map = new int[N][M];
		// 블록 중 가장 낮은 높이를 저장할 변수
		int min = Integer.MAX_VALUE;
		// 블록 중 가장 높은 높이를 저장할 변수
		int max = Integer.MIN_VALUE;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				min = Math.min(min, map[i][j]);
				max = Math.max(max, map[i][j]);
			}
		}
		
		// 최소 시간 중 가장 높은 높이를 저장할 변수
		int maxH = -1;
		// 최소 시간을 저장할 변수
		int minT = Integer.MAX_VALUE;
		
		// 제일 낮은 높이부터 높은 높이까지 브루트포스로 확인해본다.
		for(int h = min; h <= max; h++) {
			// 해당 높이를 만들기 위해 인벤토리에 필요한 블록의 수
			int block = 0;
			// 해당 높이를 만들 때 걸리는 시간
			int time = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					int now = map[i][j];
					int diff = Math.abs(h-now);
					
					// 만들고자 하는 높이가 현재 블록의 높이보다 높다면 블록을 쌓아야한다.
					if(h > now) {
						time += diff;
						block += diff;
					// 만들고자 하는 높이가 현재 블록의 높이보다 낮다면 블록을 제거해야한다.
					} else {
						time += 2*diff;
						block -= diff;
					}
					
				}
			}
			
			// 인벤토리에 있는 블록의 수보다 필요한 블록의 수 클 경우 해당 높이로 만들 수 없다.
			if(B < block) continue;
			
			// 최소 시간, 최고 높이 갱신
			if(time <= minT) {
				minT = time;
				maxH = Math.max(maxH, h);
			}
			
		}
		
		System.out.println(minT+" "+maxH);

	}

}
