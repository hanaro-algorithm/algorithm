import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_G4_1253_좋다 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int [] arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int ans = 0;
		
		outer:
			for (int i = 0; i < N; i++) {
				int num = arr[i];
				
				int left = 0;
				int right = N-1;
				
				if(left == i) left++;
				if(right == i) right--;
				
				while(left < right) {
					if(arr[left] + arr[right] > num) {
						if(--right == i) right--;
					} else if(arr[left] + arr[right] < num) {
						if(++left == i) left++;
					} else {
						ans++;
						continue outer;
					}
				}
			}
		
		System.out.println(ans);
		

	}

}
