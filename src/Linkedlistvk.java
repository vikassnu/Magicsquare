import java.util.LinkedList;

public class Linkedlistvk {
   /* Node head;
    class Node{
        int data;
        Node next;
        public Node(int data){
            this.data=data;
            this.next= null;
        }
    }*/

    Node head;
    private int size;
    Linkedlistvk(){
        this.size=0;
    }
    class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
            this.next=null;
            size++;
        }
    }
    // add -- first, last
    public void addfirst(int data){
        Node newnode = new Node(data);
        if(head==null){
           head=newnode;
           return;
        }
        newnode.next = head;
        head = newnode;
    }
    public void addlast(int data){
        Node newnode = new Node(data);
        if(head==null){
            head=newnode;
            return;
        }

        Node curr = head;
        while(curr.next!=null){
            curr=curr.next;
        }
        curr.next = newnode;
        newnode.next = null;

    }
    public void deletefirst(){
        if(head==null){
            System.out.println("list is empty");return;
        }
        size--;
        head=head.next;
    }
    public void deletelast(){
        if(head==null){
            System.out.println("linkedlist is empty");return;
        }
        size--;
        if(head.next==null){
            head=null;return;
        }
        Node _2nlast = head;
        Node last = head.next;
        while (last.next!=null){
            last=last.next;
            _2nlast=_2nlast.next;
        }
        _2nlast.next=null;

    }
    public void printlist(){
        if(head==null){
            System.out.println("list is empty");return;
        }
        Node curr =head;
        while(curr!=null){
            System.out.print(curr.data+"->");
            curr=curr.next;
        }
        System.out.print("-->null");
    }
    public int getsize(){
        return size;
    }
    public Node reverse_rec(Node head){
        if(head==null || head.next!=null){
            return head;
        }
        Node newhead = reverse_rec(head.next);
        head.next.next = head;
        head.next=null;

        return newhead;
    }
    public  void reverseiterate(){
        if(head==null || head.next==null){return ;}
        Node prevode = head;
        Node currnode = head.next;

        while(currnode!=null){
            Node nextnode = currnode.next;
            currnode.next = prevode;
            // update;
            prevode = currnode;
            currnode = nextnode;
        }
        head.next = null;
        head=prevode;
    }
    public static void main(String[] args) {
         // ArrayList
           // Insert: 0(n)
           // Search: O(n)
        // LinkedList
           // non-contiguous memory allocation
           // Insert: o(1)
           // Search: O(n)
           // variable size

        Linkedlistvk list = new Linkedlistvk();
       /* list.addlast("vsbl");
        list.addfirst("a");
        list.addfirst("is");
        list.printlist();
        System.out.println("");
        list.addfirst("vikas");
        list.addlast("bsis");
        list.printlist();
        list.deletefirst();
        System.out.println();
        list.printlist();
        list.deletelast();
        System.out.println();
        list.printlist();*/
        list.addfirst(4);   list.addfirst(3);
        list.addfirst(2);   list.addfirst(1);
        list.printlist();
        //list.reverseiterate();
        System.out.println();
       // list.printlist();
        System.out.println(" size:" + list.size);
        list.head = list.reverse_rec(list.head);
        list.printlist();
        System.out.println(list.head.data);
        /*
        Linkedlistvk l2 = new Linkedlistvk();
        LinkedList<String> list = new LinkedList<>();
        list.addFirst("a");
        list.addFirst("is");
        list.addFirst("This");
        list.add("list");
        System.out.println(list);
        System.out.println(list.size());
        list.remove();
        System.out.println(list);
        list.removeLast();
        System.out.println(list);
        list.remove(0);
        System.out.println(list);
        LinkedList<Integer> l1 = new LinkedList<>();

        l1.add(1);l1.add(2);l1.add(3);l1.add(4);

         */

    }
}
