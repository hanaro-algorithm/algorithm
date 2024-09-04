import java.io.*;
import java.util.*;


public class Main {

    // String solution(String str){

    //     char[] chars = str.toCharArray();
    //     Arrays.sort(chars);

    //     int[] alphabets = new int[26];
    //     int cnt = 1;
    //     int odd = -1;
    //     for(int p = 1; p < chars.length; p++){
    //         if(chars[p-1] == chars[p]){
    //             cnt++;
    //         }
    //         else{
    //             alphabets[chars[p-1] - 'A'] = (int)Math.ceil((double)cnt/2);
    //             if(cnt%2 == 1){
    //                 if(odd != -1) return "I'm Sorry Hansoo";
    //                 odd = chars[p-1] - 'A';
    //                 alphabets[odd] -= 1;
    //             }
    //             alphabets[chars[p-1] - 'A'] = (int)Math.ceil((double)cnt/2);
    //             cnt = 1;
    //         }
    //     }

    //     if(cnt%2 == 1){
    //         if(odd != -1) return "I'm Sorry Hansoo";
    //         odd = chars[chars.length-1] - 'A';
    //     }
    //     alphabets[chars[chars.length-1] - 'A'] = (int)Math.ceil((double)cnt/2);



    //     StringBuilder ans = new StringBuilder();
    //     String answer = "";
    //     for(int i = 0; i < 26; i++){
    //         if(i == odd && alphabets[i] == 1) continue;
    //         for(int j = 0; j < alphabets[i]; j++){
    //             ans.append((char)(i + 'A'));
    //         }
    //     }

    //     answer += ans.toString();
    //     if(odd != -1){
    //         answer += (char)(odd + 'A');
    //     }

    //     answer += ans.reverse().toString();
    //    return answer;
    // }

    String solution(String str){
        int[] alphabets = new int[26];

        // 알파벳 빈도수 계산
        for (char c : str.toCharArray()) {
            alphabets[c - 'A']++;
        }

        int oddCount = 0;
        char oddChar = 0;

        // 홀수 개수인 알파벳 찾기
        for (int i = 0; i < 26; i++) {
            if (alphabets[i] % 2 != 0) {
                oddCount++;
                oddChar = (char) (i + 'A');
            }
        }

        if (oddCount > 1) {
            return "I'm Sorry Hansoo";
        }

        // 앞쪽 반을 만듦
        StringBuilder half = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < alphabets[i] / 2; j++) {
                half.append((char) (i + 'A'));
            }
        }


        StringBuilder answer = new StringBuilder(half);
        if (oddCount == 1) {
            answer.append(oddChar);
        }
        answer.append(half.reverse().toString());

        return answer.toString();
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();

        System.out.println(T.solution(str));


    }
}
