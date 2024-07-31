import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();
        int size1 = s1.length();
        int size2 = s2.length();

        s1 = s1.replace(s2, "");
        System.out.println((size1 - s1.length()) / size2);
    }
}