import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int k = sc.nextInt();

        Arrays.sort(arr);

        int left = 0;
        int right = 1;
        boolean found = false;

        while (right < n && left < n) {

            if (left == right) {
                right++;
                continue;
            }

            int diff = arr[right] - arr[left];

            if (diff == k) {
                found = true;
                break;
            } else if (diff < k) {
                right++;
            } else {
                left++;
            }
        }

        System.out.println(found ? "YES" : "NO");
    }
}



🟡 MEDIUM TWO-POINTER PROBLEM
Pair with Given Absolute Difference
📘 Problem Statement

You are given an array of integers and a number K.

Your task is to determine whether there exists any pair of distinct elements in the array such that the absolute difference between them is exactly K.

You must solve this problem using the two-pointer technique (brute force is not allowed).

📥 Input Format
n
a1 a2 a3 ... an
K


Where:

n = number of elements

a1 … an = array elements

K = required absolute difference

📤 Output Format
YES


if such a pair exists, otherwise

NO

📌 Example Input
5
1 5 3 4 2
2

📌 Example Output
YES

🧠 DETAILED APPROACH (VERY IMPORTANT)
Step 1️⃣ Why sorting is required

Two-pointer logic works only on ordered data.

So first:

Sort the array


Example:

Original: [1, 5, 3, 4, 2]
Sorted:   [1, 2, 3, 4, 5]

Step 2️⃣ Initialize pointers

We want to compare two different elements.

So:

left  = 0   (points to smaller element)
right = 1   (points to next larger element)


Why not right = n-1?
👉 Because we are controlling difference, not sum.

Step 3️⃣ Difference logic

Compute:

diff = arr[right] - arr[left]


Because array is sorted, this difference is non-negative.

Step 4️⃣ Pointer movement rules (CORE LOGIC)
Condition	Action	Reason
diff == K	Found → stop	Exact match
diff < K	right++	Need larger difference
diff > K	left++	Need smaller difference

⚠️ Never decrease pointers
⚠️ Ensure right < n and left < right

🎥 DRY RUN (STEP-BY-STEP)
Input
arr = [1, 5, 3, 4, 2]
K = 2

After sorting
[1, 2, 3, 4, 5]

Initial pointers
left = 0 → 1
right = 1 → 2

Iteration 1
diff = 2 - 1 = 1
1 < 2 → move right

left = 0
right = 2 → 3

Iteration 2
diff = 3 - 1 = 2
2 == K → FOUND

✅ FINAL OUTPUT
YES


Because:

|3 - 1| = 2

🎯 WHY THIS APPROACH IS EFFICIENT
Method	Time
Brute force	O(n²) ❌
Two pointers	O(n log n) (sort) + O(n) ✔

Cognizant prefers:
✔ Clean logic
✔ No nested loops
✔ Pointer reasoning

🔑 GOLDEN TAKEAWAYS (MEMORIZE)

1️⃣ Sort the array
2️⃣ Start pointers close (0 and 1)
3️⃣ Expand or shrink difference, not sum
4️⃣ Always control bounds