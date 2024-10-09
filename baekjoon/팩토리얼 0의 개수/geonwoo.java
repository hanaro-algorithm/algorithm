import java.util.Scanner;

public class BOJ_S1_11687_팩토리얼0의개수 {

   public static void main(String[] args) {
      Scanner scann = new Scanner(System.in);
      
      int M = scann.nextInt();
      
      // 0의 개수가 1개인 것은 10의 배수, 2개인 것은 100의 배수를 의미한다.
      // 10의 배수는 2*5, 100의 배수는 2^2*5^2이다. 따라서, 0의 개수는 2*5의 개수를 의미한다.
      // 2의 개수는 5의 개수에 비해 항상 많으므로, 특정한 수의 끝 0의 개수는 5가 몇번 곱해졌는지 찾으면 된다.
      // 이분탐색을 사용해서 범위 내의 조건을 만족하는 가장 작은 값을 찾는다.
      int left = 1;
      int right = M*5;
      int mid = 0;
      // 한 번이라도 만족하는 수를 찾은 적이 있는지 저장할 변수
      boolean find = false;
      
      while(left <= right) {
         mid = (left + right) / 2;
         
         // mid 숫자의 5의 배수의 개수를 저장할 변수
         int cnt = check(mid);
         
         // 0의 개수가 더 많다면 수를 낮춘다.
         if(M < cnt) {
            right = mid-1;
         // 0의 개수가 더 많다면 수를 높인다.
         } else if(M > cnt) {
            left = mid+1;
         // 0의 개수가 같은 값을 찾았더라도 가장 작은 값을 찾을 때까지 반복한다.
         // flag는 true 처리 해준다.
         } else {
            find = true;
            right = mid-1;
         }
      }
      
      // 한 번이라도 찾았으면, 그 중 가장 작은 수를 출력한다.
      if(find) {
         System.out.println(left);
      } else {
         System.out.println(-1);
      }

   }

   // 숫자 n에 대해서 5가 몇번 곱해졌는지 확인하는 함수
   private static int check(int n) {
      int sum = 0;
      
      for (int i = 5; i <= n; i*=5) {
         sum += (n/i);
      }
      
      return sum;
   }

}
