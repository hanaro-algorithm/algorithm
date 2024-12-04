import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String a = br.readLine();
        String b = br.readLine();

        String aSub = a.repeat(100/a.length() + 1).substring(0, 101);
        String bSub = b.repeat(100/b.length() + 1).substring(0, 101);

        if(aSub.equals(bSub)){

            System.out.println(1);
        }
        else{
            System.out.println(0);
        }

    }
}