import java.util.*;
import java.io.*;

public class Main {

    class Info {
        int pay;
        int shifting;

        Info(int pay, int shifting){
            this.pay = pay;
            this.shifting = shifting;
        }
    }

    public int solution(int n, String[] info){


        List<Info> list = new ArrayList<>();

        for(int i = 0; i < n; i++){
            String[] priceInfo = info[i].split(" ");

            Info info1 = new Info(Integer.parseInt(priceInfo[0]), Integer.parseInt(priceInfo[1]));
            list.add(info1);
        }


        //안 해도 될것 같긴 함
        list.sort(((o1, o2) -> Integer.compare(o1.pay, o2.pay)));

        int maxPrice = 0;
        int minMaxPay = Integer.MAX_VALUE;
        for(Info i : list){
            int curr = i.pay;

            int sum = 0;

            for(Info in : list){
                if(in.pay >= curr && (curr - in.shifting) > 0){
                    sum += (curr - in.shifting);
                }
            }

            if(sum == 0){
                return 0;
            }

            if( maxPrice == sum){
                minMaxPay = Math.min(minMaxPay, curr);
            }
            else if(maxPrice < sum){
                maxPrice = sum;
                minMaxPay = curr;
            }
        }

        return minMaxPay == Integer.MAX_VALUE ? 0 : minMaxPay;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        String[] info = new String[n];

        for(int i = 0; i < n; i++){
            info[i] = br.readLine();
        }

        System.out.println(T.solution(n, info));

    }
}