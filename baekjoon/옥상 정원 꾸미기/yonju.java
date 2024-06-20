import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.parseInt(br.readLine());

        List<Integer> arr = new ArrayList<>();
        for(int i = 0; i < n; i++){
            arr.add(Integer.parseInt(br.readLine()));
        }


        Integer ans = 0;
        for(int i = 0; i < n-1; i++){
            Integer pivot = arr.get(i);
            Integer count = 0;
            for(int j = i + 1; j < n; j++ ){
                if(arr.get(j) >= pivot){
                    break;
                }
                count += 1;
            }
            ans += count;
        }

        System.out.println(ans);

    }
}
