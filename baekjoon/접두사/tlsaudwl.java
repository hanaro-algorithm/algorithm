import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLine();
        }

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s2.length() - s1.length();
            }
        });

        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String now = arr[i];
            boolean isPrefix = false;

            for (int j = 0; j < list.size(); j++) {
                String saved = list.get(j);

                if (saved.startsWith(now)) {
                    isPrefix = true;
                    break;
                }
            }

            if (isPrefix == false) {
                list.add(now);
            }
        }

        System.out.println(list.size());
    }
}
