import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_G5_14719_빗물 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		
		int [] block = new int[W];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < W; i++) {
			block[i] = Integer.parseInt(st.nextToken());
		}
		
		int left = 0;
		int leftIdx = -1;
		boolean flag = false;
		int ans = 0;
		int sum = 0;
		
		for (int i = 0; i < W; i++) {
			int n = block[i];
			
			if(left > n) {
				flag = true;
				
				sum += left-n;
			} else if(left <= n) {
				if(flag) {
					ans += sum;
					sum = 0;
					flag = false;
				}
				
				left = n;
				leftIdx = i;
			}
		}
		
		if(flag) {
			flag = false;
			int right = 0;
			sum = 0;
			
			for (int i = W-1; i >= leftIdx; i--) {
				int n = block[i];
				
				if(right > n) {
					flag = true;
					
					sum += right-n;
				} else if(right <= n) {
					if(!flag) {
						right = n;
					} else {
						ans += sum;
						sum = 0;
						right = n;
						flag = false;
					}
				}
			}
		}
		
		System.out.println(ans);
		
	}

}
