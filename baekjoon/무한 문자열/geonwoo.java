import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_S5_12871_무한문자열 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		String t = br.readLine();
		
		StringBuilder sb1 = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		
		for (int i = 0; i < t.length(); i++) {
			sb1.append(s);
		}
		
		for (int i = 0; i < s.length(); i++) {
			sb2.append(t);
		}
		
		if(sb1.toString().equals(sb2.toString())) System.out.println(1);
		else System.out.println(0);
		
	}

}
