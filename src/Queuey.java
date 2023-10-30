import java.util.*;

public class Queuey {
    // queue implementation using stack
    static class stack_queue{
        static Stack<Integer> s1 = new Stack<>();
        static Stack<Integer> s2 = new Stack<>();
        public static boolean isEmpty(){
            return s1.isEmpty();
        }
        public static void add(int data){
            while (!s1.isEmpty()){
                s2.push(s1.pop());
            }
            s1.push(data);
            while (!s2.isEmpty()){
                s1.push(s2.pop());
            }
        }
        public static int remove(){
            if(isEmpty()){
                System.out.println("empty queue");
                return -1;
            }
            return  s1.pop();
        }
        public static int peek(){
            if(isEmpty()){
                System.out.println("empty queue");return -1;
            }
            return s1.peek();
        }

    }
    // queue implementation using array, circular array ,linkedlist

    static class queue{
        static int arr[];
        static int size;
        static int rear =-1;
        queue(int n){
            arr = new int[n];
            this.size = n;
        }
        //normal queue
        // isEmpty
        public static boolean isEmpty(){
            return rear==-1;
        }
        // enqueue  O(1)
        public static void add(int data){
            if(rear==size-1){
                System.out.println("full queue");
                return;
            }
            rear++;
            arr[rear]=data;
        }
        // dequeue  O(n)
        public static int remove(){
            if(isEmpty()){
                System.out.println("empty queue");
                return -1;
            }
            int front=arr[0];
            for(int i=0;i<rear;i++){
                arr[i]=arr[i+1];
            }
            rear--;
            return front;

        }
        // peek   O(n)
        public static int peek(){
            if(isEmpty()){
                System.out.println("empty queue");
                return -1;
            }
            return arr[0];}

        // circular Queue



    }
    static class circular_queue{
        static int arr[];
        static int size;
        static int front=-1;
        static int rear=-1;
        circular_queue(int n){
            arr = new int[n];
            this.size = n;
        }
        // is Empty()  O(1)
        public static boolean isEmpty(){
            return rear ==-1 && front==-1;
        }
        // is Full()  O(1)
        public static boolean isFull(){
            return (rear+1)%size==front;
        }
        // enqueue   O(1)
        public static void add(int data){
            if(isFull()){
                System.out.println("queue is full");
                return;
            }
            if(front==-1){
                front=0;
            }
            rear = (rear+1)%size;
            arr[rear]=data;
        }
        // dequeue  O(1)
        public static int remove(){
            if(isEmpty()){
                System.out.println("empty queue");
                return -1;
            }
            int res = arr[front];
            if(rear==front){
                rear=front=-1;
            }
            else{
                front = (front+1)%size;
            }
            return res;
        }
        // peek O(1)
        public static int peek(){
            if(isEmpty()){
                System.out.println("empty queue");return -1;
            }
            return arr[front];
        }

    }
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            next=null;
        }
    }
    static class linkedlist_queue{
       static Node head=null;
       static Node tail=null;
       public static boolean isEmpty(){
           return head==null & tail==null;
       }
        public static void add(int data){
           Node newnode = new Node(data);
           if(tail==null){
               tail=head=newnode;
               return;
           }
           tail.next = newnode;
           tail=newnode;


        }
        public static int remove(){
           if(isEmpty()){
               System.out.println("queue is empty");return -1;
           }
           int front=head.data;
           if(head==tail){
               tail=null;
           }
           head = head.next;
           return front;
        }
        public static int peek(){
           if(isEmpty()){
               System.out.println("empty queue");return -1;
           }
           return head.data;
        }
    }


    public static void main(String[] args) {
        //don't delete
        /*
         queue q = new queue(5);
         q.add(10);
         q.add(20);
         q.add(30);
         while(!q.isEmpty()){
             System.out.println(q.peek());
             q.remove();
         }
         circular_queue cq = new circular_queue(5);

         cq.add(1);
         cq.add(2);
         cq.add(3);
         cq.add(4);
        cq.add(5);
        System.out.println(cq.remove());
        cq.add(6);
        System.out.println(cq.remove());
        cq.add(7);

         while (!cq.isEmpty()){
             System.out.println(cq.peek());
             cq.remove();
         }

         linkedlist_queue lq = new linkedlist_queue();
         lq.add(100);
         lq.add(200);
         lq.add(300);
         lq.add(400);
         lq.add(500);
         while(!lq.isEmpty()){
             System.out.println(lq.peek());
             lq.remove();
         }
*/
        //Queue<Integer> q = new LinkedList<>();
        //Queue<Integer> q = new ArrayDeque<>();
        stack_queue q = new stack_queue();
        q.add(525);
        q.add(34);
        q.add(43);
        while (!q.isEmpty()){
            System.out.println(q.peek());
            q.remove();
        }
        // Queue implementation using 2 stack

    }
}
