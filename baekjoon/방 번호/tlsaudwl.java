import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String roomNumber = sc.next();

        int[] count = new int[10];

        for (int i = 0; i < roomNumber.length(); i++) {
            int num = roomNumber.charAt(i) - '0';
            count[num]++;
        }

        int sixNine = count[6] + count[9];
        int sixNineSet = (sixNine + 1) / 2; // 올림 처리

        count[6] = count[9] = sixNineSet; // 6과 9 자리에 같은 개수로 반영

        int max = 0;
        for (int i = 0; i < 9; i++) {
            if (count[i] > max) {
                max = count[i];
            }
        }

        System.out.println(max);
    }
}
