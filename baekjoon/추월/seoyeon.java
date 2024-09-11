import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Queue<String> inCar = new LinkedList<>();      // 들어간 차
        for(int i = 0; i < n; i++) {
            inCar.add(br.readLine());
        }

        Queue<String> out = new LinkedList<>();     // 나간 차
        for(int i = 0; i < n; i++) {
            out.add(br.readLine());
        }

        int answer = 0;

        while(!out.isEmpty()) {
            String outCar = out.poll();
            if(!inCar.peek().equals(outCar)) {
                answer++;
                inCar.remove(outCar);
            } else {
                inCar.poll();
            }
        }

        System.out.println(answer);
        br.close();
    }
}