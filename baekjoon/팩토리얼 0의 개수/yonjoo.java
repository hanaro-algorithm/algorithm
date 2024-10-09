import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        //이진탐색용 변수들
        int lt = 1;
        int rt= num * 5;
        boolean flag = false;


        //이진탐색
        while ( lt <= rt){
            int mid = (lt+rt)/2;
            if( solve(mid) > num){ // 뒤에 붙은 0의 갯수 > num
                rt=mid-1;
            }
            else if(solve(mid) == num){ //찾으면
                rt=mid-1;
                System.out.println(lt);
                return;
            }
            else{
                lt = mid+1;
            }
        }

        System.out.println(-1);

    }

    private static int solve(int mid){
        int count=0;

        for(int i=5; i<=mid; i*=5){
            count+=(mid/i);
        }

        return count;
    }
}
