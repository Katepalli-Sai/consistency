📘 Problem Statement (Cognizant-style)

You are given an integer array.

Rules:

Start at index 0

Add the value at the current index to sum

Movement depends on the value at the current index:

If the value is even → move 2 steps forward

If the value is odd → reverse direction and move 1 step

Stop when the index goes out of bounds

Print the final sum

📥 Input
n = 5
arr = [3, 4, 5, 2, 1]

📤 Output
3

✅ CORRECT JAVA CODE
import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int index = 0;
        int direction = 1;   // +1 = forward, -1 = backward
        int sum = 0;

        while (index >= 0 && index < n) {
            sum += arr[index];

            if (arr[index] % 2 == 0) {
                // even → move 2 steps in current direction
                index = index + (2 * direction);
            } else {
                // odd → reverse direction, move 1 step
                direction = -direction;
                index = index + direction;
            }
        }

        System.out.println(sum);
    }
}

🎥 DETAILED VISUALIZATION (MOST IMPORTANT)

Think of a person walking on tiles.

Array with indices:

Index:  0   1   2   3   4
Array: [3,  4,  5,  2,  1]

🧠 Initial State
index = 0
direction = +1 (→ forward)
sum = 0


Visual:

[3]  4   5   2   1
 ↑

▶️ ITERATION 1
Step 1: Add value
sum = 0 + 3 = 3

Step 2: Check value
arr[0] = 3 → odd


Rule:

Odd → reverse direction + move 1 step


So:

direction = -1
index = 0 - 1 = -1


Visual:

[3]  4   5   2   1
 ←

🛑 STOP CONDITION
index = -1 ❌ (out of bounds)


Loop ends.

✅ FINAL OUTPUT
3
