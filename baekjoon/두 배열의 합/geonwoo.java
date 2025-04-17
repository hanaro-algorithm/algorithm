import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_G3_2143_두배열의합 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		int N = Integer.parseInt(br.readLine());
		int [] a = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		int M = Integer.parseInt(br.readLine());
		int [] b = new int[M];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++) {
			b[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 1; i < N; i++) {
			a[i] += a[i-1];
		}
		
		for(int i = 1; i < M; i++) {
			b[i] += b[i-1];
		}
		
		int aSize = N*(N+1) / 2;
		long [] aSum = new long[aSize];
		int idx = 0;
		
		for(int i = 0; i < N; i++) {
			for(int j = i; j < N; j++) {
				int right = a[j];
					
				if(i > 0) right -= a[i-1];
				aSum[idx++] = right;
			}
		}
		
		int bSize = M*(M+1) / 2;
		
		long [] bSum = new long[bSize];
		idx = 0;
		
		for(int i = 0; i< M; i++) {
			for(int j = i; j < M; j++) {
				int right = b[j];
				
				if(i > 0) right -= b[i-1];
				bSum[idx++] = right;
			}
		}
		
		Arrays.sort(aSum);
		Arrays.sort(bSum);
		
		int left = 0;
		int right = bSize - 1;
		long ans = 0;

		while(left < aSize && right > -1) {
			long a1 = aSum[left];
			long b1 = bSum[right];
			long sum = a1 + b1;
			
			if(sum == T) {
				long a2 = 0;
				long b2 = 0;
				
				while(left < aSize && a1 == aSum[left]) {
					left++;
					a2++;
				}
			
				while(right > -1 && b1 == bSum[right]) {
					right--;
					b2++;
				}
				
				ans += a2*b2;
			}
			
			if (sum > T) {
				right--;
			} else if (sum < T) {
				left++;
			}
		}
		
		System.out.println(ans);
		
	}
}