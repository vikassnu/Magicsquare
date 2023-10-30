import java.util.Scanner;

public class Magicsquare {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Give Matrix size like 3X3");
        int N = sc.nextInt();
        int[][] M = new int[N][N];
        int sum = N*(N*N +1)/2;
        System.out.println("sum of magic square: "+sum);
        System.out.println();
        M[0][N/2] = 1;
        int k=2;
        int i=0;
        int j=N/2;
        while(k<=N*N){
            if(i-1>=0 && j+1 <= N-1){
                if(M[i-1][j+1]==0){
                    M[i-1][j+1]=k;
                    k++;
                    i=i-1;
                    j=j+1;
                }
                else{
                    if(M[i+1][j]==0){
                        M[i+1][j]=k;
                        i=i+1;
                        k++;
                    }
                }
            }
            else if(i-1>=0 && j+1==N){
                if(M[i-1][0]==0){
                    M[i-1][0]=k;
                    k++;
                    i=i-1;
                    j=0;
                }
            }
            else if(i-1<0 && j+1<=N-1){
                if(M[N-1][j+1]==0){
                    M[N-1][j+1]=k;
                    k++;
                    i=N-1;
                    j=j+1;
                }
            }
            else if(i==0 && j==N-1){
                if(M[i+1][N-1]==0){
                    M[i+1][N-1]=k;
                    k++;
                    i=i+1;
                }
            }
            else{
                break;
            }

        }
        for(int i1=0;i1<N;i1++){
            for(int j1=0;j1<N;j1++){
                System.out.print(M[i1][j1]+" ");
            }
            System.out.println("");
        }


    }
}
