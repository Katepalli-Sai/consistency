// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;
class Main {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       int n = sc.nextInt();
       int[] arr = new int[n];
       for(int i=0;i<n;i++){
           arr[i] = sc.nextInt();
       }
       int max = Integer.MIN_VALUE;
       int secondmax = Integer.MIN_VALUE;
       for(int i=0;i<n;i++){
           if(arr[i]>max){
               max = arr[i];
               secondmax = max;
           }
           else if(arr[i]>secondmax && arr[i]!=max){
               secondmax = arr[i];
           }
       }
       if(secondmax == Integer.MIN_VALUE){
           System.out.println("no second highest");
       }else{
           System.out.println(secondmax);
       }
    }
}
