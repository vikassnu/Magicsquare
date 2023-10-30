import java.util.ArrayList;
import java.util.Scanner;

public class graphvk {
    static class edgewd{
        int src;
        int des;
        int cost;
        public  edgewd(int s,int d,int c){
            this.src=s;
            this.des=d;
            this.cost=c;
        }} // edge weighted directed
    static class edged{
            int src;
            int des;
            public edged(int src,int des){
                this.src=src;
                this.des=des;
            }

        } // edge directed && unweighted
    static class edgew{
        int src;
        int des;
        int cost;
        public edgew(int s,int d,int c){
            this.src=s;
            this.des=d;
            this.cost=c;
        }
    } // edge weighted  && non-directional
    static class edge{
        int src;
        int des;
        public edge(int s,int d){
            this.src=s;
            this.des=d;
        }
    }  // edge non-directional and unweighted
    public static void creategraph(ArrayList<edge> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i]= new ArrayList<>();
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("no. of edge: ");
        int edg =sc.nextInt();//no. of edge
        System.out.println("write source--> destin");
        for(int i=0;i<edg;i++){
            int s=sc.nextInt();
            int d=sc.nextInt();
            graph[s].add(new edge(s,d));
        }
    }  // Array of Lists;

    public static void main(String[] args) {
          Scanner sc = new Scanner(System.in);
          int V = sc.nextInt();
          ArrayList<edge> graph[] = new ArrayList[V];
          creategraph(graph);


    }
}
