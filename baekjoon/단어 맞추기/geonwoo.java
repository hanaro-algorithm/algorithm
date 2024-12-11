import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_S1_9081_단어맞추기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			String str = br.readLine();
			char [] arr = str.toCharArray();
			
			int idx1 = -1;
			
			for (int i = arr.length-1; i > 0; i--) {
				char c1 = arr[i-1];
				char c2 = arr[i];
				
				if(c2 > c1) {
					idx1 = i-1;
					break;
				}
			}
			
			if(idx1 == -1) {
				sb.append(str+"\n");
				continue;
			}
			
			int idx2 = -1;
			
			for (int i = arr.length-1; i >= 0; i--) {
				char c = arr[i];
				if(c > arr[idx1]) {
					idx2 = i;
					break;
				}
			}
			
			char tmp = arr[idx1];
			arr[idx1] = arr[idx2];
			arr[idx2] = tmp;
			
			Arrays.sort(arr, idx1+1, arr.length);
			
			sb.append(String.valueOf(arr)+"\n");
		}
		
		sb.setLength(sb.length()-1);
		System.out.println(sb.toString());
		
	}

}
