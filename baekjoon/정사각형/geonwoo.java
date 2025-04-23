import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_S3_1485_정사각형 {
	static int [][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		testcase:
			for (int t = 0; t < N; t++) {
				arr = new int[4][2];
				
				for (int i = 0; i < 4; i++) {
					StringTokenizer st = new StringTokenizer(br.readLine());
					
					arr[i][0] = Integer.parseInt(st.nextToken());
					arr[i][1] = Integer.parseInt(st.nextToken()); 
				}
				
				double [] len = new double[6];
				int idx = 0;
				
				for (int i = 0; i < 3; i++) {
					for (int j = i+1; j < 4; j++) {
						len[idx++] = cal(i, j);
					}
				}
				
				Arrays.sort(len);
				
				for (int i = 1; i <= 3; i++) {
					if(len[0] != len[i]) {
						sb.append(0+"\n");
						continue testcase;
					}
				}
				
				if(len[4] != len[5]) {
					sb.append(0+"\n");
					continue testcase;
				}
				
				sb.append(1+"\n");
				
			}
		
		sb.setLength(sb.length()-1);
		System.out.println(sb.toString());
		
	}

	private static double cal(int p1, int p2) {
		int dx = arr[p1][0] - arr[p2][0];
		int dy = arr[p1][1] - arr[p2][1];
		
		double dist = Math.sqrt(dx*dx + dy*dy);
		
		return dist;
	}

}
