import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BOJ_S3_1431_시리얼번호 {
	static class Guitar implements Comparable<Guitar> {
		String str;
		int sum;
		
		public Guitar(String str, int sum) {
			this.str = str;
			this.sum = sum;
		}

		@Override
		public int compareTo(Guitar o) {
			if(this.str.length() != o.str.length()) {
				return Integer.compare(this.str.length(), o.str.length());
			} else if(this.sum != o.sum) {
				return Integer.compare(this.sum, o.sum);
			}
			
			return this.str.compareTo(o.str);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		List<Guitar> list = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			int sum = 0;
			
			for (int j = 0; j < str.length(); j++) {
				char c = str.charAt(j);
				
				if(c >= '0' && c <= '9') {
					sum += c - '0';
				}
			}
			
			list.add(new Guitar(str, sum));
		}
		
		Collections.sort(list);
		
		StringBuilder sb = new StringBuilder();
		
		for(Guitar g : list) {
			sb.append(g.str+"\n");
		}
		
		if(sb.length() > 0) sb.setLength(sb.length()-1);
		System.out.println(sb.toString());
	}

}
