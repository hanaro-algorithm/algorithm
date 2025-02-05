import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_G5_19598_최소회의실개수 {
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
				return Integer.compare(this.end, o.end);
			}
			
			return Integer.compare(this.start, o.start);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Time> times = new PriorityQueue<>();
		PriorityQueue<Integer> meeting = new PriorityQueue<>();
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			times.add(new Time(start, end));
		}
		
		meeting.add(times.poll().end);
		
		while (!times.isEmpty()) {
			Time t = times.poll();
			
			if(t.start >= meeting.peek()) {
				meeting.poll();
			}
			
			meeting.add(t.end);
			
		}
		
		System.out.println(meeting.size());
		
	}

}
