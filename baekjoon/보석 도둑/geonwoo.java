import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_G2_1202_보석도둑 {
	static class Jewel implements Comparable<Jewel> {
		int weight;
		int price;
		
		public Jewel(int weight, int price) {
			this.weight = weight;
			this.price = price;
		}

		// 무게 낮은 순서 -> 가격 높은 순서
		@Override
		public int compareTo(Jewel o) {
			if(this.weight != o.weight) {
				return Integer.compare(this.weight, o.weight);
			}
			
			return Integer.compare(o.price, this.price);
		}	
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		Jewel [] jewels = new Jewel[N];
		int [] bags = new int[K];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());
			jewels[i] = new Jewel(M, V);
		}
		
		for (int i = 0; i < K; i++) {
			bags[i] = Integer.parseInt(br.readLine());
		}
		
		// 보석을 정해진 기준으로 정렬한다.
		Arrays.sort(jewels);
		// 가방을 낮은 무게부터 정렬한다.
		Arrays.sort(bags);
		
		// 비싼 보석을 먼저 꺼내기 위한 pq
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		long ans = 0;
		int idx = 0;
		
		// 작은 가방부터 하나씩 확인한다.
		for (int i = 0; i < K; i++) {
			// 현재 가방에 담을 수 있는 모든 보석을 pq에 넣는다.
			while(idx < N) {
				if(bags[i] < jewels[idx].weight) break;
				
				pq.add(jewels[idx++].price);
			}
			
			// pq에 있는 보석 중 가장 비싼 보석을 1개 꺼내서 ans에 더한다.
			if(!pq.isEmpty()) ans += pq.poll();
		}
		
		System.out.println(ans);
		
	}

}
