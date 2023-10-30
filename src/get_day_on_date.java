import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class get_day_on_date {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter date to get day");

        Map<Integer,Integer> year = new HashMap<>();
        Map<String,Integer> month = new HashMap<>();
        Map<Integer,String> days = new HashMap<>();

        days.put(0,"Sunday");days.put(1,"Monday");
        days.put(2,"Tuesday");days.put(3,"Wednesday");
        days.put(4,"Thursday");days.put(5,"Friday");days.put(6,"Saturday");

        year.put(0,6);year.put(1,4);year.put(2,2);year.put(3,0);

        month.put("jan",0);month.put("feb",3);month.put("mar",3);month.put("apr",6);
        month.put("may",1);month.put("jun",4);month.put("jul",6);month.put("aug",2);
        month.put("sep",5);month.put("oct",0);month.put("nov",3);month.put("dec",5);

        boolean exit=false;
        while (!exit){
            System.out.println("enter date: __,starting 3 letter,____");
            String str = sc.next();
            char ch1 = str.charAt(2);
            char ch2 = str.charAt(3);
            char ch3 = str.charAt(4);
            StringBuilder sb = new StringBuilder("");
            sb.append(ch1);
            sb.append(ch2);
            sb.append(ch3);
            int t = (((str.charAt(0)-'0')*10 + (str.charAt(1)-'0'))+
                    (month.get(sb.toString()))
                    +(year.get(((str.charAt(6)-'0')*10 + (str.charAt(7)-'0'))%4))+
                    ((str.charAt(8)-'0')*10 + (str.charAt(9)-'0'))+
                    ((str.charAt(8)-'0')*10 + (str.charAt(9)-'0'))/4)%7;
            System.out.println(days.get(t));
            System.out.println("want to try more press : y or press anything to exit");
            String ext = sc.next();
            if(ext=="y") exit=true;
        }

    }

}
