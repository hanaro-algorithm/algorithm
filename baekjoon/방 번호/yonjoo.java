import java.util.*;
import java.io.*;

public class Main {


    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();


        int[] numbers = new int[10];

        char[] input = br.readLine().toCharArray();

        for(char c : input){
            if(c == '6' || c == '9' ) continue;
            int num = Integer.parseInt(c + "");
            numbers[num]++;
        }

        //최댓값 찾기
        int max = 0;
        for(int i = 0; i < 9; i++){
            max = Math.max(numbers[i], max);
        }

        // 나누기 들어가는건 항상 짝수 홀수일 경우 나눠서 생각해야겠다
        int ns = (int)Math.ceil(((double)numbers[6] + numbers[9])/2);//9랑 6 갯수 더해서 2로 나눈 값

        //6이랑 9 다 합해도 최댓값보다 작을 경우
        if(max >= ns){
            sb.append(max);
        }
        else {
            // 6이랑 9 적절히 잘 나누면 해결 될 경우
            if(max == 0){
                
            }
            if(max >= ns){
                sb.append(max);
            }
            // 6이랑 9 혼용해도 더 사야하는 경우
            else sb.append(ns);
        }

        System.out.println(sb.toString().trim());

    }
}