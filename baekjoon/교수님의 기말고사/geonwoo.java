import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_S3_20126_교수님의기말고사 {
	static class Exam implements Comparable<Exam> {
		int start;
		int time;
		
		public Exam(int start, int time) {
			this.start = start;
			this.time = time;
		}

		@Override
		public int compareTo(Exam o) {
			if(this.start != o.start) {
				return Integer.compare(this.start, o.start);
			} else {
				return Integer.compare(this.time, o.time);
			}
		}
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		
		Exam [] arr = new Exam[N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int start = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());
			
			arr[i] = new Exam(start, time);
		}
		
		Arrays.sort(arr);
		
		if(arr[0].start >= M) {
			System.out.println(0);
			System.exit(0);
		}
		
		int past = 0;
		int ans = -1;
		
		for (int i = 0; i < N; i++) {
			Exam ex = arr[i];
			int start = ex.start;
			int time = ex.time;
			
			if(start - past >= M) {
				ans = past;
				break;
			}
			
			past = start + time;			
		}
		
		if(S - past >= M) ans = past;
		
		System.out.println(ans);
		
	}

}
