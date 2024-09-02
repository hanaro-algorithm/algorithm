import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int len = input.length();

        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < len; i++){
            map.put(input.charAt(i), map.getOrDefault(input.charAt(i), 0) + 1);
        }
        List<Character> list = new LinkedList<>(map.keySet()); // 정렬 위해 list로
        Collections.sort(list);

        int oddn = 0; // 홀수 몇 개?
        char oddc = '\0'; // 해당하는 홀수 char
        for(int i = 0; i < list.size(); i++){
            if(map.get(list.get(i)) % 2 != 0){ // 홀수라면
                if(oddn == 1){ // 홀수 1개 초과
                    System.out.println("I'm Sorry Hansoo");
                    return;
                }else{
                    oddn++;
                    oddc = list.get(i); // 해당하는 유일한 홀수 문자
                }
            }
        }

        char[] ans = new char[len];
        int idx = 0;

        if(len % 2 == 0) { // 길이 짝수
            if (oddn > 0) { // 홀수 글자 있으면
                System.out.println("I'm Sorry Hansoo");
            }
            for(int i = 0; i < list.size(); i++){
                for(int j = 0; j < map.get(list.get(i))/2; j++){
                    ans[idx] = list.get(i);
                    ans[len-1-idx] = list.get(i);
                    idx++;
                }
            }
        }else{ // 길이 홀수
            map.put(oddc, map.get(oddc) - 1); // 가운데 넣기 위해 개수-1
            ans[len/2] = oddc; // 가운데 유일 홀수 문자
            for(int i = 0; i < list.size(); i++){
                for(int j = 0; j < map.get(list.get(i))/2; j++){
                    ans[idx] = list.get(i);
                    ans[len-1-idx] = list.get(i);
                    idx++;
                }
            }
        }

        System.out.println(ans);
    }
}
