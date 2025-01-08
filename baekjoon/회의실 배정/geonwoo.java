import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_G5_1931_회의실배정 {
	static class Time implements Comparable<Time> {
		int start;
		int end;
		
		public Time(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Time o) {
			if(this.start == o.start) {
				return Integer.compare(o.end, this.end);
			}

			return Integer.compare(o.start, this.start);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		List<Time> list = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			list.add(new Time(start, end));
		}
		
		Collections.sort(list);
		
		int ans = 0;
		
		int lastTime = Integer.MAX_VALUE;
		
		for (Time now : list) {
			if(now.end > lastTime) continue;
			
			ans++;
			lastTime = now.start;
		}
		
		System.out.println(ans);
		
	}

}
