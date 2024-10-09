import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        int lt = 1;
        int rt= num * 5;
        boolean flag = false;
        
        while ( lt <= rt){
            int mid = (lt+rt)/2;
            if( solve(mid) > num){
                rt=mid-1;
            } else if(solve(mid)== num){
                rt=mid-1;
                flag=true;
            }
            else{
                lt = mid+1;
            }
        }

        if(flag){
            System.out.println(lt);
        }else{
            System.out.println(-1);
        }
    }

    private static int solve(int mid){
        int count=0;

        for(int i=5; i<=mid; i*=5){
            count+=(mid/i);
        }

        return count;
    }
}
