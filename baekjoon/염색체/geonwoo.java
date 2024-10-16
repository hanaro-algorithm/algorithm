import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_S3_9342_염색체 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		// 문제의 조건을 만족하는 정규표현식
		String pattern = "^[A-F]?A+F+C+[A-F]?$";
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			
			// str이 정규표현식을 만족하면 Infected!를 출력, 아니라면 Good을 출력한다.
			if(str.matches(pattern)) {
				sb.append("Infected!\n");
			} else {
				sb.append("Good\n");
			}
		}
		
		if(sb.length() > 0) sb.setLength(sb.length()-1);
		System.out.println(sb.toString());
		
	}

}
