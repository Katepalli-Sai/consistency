🔁 WHAT IS A CIRCULAR INDEX? (CORE CONCEPT)

Normally, arrays are linear:

Index:  0   1   2   3
Array: [A,  B,  C,  D]


If you go beyond index 3, you get an error.

But in circular indexing, the array behaves like a loop:

A → B → C → D
↑             ↓
└─────────────┘


So after the last index, you come back to the first index.

🧠 HOW DO WE IMPLEMENT CIRCULAR INDEX IN JAVA?
👉 Using modulo (%) operator

The golden formula is:

index = (index + 1) % n;


Where:

index → current position

n → array length

🔢 WHY % n WORKS (VERY IMPORTANT)

Let’s assume:

n = 4


Now see what happens:

index + 1	(index + 1) % 4	Resulting index
1	1	normal move
2	2	normal move
3	3	normal move
4	0	🔁 wrap to start
5	1	🔁 loop again

So % n forces the index to stay between 0 and n-1.

That’s why it’s perfect for circular movement.

🔍 APPLYING THIS TO YOUR CODE
Your line:
index = (index + 1) % n;


This means:

Move to the next index

If you were at the last index, go back to 0

So your traversal looks like:

0 → 1 → 2 → 3 → 0 → 1 → 2 → ...


No out-of-bounds error ✔️
Infinite circular traversal ✔️

🔋 HOW ENERGY & CIRCULAR INDEX WORK TOGETHER

Let’s take an example input:

arr = [6, 2, 4]


Initial values:

index = 0
energy = 6
steps = 0

🔁 Loop Iteration 1
index = (0 + 1) % 3 = 1
energy = 6 - 2 = 4
steps++

🔁 Loop Iteration 2
index = (1 + 1) % 3 = 2
energy = 4 - 4 = 0

🔁 Loop Iteration 3
index = (2 + 1) % 3 = 0
energy = 0 - 6 = -6


Loop stops.

⚠️ IMPORTANT LOGICAL ISSUE IN YOUR CODE
Your loop condition:
while(energy >= 0)


And step increment:

if(energy != 0){
    steps++;
}

❌ Problem:

You skip counting the step where energy becomes 0

But conceptually, that is a step

Also, the logic becomes confusing and error-prone

✅ CLEAN & CORRECT THINKING

A much cleaner approach is:

Count the step every time you move

Stop when energy becomes ≤ 0

Conceptually:

move → reduce energy → count step → check stop

🧠 CLEAN LOGICAL FLOW (NO CODE CHANGE, JUST CONCEPT)
while (energy > 0):
    index = (index + 1) % n
    energy = energy - arr[index]
    steps = steps + 1


This keeps:

Circular index logic clean

Step counting correct

No special conditions

🎯 FINAL TAKEAWAY (MEMORIZE THIS)
🔑 Circular Index Rule

Modulo (%) keeps an index inside array bounds by wrapping it back to 0.






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
        int steps = 0;
        int energy = arr[0];
        int index = 0;
        while(energy>0){
            index = (index+1)%n; //cicular Indexing
            energy=energy-arr[index];
            if(energy!=0){
                steps++;
            }
        }
        System.out.println(steps);
        
    }
}
