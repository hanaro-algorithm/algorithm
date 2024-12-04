import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        String[] name = new String[n];
        int[] day = new int[n];
        int[] month = new int[n];
        int[] year = new int[n];

        for(int i=0;i<n;i++){
            name[i] = scan.next();
            day[i] = scan.nextInt();
            month[i] = scan.nextInt();
            year[i] = scan.nextInt();
        }

        int old = 0;
        int young = 0;

        for (int i = 1; i < n; i++) {
            if (year[i] < year[old] ||
                    (year[i] == year[old] && month[i] < month[old]) ||
                    (year[i] == year[old] && month[i] == month[old] && day[i] < day[old])) {
                old = i;
            }


            if (year[i] > year[young] ||
                    (year[i] == year[young] && month[i] > month[young]) ||
                    (year[i] == year[young] && month[i] == month[young] && day[i] > day[young])) {
                young = i;
            }
        }

        System.out.println(name[young]);
        System.out.println(name[old]);
    }
}