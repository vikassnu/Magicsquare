import java.util.HashSet;
import java.util.Iterator;
// unordered
public class Hashsetvk {
    public static void main(String[] args) {
        // create
        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(1);
        // search
        if(set.contains(1)){
            System.out.println("found");
        }
        //delete
        set.remove(1);
        if(!set.contains(1)){
            System.out.println("element 1 is removed");
        }
        System.out.println("size of set: "+set.size());
        System.out.println(set);//print all element
        //iterator
        Iterator it = set.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }

    }
}
