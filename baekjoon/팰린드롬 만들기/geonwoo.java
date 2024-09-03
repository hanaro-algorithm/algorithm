import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_S3_1213_팰린드롬만들기 {

   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      String str = br.readLine();
      
      // A~Z 문자가 몇 개씩 있는지를 저장할 배열
      int [] cnt = new int[26];
      
      for (int i = 0; i < str.length(); i++) {
    	 // 각 글자의 카운트를 알맞은 인덱스에 넣어준다.
         char c = str.charAt(i);
         cnt[c - 'A']++;
      }
      
      // 팰린드롬을 만들 수 있는지 여부를 저장할 변수
      boolean isOK = true;
      // 팰린드롬의 가운데에는 1개의 문자만 올 수 있는데, 가운데에 올 문자가 정해졌는지 여부를 저장할 변수
      boolean used = false;
      // 가운데에 올 문자열을 저장할 변수
      char mid = ' ';
      StringBuilder sb = new StringBuilder();
      
      for (int i = 0; i < 26; i++) {
         char c = (char) (i + 'A');
         
         // i번째 문자가 홀수갤라면, 해당 문자는 반드시 가운데 문자열로 사용해야한다.
         if(cnt[i] % 2 != 0) {
        	// 이미 가운데 문자를 사용했다면, 팰린드롬을 만들 수 없다. 
            if(used) {
               isOK = false;
               break;
            }
            
            // 아직 사용하지 않았다면 사용 처리를 하고, 가운데 문자를 정한다.
            used = true;
            mid = c;
            
         }
         
         // 사전에서 가장 먼저 와야하므로, A부터 Z까지 순서대로 StringBuilder에 담는다.
         for (int j = 0; j < cnt[i] / 2; j++) {
            sb.append(c);
         }

      }
      
      // 팰린드롬을 만들 수 없다면 문구를 출력하고 바로 종료한다.
      if(!isOK) {
         System.out.println("I'm Sorry Hansoo");
         System.exit(0);
      }
      
      // 만들 수 있다면 팰린드롬 문자열을 완성한다. (sb - mid - sb.reverse())
      StringBuilder ans = new StringBuilder(sb);
      if(used) ans.append(mid);
      ans.append(sb.reverse().toString());
      
      System.out.println(ans.toString());
      
   }

}