import java.util.Scanner;

public class Min_Bus_stand_time {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();// test case
        for(int i=0;i<t;i++){
            int n = sc.nextInt();// no. of buses
            String[] bus_arr = new String[n];
            String[] bus_dep = new String[n];
            for(int j=0;j<n;j++){
                bus_arr[j]=sc.next();
                bus_dep[j]=sc.next();
            }
            String arrival = sc.next();
            System.out.println(Solution(bus_arr,bus_dep,arrival));
        }
        /*
        String bus_arr[] = {"11:12:45am","10:12:40am","07:12:56am"};
        String bus_dep[] ={"12:34:56pm","02:34:56pm","09:34:56am"};
        String arrival = "09:20:56am";
        System.out.println(Solution(bus_arr,bus_dep,arrival));*/

    }
    public static double Solution(String[] bus_arr,String bus_dep[],String arrival){
        double ans=1500;
        for(int i=0;i<bus_arr.length;i++){
            double arr_time = time(bus_arr[i]);
            double dep_time = time(bus_dep[i]);
            double usr_time = time(arrival);
            if(usr_time<=dep_time && (usr_time-arr_time<=120)){
                ans = Math.min(ans,dep_time-usr_time);
            }
        }
        if(ans==1500) return -1;
        return ans;
    }
    public static double time(String str){
        int hr = (((str.charAt(0)-'0')*10)+ (str.charAt(1)-'0'));
        int min = (((str.charAt(3)-'0')*10)+ (str.charAt(4)-'0'));
        double sec = (((double) (str.charAt(6)-'0')*10)+ (double) (str.charAt(7)-'0'))/60;
        if(str.charAt(8)=='p' && hr==12) return 720+(double) min+sec;
        else if(str.charAt(8)=='p') return ((double) (hr) + 12)*60 + (double) min + sec;
        else return ((double) hr)*60 +(double) min+sec;
    }
}
