import java.io.*;
import java.util.*;

// 마지막줄 reader 작동 안 함
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int absDiff = Math.abs(o1) - Math.abs(o2);
                if (absDiff == 0) {
                    return o1 - o2;
                }
                return absDiff;
            }
        });

        for(int i = 0; i < n; i++) {
            Integer x = Integer.parseInt(br.readLine());

            if(x == 0){
                if(pq.isEmpty()) {
                    System.out.println(0);
                } else {
                    System.out.println(pq.poll());
                }
            } else {
                pq.add(x);
            }
        }
    }
}
