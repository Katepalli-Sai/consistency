// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
            
        }
        boolean sorted = false;
        for(int i=1;i<n-1;i++){
            if(arr[i+1]>arr[i]){
                sorted = true;
            }
        }
        System.out.println(sorted);
        
    }
}
