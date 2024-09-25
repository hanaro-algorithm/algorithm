import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S3_2853_NBA농구 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int score1 = 0;
		int score2 = 0;
		int time1 = 0;
		int time2 = 0;
		
		// 이전 득점 시점(초단위)을 저장할 변수
		int pastTime = 0;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			// 득점한 팀 번호
			int team = Integer.parseInt(st.nextToken());
			
			String [] arr = st.nextToken().split(":");
			// 득점한 시점
			int time = strToTime(arr[0], arr[1]);
			
			// 이전 득점 ~ 현재 득점까지 이기고 있던 팀에 시간을 더해준다.
			if(score1 > score2) time1 += (time - pastTime);
			else if(score1 < score2) time2 += (time - pastTime);
			
			// 이번에 득점한 팀에 점수를 추가한다.
			if(team == 1) score1++;
			else score2++;
			
			// 이전 득점 시점을 갱신한다.
			pastTime = time;
		}
		
		// 경기가 48:00에 끝나므로, 마지막까지 이기고 있던 팀에 시간을 더해준다.
		if(score1 > score2) time1 += (strToTime("48", "00") - pastTime);
		else if(score1 < score2) time2 += (strToTime("48", "00") - pastTime);
		
		System.out.println(timeToStr(time1));
		System.out.println(timeToStr(time2));
		
	}

	private static String timeToStr(int time) {
		String min = String.format("%02d", time/60);
		String sec = String.format("%02d", time%60);
		
		return min+":"+sec;
	}

	private static int strToTime(String min, String sec) {
		return Integer.parseInt(min)*60 + Integer.parseInt(sec);
	}

}
