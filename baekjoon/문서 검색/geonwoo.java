import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 문서 문자열을 저장할 변수
		String str1 = br.readLine();
		// 단어 문자열을 저장할 변수
		String str2 = br.readLine();
		
		int len1 = str1.length();
		int len2 = str2.length();
		
		int ans = 0;
		
		// 0 ~ len1 - len2의 index를 탐색해본다.
		for (int i = 0; i <= len1 - len2; i++) {
			// i번째 글자부터 len2 만큼의 글자가 str2와 같으면 검색하려는 단어를 찾은 것이다.
			if(str1.substring(i, i+len2).equals(str2)) {
				ans++;
				// 중복되면 안되므로 i를 len2-1만큼 더해준다.
				// (루프문을 돌아가면서 자동으로 +1 되기 때문에 -1한 값을 더한다.)
				i += len2-1;
			}
		}
		
		System.out.println(ans);
		
	}

}
