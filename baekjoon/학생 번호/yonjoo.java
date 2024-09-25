import java.io.*;
import java.util.*;


public class Main {

    private int solution2(String[] str){
        int answer = 0;

        int len = str[0].length();

        Set<String> set = new HashSet<>();

        for(int i = 0; i < len; i++){
            for(int j = 0; j < str.length; j++){
                set.add(str[j].substring(i));
            }

            if(set.size() == str.length){
                answer = len - i;
            }

            set.clear();
        }

        return answer;
    }


    //왜 안 됨?
    private int solution(String[] str){
        int answer = 0;

        int len = str.length;

        for(int i = 0; i < str[0].length(); i++){
            String st = str[0].substring(i);
            int j;
            for(j = 1; j < len; j++){
                if(str[j].endsWith(st)){
                    break;
                }
            }

            if(j == len) answer = str[0].length() - i;
            else{
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] str = new String[N];

        for(int i = 0; i < N; i++){
            str[i] = br.readLine();
        }

        System.out.println(T.solution2(str));
    }
}
