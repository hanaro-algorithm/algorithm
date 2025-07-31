import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_G5_1374_강의실 {
	static class Lecture implements Comparable<Lecture> {
		int start;
		int end;
		
		public Lecture(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Lecture o) {
			if(this.start != o.start) {
				return Integer.compare(this.start, o.start);
			} else {
				return Integer.compare(this.end, o.end);			
			}
		}
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Lecture> lectures = new PriorityQueue<>();
		
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int idx = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			lectures.add(new Lecture(start, end));
		}
		
		PriorityQueue<Integer> room = new PriorityQueue<>();
		room.add(0);
		
		for (int i = 0; i < N; i++) {
			Lecture cur = lectures.poll();
			
			if(room.peek() <= cur.start) {
				room.poll();
			}
			
			room.add(cur.end);
			
		}
		
		System.out.println(room.size());
		
	}

}
