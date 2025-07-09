import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_G2_1781_컵라면 {
	static class Ramen implements Comparable <Ramen> {
		
		int deadline;
		int ramen;
		
		Ramen(int deadline,int ramen) {
			this.deadline=deadline;
			this.ramen=ramen;
		}
		
		@Override
		public int compareTo (Ramen o) {
			if(this.ramen < o.ramen)
				return 1;
			else if(this.ramen == o.ramen) {
				if(this.deadline > o.deadline)
					return 1;
				else if(this.deadline == o.deadline)
					return 0;
			}
			return -1;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		Ramen ramen[] = new Ramen[N];
		
		for(int i = 0; i < ramen.length; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			ramen[i] = new Ramen(n1, n2);
		}
		
		Arrays.sort(ramen,new Comparator<>() {
			@Override
			public int compare(Ramen o1, Ramen o2) {
				if(o1.deadline < o2.deadline)
					return 1;
				else if(o1.deadline == o2.deadline)
					return 0;
				else 
					return -1;
			}
		});
		
		PriorityQueue<Ramen> pq = new PriorityQueue<>();
		
		int cnt = 0;
		int sum = 0;
		
		for(int i = 200000; i >= 1; i--) {
			while(cnt < ramen.length && ramen[cnt].deadline == i) {
				pq.add(ramen[cnt++]);
			}
			
			if(pq.isEmpty()) continue;	
			
			sum += pq.poll().ramen;
		}
		
		System.out.println(sum);		

	}
}