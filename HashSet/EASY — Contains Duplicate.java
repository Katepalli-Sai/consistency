🟢 EASY — Contains Duplicate
🔹 Problem Statement

Given an integer array arr, return true if any value appears at least twice, otherwise return false.

🧪 Example
Input:  arr = [1, 2, 3, 4, 1]
Output: true

Input:  arr = [1, 2, 3, 4]
Output: false

🎯 Hint

👉 As soon as you see duplicate, think HashSet
👉 Check before inserting
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
       HashSet<Integer>hs = new HashSet<>();
       boolean ans = false;
       for(int i=0;i<n;i++){
           if(hs.contains(arr[i])){
               ans = true;
               System.out.println(arr[i]);
               break;
           }
           hs.add(arr[i]);
       }
       System.out.println(ans);
       
    }
}