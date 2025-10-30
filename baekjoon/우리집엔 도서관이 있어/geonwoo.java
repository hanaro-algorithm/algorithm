import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_S1_2872_우리집엔도서관이있어 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int [] arr = new int[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		int idx = N;
		int ans = 0;
		
		for (int i = idx-1; i >= 0; i--) {
			if(arr[i] == idx) {
				idx--;
			} else {
				ans++;
			}
		}
		
		System.out.println(ans);
		
	}

}
