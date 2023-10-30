import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
// HashMap is implemented as Array of LinkedList
// Hashing algorithm : sha1 , sha256
// lambda <= K (threshold value) == n(# nodes)/N(# bucket)
// if lambda crosses K than increase the bucket(array size) size.

public class HashMapvk {
    static class HashMap<K,V> { // generics-general type it can be anything
        private class Node{
            K key;
            V value;
            public Node(K key, V value){
                this.key=key;
                this.value=value;
            }
        }
        private int n;//total nodes
        private int N;// total bucket
        private LinkedList<Node> bucket[];
       // @SuppressWarnings("unchecked");
        public  HashMap(){
            this.N=4;
            this.bucket = new LinkedList[4];
            for(int i=0;i<4;i++){
                this.bucket[i]=new LinkedList<>();
            }
        }
        private int hashfunction(K key){ // bucket index b/w 0 to N-1
            int bi = key.hashCode();
            return Math.abs(bi) % N;
        }
        private int searchInLL(K key,int bi){
            LinkedList<Node> ll = bucket[bi];
            for(int i=0;i<ll.size();i++){
                if(ll.get(i).key==key){
                    return i;
                }
            }
            return -1;
        }
        private void rehash(){
            LinkedList<Node> oldBucket[]=bucket;
            bucket = new LinkedList[N*2];
            for(int i=0;i<N*2;i++){
                bucket[i]=new LinkedList<>();
            }
            for(int i=0;i<oldBucket.length;i++){
                LinkedList<Node> ll = oldBucket[i];
                for(int j=0;j<ll.size();j++){
                    Node node = ll.get(j);
                    put(node.key,node.value);
                }
            }
        }

        public void put(K key,V value){
            int bi = hashfunction(key);
            int di = searchInLL(key,bi); // data index ==valid
            if(di==-1){//key doesn't exist
                bucket[bi].add(new Node(key,value));
                n++;
            }
            else{
                Node data = bucket[bi].get(di);
                data.value = value;
            }
            double lambda = (double) n/N;
            if(lambda>2){
                rehash();
            }
        }
        public V get(K key){
            int bi = hashfunction(key);
            int di = searchInLL(key,bi);
            if(di!=-1){
                Node node = bucket[bi].get(di);
                return node.value;
            }
            return null;
        }

    }

    public static void main(String[] args) {
      //  HashMap<String,Integer> map1 = new HashMap<>();
        HashMap<String,Integer> map = new HashMap<>();
        map.put("india", 54);
        map.put("china", 545);
        map.put("US",56);
        System.out.println(map.get("US"));

       /*
        // insertion
        map1.put("India", 140);
        map1.put("US",30);
        map1.put("pakistan",23);
        map1.put("china", 142);
        map1.put("nepal",23);
        map1.put("canada",20);
        map1.put("Bhootan", 23);
        map1.put("china",143);
        System.out.println(map1);
        // search
        if(map1.containsKey("china")){
            System.out.println("key is present");
        }
        // get
        System.out.println(map1.get("china"));
        System.out.println(map1.get("sslk"));
        // iteration
        /*
        int arr[] = {32,4,55,21,6};
        for(int i=0;i<5;i++){
            System.out.print(arr[i]+ " ");
        }
        System.out.println();
        for(int i: arr){
            System.out.print(i+ " ");
        }
       */
        /*
        for(Map.Entry<String,Integer> e :map1.entrySet()){
            System.out.println(e.getKey());
            System.out.println(e.getValue());
        }
        map1.remove("pakistan");
        Set<String> keys = map1.keySet();
        for(String key:keys){
            System.out.println(key);
            System.out.println(map1.get(key));
        }
     */


    }
}
// HashMap function
  /*
  1. put()
  2. get()
  3. containsKey()
  4. remove()
  5. size()
  6. KeySet()
   */