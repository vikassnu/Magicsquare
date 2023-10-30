import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class HashmapQues {
    public static String getstart(HashMap<String,String> tic){
        HashMap<String,String> revMap = new HashMap<>();
        for(String key:tic.keySet()){
            revMap.put(tic.get(key),key);
        }
        for(String key: tic.keySet()){
            if(!revMap.containsKey(key)){
                return key;
            }
        }
        return "";
    }
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> m = new HashMap<>();
        m.put(0,1);
        int ans=0;
        int sum=0;
        for(int j=0;j<nums.length;j++){
            sum=sum+nums[j];
            if(m.containsKey(sum-k)){
                ans=ans+m.get(sum-k);
            }
            if(m.containsKey(sum)){
                m.put(sum,m.get(sum)+1);
            }
            else{
                m.put(sum,1);
            }
        }
        return ans;
    }
    public static void main(String[] args) {
          HashMap<String,String> ticket = new HashMap<>();
          ticket.put("chennai","bangalore");
          ticket.put("mumbai","delhi");
          ticket.put("goa","chennai");
          ticket.put("delhi", "goa");
          String str = getstart(ticket);
          while(ticket.containsKey(str)){
              System.out.print(str+"-->");
              str = ticket.get(str);
          }
        System.out.print(str);
    }
}
