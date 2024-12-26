import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S3_16508_전공책 {
	static int N, min;
	static int [] word;
	static Book [] books;
	
	static class Book {
		int price;
		String name;
		
		public Book(int price, String name) {
			this.price = price;
			this.name = name;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		word = new int[26];
		
		String str = br.readLine();
		for (int i = 0; i < str.length(); i++) {
			word[str.charAt(i)-'A']++;
		}
		
		N = Integer.parseInt(br.readLine());
		books = new Book[N];
		min = Integer.MAX_VALUE;
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int price = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			
			books[i] = new Book(price, name);
		}
		
		dfs(0, 0);
		
		if(min == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(min);
		
	}

	private static void dfs(int idx, int sum) {
		if(idx == N) {
			for (int i = 0; i < 26; i++) {
				if(word[i] > 0) return;
			}
			
			min = Math.min(min, sum);
			
			return;
		}
		
		dfs(idx+1, sum);
		
		int price = books[idx].price;
		String name = books[idx].name;
			
		for (int j = 0; j < name.length(); j++) {
			word[name.charAt(j)-'A']--;
		}
		
		dfs(idx+1, sum+price);
			
		for (int j = 0; j < name.length(); j++) {
			word[name.charAt(j)-'A']++;
		}
	}

}
