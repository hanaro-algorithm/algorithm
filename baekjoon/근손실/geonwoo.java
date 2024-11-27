import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S3_18429_근손실 {
	static int N, K, sum;
	static int [] kit;
	static boolean [] used;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		// 운통 키트의 중량을 저장할 배열
		kit = new int[N];
		// 사용한 키트인지 여부를 저장할 배열
		used = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			kit[i] = Integer.parseInt(st.nextToken());
		}
		
		// 순열을 사용해 경우의수를 확인한다.
		perm(0, 500);
		
		// 전체에서 불가능한 경우의 수를 뺀다.
		int total = 1;
		for (int i = 2; i <= N; i++) {
			total *= i;
		}
		
		System.out.println(total - sum);
		
	}

	private static void perm(int depth, int weight) {
		if(weight < 500) {
			int remain = 1;
			
			for (int i = 1; i <= N - depth; i++) {
				remain *= i;
			}
			
			sum += remain;
			
			return;
		}
		
		if(depth == N) return;
		
		for (int i = 0; i < N; i++) {
			if(used[i]) continue;
			
			used[i] = true;
			
			perm(depth+1, weight+kit[i]-K);
			
			used[i] = false;
		}
		
	}

}
