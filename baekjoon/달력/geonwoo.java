import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_G5_20207_달력 {

   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      int N = Integer.parseInt(br.readLine());
      // 해당 날짜에 일정이 몇개있는지 저장할 배열
      int [] days = new int[366];
      
      for (int i = 0; i < N; i++) {
         StringTokenizer st = new StringTokenizer(br.readLine());
         
         int start = Integer.parseInt(st.nextToken());
         int end = Integer.parseInt(st.nextToken());
         
         // 시작 날짜부터 끝 날짜까지 days 배열을 채워준다.
         for (int j = start; j <= end; j++) {
            days[j]++;
         }
      }
      
      int ans = 0;
      // 직사각형의 세로 길이 = 같은 그룹 내 날짜의 일정 개수 중 최댓값
      // 직사각형의 가로 길이 = 연속 일정의 개수(일정의 개수가 0이 되면 계산함)
      int width = 0;
      int height = 0;
      
      for (int i = 0; i <= 365; i++) {
         // 일정의 개수가 0이 아니라면 이전 그룹과 이어져있다.
         // 가로 길이를 +1 늘려주고, 최대 높이를 갱신한다.
         if(days[i] != 0) {
            width++;
            height = Math.max(height, days[i]);
         // 일정의 개수가 0이라면 그룹이 나눠지므로 직사각형의 길이를 계산한다.
         } else {
            ans += width * height;
            width = 0;
            height = 0;
         }
      }
      
      // 마지막 날짜까지 일정이 채워져있을 수 있으므로 한 번 더 계산해준다.
      ans += width * height;
      
      System.out.println(ans);

   }

}
