✅ Question 1: First Repeating Element Index
🧠 Problem Statement

Given an integer array of size N, find the index (0-based) of the first element that repeats.

➡️ If no element repeats, print -1

📥 Input Format

First line: Integer N

Second line: N space-separated integers

📤 Output Format

Print the index of the first repeating element

🧪 Sample Input
7
4 3 5 2 3 1 4

✅ Sample Output
1

💡 Explanation

3 repeats before 4

First occurrence index of 3 = 1
//code 



import java.util.*;
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashMap<Integer,Integer>hm = new HashMap<>();
        for(int i=0;i<n;i++){
            int digit = sc.nextInt();
            if(hm.containsKey(digit)){
                System.out.println(hm.get(digit));
                return;
            }
            hm.put(digit,i);
        }
    }
}





🧠 BIG IDEA (1 Line Summary)

👉 We store the first index of every number.
The moment we see a number again, we print its first index and stop.

🔄 FLOW EXPLANATION (Step by Step)
🔹 Step 1: Loop Starts
for (int i = 0; i < n; i++)


i represents the current index

We process one element at a time

This ensures left-to-right traversal

🔹 Step 2: Read Current Element
int val = sc.nextInt();


Reads the number at index i

Example input:

4 3 5 2 3 1 4

🔹 Step 3: Check If Already Seen
if (map.containsKey(val))


💡 Meaning:

“Have I seen this number before?”

✔ true → repetition found
❌ false → first time seeing it

🛑 WHY THIS WORKS FOR “FIRST REPEATING”

The first element whose second occurrence appears first will be detected earliest during traversal.

👉 The moment repetition happens, we stop immediately.

🔹 Step 4: Print First Index & Stop
System.out.println(map.get(val));
return;


map.get(val) → gives first index

return → exits main() immediately

Prevents:

Multiple outputs

Wrong later repetitions

🔹 Step 5: Store First Occurrence
map.put(val, i);


Only executed if element is new

Stores:

value → first index


Example:

3 → 1

🧪 FULL DRY RUN (Very Important)
Input
7
4 3 5 2 3 1 4

🔍 Iteration-wise Flow
i = 0
val = 4
map = {}
containsKey(4) ❌
map.put(4, 0)

i = 1
val = 3
map = {4=0}
containsKey(3) ❌
map.put(3, 1)

i = 2
val = 5
map = {4=0, 3=1}
containsKey(5) ❌
map.put(5, 2)

i = 3
val = 2
map = {4=0, 3=1, 5=2}
containsKey(2) ❌
map.put(2, 3)

i = 4
val = 3
map = {4=0, 3=1, 5=2, 2=3}
containsKey(3) ✅
map.get(3) → 1
PRINT 1
STOP

✅ Final Output
1

⏱ Time & Space Complexity (Interview Gold ✨)
⏱ Time Complexity

Loop runs once → O(n)

HashMap operations → O(1) average

✅ Total: O(n)

💾 Space Complexity

HashMap stores up to n elements

✅ O(n)
