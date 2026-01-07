// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int k = sc.nextInt();
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        HashMap<Integer,Integer>hm = new HashMap<>();
        for(int i=0;i<n;i++){
            hm.put(arr[i],hm.getOrDefault(arr[i],0)+1);
            if(hm.get(arr[i])==k){
                System.out.println(arr[i]);
                return;
            }
        }
        System.out.println(-1);
    }
}

Let’s slowly dry-run the CORRECTED code with a real test case, and I’ll explain every single step, like you’re watching the program execute.

🧪 Test Case
n = 6
k = 2
arr = [1, 2, 1, 2, 1, 3]

🧩 Code We Are Dry-Running
HashMap<Integer, Integer> hm = new HashMap<>();

for(int i = 0; i < n; i++){
    hm.put(arr[i], hm.getOrDefault(arr[i], 0) + 1);

    if(hm.get(arr[i]) == k){
        System.out.println(arr[i]);
        return;
    }
}

🧠 Step-by-Step Dry Run
🔹 Before Loop Starts
hm = { }

🔁 Iteration 1 (i = 0)
arr[0] = 1


Update frequency:

hm.put(1, 1)


Now:

hm = {1=1}


Check:

hm.get(1) == 2 ? ❌


→ Continue loop

🔁 Iteration 2 (i = 1)
arr[1] = 2


Update frequency:

hm.put(2, 1)


Now:

hm = {1=1, 2=1}


Check:

hm.get(2) == 2 ? ❌


→ Continue loop

🔁 Iteration 3 (i = 2)
arr[2] = 1


Update frequency:

hm.put(1, 2)


Now:

hm = {1=2, 2=1}


Check:

hm.get(1) == 2 ? ✅

🛑 Condition Met — STOP
System.out.println(1);
return;


Program exits immediately.

✅ Final Output
1
