import java.util.ArrayList;

public class BSTvk {
    static  class  Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            this.left =left;
            this.right=right;
        }
    }
    public static Node insert(Node root, int val){
        if(root==null){
            root = new Node(val);
            return root;
        }
        if(root.data>val){
           root.left= insert(root.left, val);
        }else{
            root.right = insert(root.right, val);
        }
        return root;
    }
    public static void inorder(Node root){
        if(root==null) return;
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    public static boolean search(Node root,int key){
        if(root==null){
            return false;
        }
        if(root.data>key){
            return search(root.left,key);
        }
        else if(root.data<key){
            return search(root.right, key);
        }
        else{
            return true;
        }
    }// O(H)
    public static Node inordersuccessor(Node root){
        while (root.left!=null){
            root=root.left;
        }
        return root;
    }
    public static Node delete(Node root,int val){
        if(root.data>val){
            root.left = delete(root.left, val);
        }
        else if(root.data<val){
            root.right = delete(root.right, val);
        }
        else{
            // case 1
            if(root.left==null && root.right==null){
                return null;
            }
            //case 2
            if(root.left==null){
                return root.right;
            }
            else if(root.right==null){
                return root.left;
            }
            //case3
            Node IS = inordersuccessor(root.right);
            root.data = IS.data;
            root.right = delete(root.right,IS.data);
        }
        return root;
    }
    public static void printpath(ArrayList<Integer> path){
        for (int i=0;i<path.size();i++){
            System.out.print(path.get(i)+" ");
        }
        System.out.println("");
    }
    public static void printinrange(Node root,int x,int y){
        if(root == null) return;
        if(root.data >=x && root.data <=y){
            printinrange(root.left, x, y);
            System.out.print(root.data+" ");
            printinrange(root.right, x,y);

        }
        else if(root.data>=y){
            printinrange(root.left,x,y);
        }
        else{
            printinrange(root.right,x,y);
        }
    }
    public static void printroot2leaf(Node root, ArrayList<Integer> path){
        if(root==null) return;
        path.add(root.data);
        if(root.left==null && root.right==null){
            printpath(path);
        }
        else{
        printroot2leaf(root.left, path);
        printroot2leaf(root.right,path);}
        path.remove(path.size()-1);
    }
    public static void main(String[] args) {
        int val[] = {8,5,3,6,10,11,14};
        Node root = null;
        for(int i=0;i<val.length;i++){
            root=insert(root, val[i]);
        }
        inorder(root);
        System.out.println(search(root, 1));
        //delete(root, 5);
        inorder(root);
        System.out.println("");
        printinrange(root,3,10);
        System.out.println();
        printroot2leaf(root,new ArrayList<>());

    }

}
