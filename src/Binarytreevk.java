import java.util.LinkedList;
import java.util.Queue;
public class Binarytreevk {
    static class Node{
        int data;
        Node right;
        Node left;
        Node(int data){
            this.data=data;
            this.right=null;
            this.left=null;
        }
    }
    static class BinaryTree{
        static int idx =-1;
        public static Node buildtree(int nodes[]){
            idx++;
            if(nodes[idx]==-1){
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildtree(nodes);
            newNode.right=buildtree(nodes);
            return newNode;
        }

    }
    static class BinarySubtree{
        static int idx=-1;
        public static Node buildtree(int nodes[]){
            idx++;
            if(nodes[idx]==-1) return null;
            Node newnode = new Node(nodes[idx]);
            newnode.left=buildtree(nodes);
            newnode.right=buildtree(nodes);
            return newnode;
        }
    }
    public static void preorder(Node root){
        if(root==null){
            return ;
        }
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }  //DFS
    public static void inorder(Node root){
        if(root==null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }    //DFS
    public static void postorder(Node root){
        if(root==null){
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data+" ");
    }
    public static void levelorder(Node root){
        if(root==null){
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while(!q.isEmpty()){
            Node currNode = q.remove();
            if(currNode==null){
                System.out.println();
                if(q.isEmpty()){
                    break;
                }
                else{
                    q.add(null);
                }
            }
            else{
                System.out.print(currNode.data+" ");
                if(currNode.left!=null){
                    q.add(currNode.left);
                }
                if(currNode.right!=null){
                    q.add(currNode.right);
                }
            }
        }
    }
    public static int count_total_node(Node root){
        if(root==null){
            return 0;
        }
        return 1+count_total_node(root.right)+count_total_node(root.left);
    }
    public static int sum_nodes(Node root){
        if(root==null){
            return 0;
        }

        return root.data+sum_nodes(root.left)+sum_nodes(root.right);
    }
    public static int height_tree(Node root){
        if(root==null){
            return 0;
        }
        return 1+Math.max(height_tree(root.left),height_tree(root.right));
    }
    public static int diameter_tree(Node root){
        if(root==null){
            return 0;
        }
        return Math.max((1 + height_tree(root.right)+height_tree(root.left)),Math.max(diameter_tree(root.left),diameter_tree(root.right)));
    }
    static class TreeInfo{
        int ht;
        int diam;
        TreeInfo(int ht,int diam){
            this.ht = ht;
            this.diam=diam;
        }
    }
    public static TreeInfo diameter(Node root){
        if(root==null){
            return  new TreeInfo(0, 0);
        }
        TreeInfo left = diameter(root.left);
        TreeInfo right = diameter(root.right);
        int myheight = Math.max(left.ht, right.ht)+1;
        int d1 = left.diam;
        int d2 = right.diam;
        int d3 = left.ht + right.ht+1;
        int d = Math.max(Math.max(d1,d2),d3);
        TreeInfo res = new TreeInfo(myheight, d);
        return res;

    }
    public static boolean isidentical(Node root,Node subroot){
        if(root==null && subroot==null){
            return true;
        }
        if(root==null || subroot==null){
            return false;
        }
        if(root.data==subroot.data){
            return isidentical(root.right, subroot.right) && isidentical(root.left, subroot.left);
        }
        else{
            return false;
        }
    }
    public static boolean issubtree(Node root,Node subroot){
        if(subroot==null) return true;
        if(root==null) return false;
        if(root.data==subroot.data){
            return isidentical(root.right,subroot.right) && isidentical(root.left,subroot.left);
        }
        return issubtree(root.left, subroot)||issubtree(root.right, subroot);
    }

    public static void main(String[] args) {
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        int subtree[] = {2,4,-1,-1,5,-1,-1};
        BinarySubtree sbtree = new BinarySubtree();
        Node subroot = sbtree.buildtree(subtree);
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildtree(nodes);
        System.out.println(root.data);
        System.out.println("inorder:");
        inorder(root);
        System.out.println("");
        System.out.println("preorder:");
        preorder(root);
        System.out.println("");
        System.out.println("postorder:");
        postorder(root);
        System.out.println("");
        System.out.println("levelorder:");
        levelorder(root);
        System.out.println("");
        System.out.println("total node:");
        System.out.println(count_total_node(root));
        System.out.println("");
        System.out.println("sum of node:");
        System.out.println(sum_nodes(root));
        System.out.println("");
        System.out.println("height of node:");
        System.out.println(height_tree(root));
        System.out.println("");
        System.out.println("diameter of node:");
        System.out.println(diameter_tree(root));
        System.out.println("");
        System.out.println("diameter of node:O(n^2)");
        System.out.println(diameter(root).diam);
        System.out.println("is k subtree of root tree");
        System.out.println(issubtree(root,subroot));
    }
}
