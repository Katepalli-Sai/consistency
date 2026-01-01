// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int[] res = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int count0 = 0;
        int count1 = 0;
        int count2 = 0;
        for(int i=0;i<n;i++){
            if(arr[i]==0){
                count0++;
            }
            if(arr[i]==1){
                count1++;
            }
            if(arr[i]==2){
                count2++;
            }
        }
        for(int i=0;i<count0;i++){
            res[i] =0;
        }
        for(int i=count0;i<count0+count1;i++){
            res[i] =1;
        }
        for(int i=count0+count1;i<n;i++){
            res[i] =2;
        }
        
        // System.out.println(count0);
        // System.out.println(count1);
        // System.out.println(count2);
        
        for(int num:res){
            System.out.println(num);
        }
        
    }
}
