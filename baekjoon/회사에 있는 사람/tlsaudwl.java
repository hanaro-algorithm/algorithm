import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        //ArrayList<String> employees = new ArrayList<>(); -> 시간초과
        HashSet<String> employees = new HashSet<>();

        for (int i = 0; i < n; i++) {
            String record = sc.nextLine();
            String[] parts = record.split(" ");

            String name = parts[0];
            String action = parts[1];

            if (action.equals("enter")) {
                employees.add(name);
            } else {
                employees.remove(name);
            }
        }

        ArrayList<String> sortedList = new ArrayList<>(employees);
        Collections.sort(sortedList, Collections.reverseOrder());

        for (String name : sortedList) {
            System.out.println(name);
        }
    }
}
