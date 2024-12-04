import java.util.*;
import java.io.*;

public class Main {

    class DateType{
        int year;
        int month;
        int date;

        DateType(int year, int month, int date){
            this.year = year;
            this.month = month;
            this.date = date;
        }
    }
    class Person{
        String name;
        DateType date;

        Person(String name, int year, int month, int date){
            this.name = name;
            this.date = new DateType(year, month, date);
        }

    }


    private void solution(int n, String[] info){

        List<Person> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            String[] inf = info[i].split(" ");
            String name = inf[0];
            int date = Integer.parseInt(inf[1]);
            int month = Integer.parseInt(inf[2]);
            int year = Integer.parseInt(inf[3]);

            Person newPerson = new Person(name, year, month, date);
            list.add(newPerson);
        }

        list.sort(((o1, o2) -> {
            if(o1.date.year == o2.date.year){
                if(o1.date.month == o2.date.month) return Integer.compare(o1.date.date, o2.date.date);
                return Integer.compare(o1.date.month, o2.date.month);
            }
            return Integer.compare(o1.date.year, o2.date.year);
        }));

        System.out.println(list.get(list.size()-1).name);
        System.out.println(list.get(0).name);
    }
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        String[] info = new String[n];
        for(int i = 0; i < n; i++){
            info[i] = br.readLine();
        }

        T.solution(n, info);
    }
}