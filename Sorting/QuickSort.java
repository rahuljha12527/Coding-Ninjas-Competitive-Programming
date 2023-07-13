// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;
class HelloWorld {
    
    public static void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public static int Partition(int []arr,int left ,int right){
        int pivot=arr[right];
        
        int i=left-1;
        for(int j=left;j<right;j++){
            if(arr[j]<pivot){
                i++;
                swap(arr,i,j);
            }
        }
        
        
        swap(arr,i+1,right);
        return (i+1);
    }
    
    public static void QuickSort(int[] arr,int left,int right){
        if(left>=right) return;
        int pivot=Partition(arr,left,right);
        QuickSort(arr,left,pivot-1);
        QuickSort(arr,pivot+1,right);
    }
    public static void main(String[] args) {
        //System.out.println("Hello, World!");
        
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int []arr=new int[n];
        for(int i=0;i<n;i++) arr[i]=sc.nextInt();
        QuickSort(arr,0,n-1);
        for(int i:arr){
            System.out.print(i+" ");
        }
    }
}