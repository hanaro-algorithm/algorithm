import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_S5_1652_누울자리를찾아라 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		char [][] map = new char[N][N];
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		int c = 0;
		int r = 0;
		
		for (int i = 0; i < N; i++) {
			int cnt = 0;
			for (int j = 0; j < N; j++) {
				if(map[i][j] == '.') cnt++;
				else {
					if(cnt >= 2) c++;
					cnt = 0;
				}
			}
			if(cnt >= 2) c++;
		}
		
		for (int i = 0; i < N; i++) {
			int cnt = 0;
			for (int j = 0; j < N; j++) {
				if(map[j][i] == '.') cnt++;
				else {
					if(cnt >= 2) r++;
					cnt = 0;
				}
			}
			if(cnt >= 2) r++;
		}
		
		System.out.println(c+" "+r);
		
	}

}