import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_G5_3020_개똥벌레 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		
		int [] seok = new int[H+2];
		int [] jong = new int[H+2];
		
		for (int i = 0; i < N; i += 2) {
			int n1 = Integer.parseInt(br.readLine());
			int n2 = Integer.parseInt(br.readLine());
			
			seok[n1]++;
			jong[n2]++;
		}
		
		for (int i = H-1; i > 0; i--) {
			seok[i] += seok[i+1];
			jong[i] += jong[i+1];
		}
		
		int cnt = 0;
		int min = N;
		
		for (int i = 1; i <= H; i++) {
			if(seok[i] + jong[H-i+1] < min) {
				cnt = 1;
				min = seok[i] + jong[H-i+1];
			} else if(seok[i] + jong[H-i+1] == min) {
				cnt++;
			}
		}
		
		System.out.println(min+" "+cnt);
		
	}

}
