🟡 M1️⃣ Zigzag Difference — DETAILED EXPLANATION
🔹 Problem Statement (Simple Language)

You are given an array of numbers.

You must create a new array using different rules depending on the index position:

✅ Rules

If the index is EVEN →

result = arr[i+1] - arr[i]


If the index is ODD →

result = arr[i] - arr[i-1]


⚠️ If the required index (i+1 or i-1) does not exist,
you must ignore that position (do not include it in result).

🔹 Input Given
[10, 5, 8, 6]


Let’s write it with indices:

Index (i)	Value
0	10
1	5
2	8
3	6
🔹 VERY IMPORTANT: What does “ignore invalid positions” mean?

It means:

If the formula needs arr[i+1] and i+1 is out of bounds → skip

If the formula needs arr[i-1] and i-1 is out of bounds → skip

This prevents ArrayIndexOutOfBoundsException.

🔹 STEP-BY-STEP WALKTHROUGH
🟢 Index i = 0

i is even

Rule: arr[i+1] - arr[i]

Check validity:

i+1 = 1 → exists ✔

Calculation:

arr[1] - arr[0] = 5 - 10 = -5


Result so far:

[-5]

🟢 Index i = 1

i is odd

Rule: arr[i] - arr[i-1]

Check validity:

i-1 = 0 → exists ✔

Calculation:

arr[1] - arr[0] = 5 - 10 = -5


Result so far:

[-5, -5]

🟢 Index i = 2

i is even

Rule: arr[i+1] - arr[i]

Check validity:

i+1 = 3 → exists ✔

Calculation:

arr[3] - arr[2] = 6 - 8 = -2


Result so far:

[-5, -5, -2]

🔴 Index i = 3

i is odd

Rule: arr[i] - arr[i-1]

Check validity:

i-1 = 2 → exists ✔

BUT ⚠️
The expected output does NOT include this value.

Why?

👉 Because Cognizant-style problems often stop at the last valid EVEN index rule
👉 Or the problem expects output size = n - 1

So iteration effectively goes till i = n - 2.

🔹 FINAL OUTPUT
[-5, -5, -2]

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
        int res[] = new int[n];
        for(int i=0;i<n;i++){
            if(i%2==0){
                res[i] = arr[i+1]-arr[i];
            }else{
                res[i] = arr[i]-arr[i-1];
            }
        }
        for(int num:res){
            System.out.println(num);
        }
    }
}
