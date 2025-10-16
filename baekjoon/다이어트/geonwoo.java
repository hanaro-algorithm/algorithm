import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ_G5_1484_다이어트 {
    public static void main(String[] args) {
        Scanner scann = new Scanner(System.in);

        int G = scann.nextInt();
        int max = (G+1)/2;

        List<Integer> list = new ArrayList<Integer>();

        int left = 1;
        int right = 1;

        while(left < max) {
            int diff = right*right - left*left;

            if(diff == G) {
                list.add(right);
                left++;
                right++;
            } else if(diff > G) {
                left++;
            } else {
                if(right == max) break;
                right++;
            }
        }

        if(list.isEmpty()) {
            System.out.println(-1);
        } else {
            StringBuilder sb = new StringBuilder();

            for(int n : list) {
                sb.append(n).append("\n");
            }

            System.out.println(sb.toString());
        }

    }
}