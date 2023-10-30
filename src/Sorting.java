import java.util.Scanner;

public class Sorting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        bubblesort(arr);
        insertionsort(arr);
        selectionsort(arr);
        mergesort(arr,0,arr.length-1);
        quicksort(arr,0,arr.length-1);

    }
    private static void quicksort(int[] arr,int l,int r) {
        System.out.println("quicksort : based on divide and conquer");
        System.out.println("Nlog(N),Nlog(N),N^2 --> time complexity");
        System.out.println("O(1): auxiliary space");
        System.out.println("Not a stable , inplace");
        if(r>l){
            int p = parition(arr,l,r);
            quicksort(arr,l,p-1);
            quicksort(arr,p+1,r);
        }
        print(arr);
    }
    private static int parition(int[] arr, int l, int r) {
        int pivot = arr[r];
        int i=(l-1);
        for(int j=l;j<r;j++){
            if(arr[j]<pivot){
                i++;
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }
        int temp =arr[i+1];
        arr[i+1]=arr[r];
        arr[r]=temp;
        return (i+1);
    }
    private static void mergesort(int[] arr,int l,int r) {

        if(l<r){
            int m = (r+l)/2;
            mergesort(arr,l,m);
            mergesort(arr,m+1,r);
            merge(arr,l,m,r);
        }


    }
    private static void merge(int[] arr, int l, int m, int r) {
        int[] L = new int[m-l+1];
        int[] R = new int[r-m];
        for(int i=0;i<L.length;i++) L[i]=arr[i+l];
        for(int i=0;i<R.length;i++) R[i]=arr[m+1+i];
        int i=0,j=0,k=l;
        while(i<L.length && j<R.length){
            if(L[i]<=R[j]){
                arr[k]=L[i];
                i++;
            }
            else{
                arr[k]=R[j];
                j++;
            }
            k++;
        }
        while (i<L.length){
            arr[k]=L[i];
            i++;
            k++;
        }
        while (j<R.length){
            arr[k]=R[j];
            j++;
            k++;
        }
        System.out.println("Merge Sort: T(n) = 2*T(n/2)+θ(n)");
        System.out.println("Time: O(nlogn) , space: O(n)");
        System.out.println("not in place and Stable algorithm");
        print(arr);

    }
    private static void selectionsort(int[] arr) {
        for(int i=0;i<arr.length;i++){
            int min_idx=i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]<arr[min_idx]){
                    min_idx =j;
                }
            }
            int temp=arr[min_idx];
            arr[min_idx]=arr[i];
            arr[i]=temp;
        }
        System.out.println("Selection sort: ");
        System.out.println("Time: O(n^2) , Space: O(1)");
        System.out.println("not stable, Inplace(doesn't require extra space)");
        print(arr);
    }
    private static void insertionsort(int[] arr) {
        for(int i=1;i<arr.length;i++){
            int key = arr[i];
            int j=i-1;
            while(j>=0 && key<arr[j]){
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=key;
        }
        System.out.println("Insertion sort: ");
        System.out.print("Time(worst,avg): O(N^2), Space: O(1), time(best): O(N) ");
        System.out.println("1.worst time if element sorted reverse()");
        System.out.println("2. Inplace and Stable and useful if few element misplaced");
        print(arr);
        System.out.println();
    }
    private static void print(int[] arr) {
        System.out.print("[");
        for(int d: arr) System.out.print(d+" ");
        System.out.print("]");
    }
    private static void bubblesort(int[] arr) {
        boolean check=false;
        for(int i=0;i<arr.length-1;i++){
            for(int j=0;j<arr.length-1;j++){
                if(arr[j]>arr[j+1]){
                     int temp=arr[j+1];
                     arr[j+1]=arr[j];
                     arr[j]=temp;
                    check=true;
                }
            }
            if(check==false) break;
        }
        System.out.println("Bubble sort: ");
        System.out.println("1. time: O(N^2) , Space: O(1), best time: O(n) when element is sorted");
        System.out.println("2. Inplace and Stable");
        print(arr);
        System.out.println();
    }
}
