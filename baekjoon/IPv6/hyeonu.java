import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] arr = input.split("::");
        String[] arr0 = arr[0].split(":");
        StringBuilder sb = new StringBuilder();
        sb.append(zero(arr0));
        if (arr.length > 1) {
            sb.append(":");
            String[] arr1 = arr[1].split(":");
            for(int i = 0; i < 8 - (arr0.length + arr1.length); i++){
                sb.append("0000:");
            }
            sb.append(zero(arr1));
        }
        if (input.substring(input.length() - 2).equals("::")) {
            sb.append(":");
            for(int i = 0; i < 8 - arr0.length; i++){
                sb.append("0000:");
            }
            sb.delete(sb.length()-1, sb.length());
        }
        System.out.println(sb);
    }
    static String zero(String[] arr) {
        StringBuilder sb = new StringBuilder();
        for (String str : arr) {
            for(int i = 0; i < 4-str.length(); i++){
                sb.append("0");
            }
            sb.append(str).append(":");
        }
        return sb.delete(sb.length()-1, sb.length()).toString();
    }
}