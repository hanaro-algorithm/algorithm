import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S3_2503_숫자야구 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int [][] arr = new int[N][5];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			
			arr[i][0] = num / 100;
			arr[i][1] = (num - arr[i][0] * 100) / 10;
			arr[i][2] = num % 10;
			arr[i][3] = Integer.parseInt(st.nextToken());
			arr[i][4] = Integer.parseInt(st.nextToken());
		}
		
		int ans = 0;
		
		for (int i = 1; i <= 9; i++) {
			for (int j = 1; j <= 9; j++) {
				if(i == j) continue;
				
				outer:
					for (int k = 1; k <= 9; k++) {
						if(i == k || j == k) continue;
						
						for (int l = 0; l < N; l++) {
							int strike = 0;
							int ball = 0;
							
							if(i == arr[l][0]) strike++;
							if(i == arr[l][1] || i == arr[l][2]) ball++;
							
							if(j == arr[l][1]) strike++;
							if(j == arr[l][0] || j == arr[l][2]) ball++;
							
							if(k == arr[l][2]) strike++;
							if(k == arr[l][0] || k == arr[l][1]) ball++;
							
							if(strike != arr[l][3] || ball != arr[l][4]) continue outer;
						}
						
						ans++;
					}
			}
		}
		
		System.out.println(ans);
		
	}

}
