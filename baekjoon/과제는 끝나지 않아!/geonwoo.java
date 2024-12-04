import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_S3_17952_과제는끝나지않아 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		// 받을 과제 총점수를 저장할 변수
		int ans = 0;
		// 현재 진행중인 과제의 점수를 저장할 변수
		int score = 0;
		// 현재 진행중인 과제의 남은 시간을 저장할 변수
		int time = 0;
		
		// 중단한 과제를 저장하기 위한 덱
		Deque<int []> deq = new ArrayDeque<>();
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int comm = Integer.parseInt(st.nextToken());
			
			// comm이 1일 경우, 진행중이던 과제를 중단하고 새로운 과제를 시작한다.
			if(comm == 1) {
				// 덱의 앞에 중단한 과제를 넣는다.
				deq.addFirst(new int[] {score, time});
				score = Integer.parseInt(st.nextToken());
				time = Integer.parseInt(st.nextToken());
			}
			
			// 남은 과제시간이 0분 초과인 경우 1분을 줄인다.
			if(time > 0) time--;
			
			// 남은 과제시간이 0분일 때, 진행중이던 과제가 있다면 ans에 점수를 추가한다.
			// 덱에 과제가 남아있다면 하나 꺼내서 마저 진행할 준비를 한다.
			if(time == 0) {
				ans += score;
				score = 0;
				
				// 덱에 과제가 더이상 없을 경우를 대비한 if문
				if(deq.size() > 0) {					
					int [] next = deq.poll();
					score = next[0];
					time = next[1];
				}
			}
			
		}
		
		System.out.println(ans);
		
	}

}
