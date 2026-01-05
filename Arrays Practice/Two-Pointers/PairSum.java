
import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        int k = sc.nextInt();

        Arrays.sort(arr);  

        int left = 0;
        int right = n - 1;
        boolean found = false;

        while(left < right){
            int sum = arr[left] + arr[right];

            if(sum == k){
                found = true;
                break;
            }
            else if(sum < k){
                left++;
            }
            else{
                right--;
            }
        }

        if(found){
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}








🟢 TWO POINTER – EASY LEVEL (FOUNDATION)
📘 Problem: Pair Sum Using Two Pointers

You are given:

An array of integers

A target value K

Your task:

Check whether any two different elements in the array add up to K

If yes → print YES

Else → print NO

⚠️ Important rule:
To use the two-pointer approach, the array must be sorted.

📥 Input Format
n
a1 a2 a3 ... an
K


Where:

n = size of array

a1...an = array elements

K = target sum

📤 Output Format
YES
or
NO

📌 Example Input
5
2 8 1 5 9
6

📌 Step 1: Understand the input

Array:

[2, 8, 1, 5, 9]


Target:

K = 6

⚠️ STEP 2: Check if array is sorted
[2, 8, 1, 5, 9]  ❌ NOT SORTED


👉 Two-pointer logic cannot be applied directly.

So first, sort the array.

✅ STEP 3: Sort the array
Sorted array = [1, 2, 5, 8, 9]


Now two-pointer logic is valid.

🧠 STEP 4: Initialize two pointers
left = 0   → points to 1
right = 4  → points to 9


Visual:

L → 1   2   5   8   9 ← R

🔁 STEP 5: Dry Run (Most Important)
🔹 Iteration 1
arr[left] + arr[right] = 1 + 9 = 10


Compare with K:

10 > 6


Action:

Move right pointer left (right--)

🔹 Iteration 2
left → 1
right → 8
sum = 1 + 8 = 9

9 > 6


Action:

right--

🔹 Iteration 3
left → 1
right → 5
sum = 1 + 5 = 6

6 == K ✅


🎯 Pair found → STOP

✅ Final Output
YES


Because:

1 + 5 = 6

🧠 WHY TWO POINTER WORKS HERE

Because the array is sorted:

If sum is too small → move left forward

If sum is too large → move right backward

This guarantees:

No pair is missed

No unnecessary checks

Time complexity = O(n)

🔑 GOLDEN RULE (VERY IMPORTANT)

Two-pointer pair sum works ONLY on sorted arrays.

If array is:

❌ Unsorted → sort first or use HashSet

✅ Sorted → two pointers is best
