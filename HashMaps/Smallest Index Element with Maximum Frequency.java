import java.util.*;

class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        HashMap<Integer, Integer> freqMap = new HashMap<>();
        HashMap<Integer, Integer> indexMap = new HashMap<>();

        // Count frequency and store first index
        for (int i = 0; i < n; i++) {
            if (!freqMap.containsKey(arr[i])) {
                freqMap.put(arr[i], 1);
                indexMap.put(arr[i], i);
            } else {
                freqMap.put(arr[i], freqMap.get(arr[i]) + 1);
            }
        }

        int maxFreq = 0;
        int answer = -1;
        int minIndex = Integer.MAX_VALUE;

        // Find element with max frequency and smallest index
        for (int key : freqMap.keySet()) {
            int freq = freqMap.get(key);
            int idx = indexMap.get(key);

            if (freq > maxFreq) {
                maxFreq = freq;
                answer = key;
                minIndex = idx;
            } else if (freq == maxFreq) {
                if (idx < minIndex) {
                    answer = key;
                    minIndex = idx;
                }
            }
        }

        System.out.println(answer);
    }
}
🟠 Problem Recap

Goal:
Find the element with maximum frequency.
If there is a tie, choose the element that appears first in the array.

🔢 Sample Input We’ll Use
n = 7
arr = [3, 5, 3, 2, 5, 5, 3]

🧠 Step-by-Step Code Explanation
1️⃣ Input Reading
Scanner sc = new Scanner(System.in);
int n = sc.nextInt();


Reads number of elements → n = 7

int[] arr = new int[n];
for (int i = 0; i < n; i++) {
    arr[i] = sc.nextInt();
}


Stores array values

arr = [3, 5, 3, 2, 5, 5, 3]

2️⃣ Create HashMaps
HashMap<Integer, Integer> freqMap = new HashMap<>();
HashMap<Integer, Integer> indexMap = new HashMap<>();

Purpose:
Map	Stores
freqMap	Element → Frequency
indexMap	Element → First index
3️⃣ Traverse Array (Counting + Indexing)
for (int i = 0; i < n; i++) {

Iteration-wise breakdown 👇
🔹 i = 0 → element = 3
if (!freqMap.containsKey(3)) {
    freqMap.put(3, 1);
    indexMap.put(3, 0);
}


Maps:

freqMap  = {3=1}
indexMap = {3=0}

🔹 i = 1 → element = 5
freqMap  = {3=1, 5=1}
indexMap = {3=0, 5=1}

🔹 i = 2 → element = 3 (already exists)
freqMap.put(3, 2);

freqMap  = {3=2, 5=1}
indexMap = {3=0, 5=1}


✔ Index not updated (important)

🔹 i = 3 → element = 2
freqMap  = {3=2, 5=1, 2=1}
indexMap = {3=0, 5=1, 2=3}

🔹 i = 4 → element = 5
freqMap  = {3=2, 5=2, 2=1}
indexMap = {3=0, 5=1, 2=3}

🔹 i = 5 → element = 5
freqMap  = {3=2, 5=3, 2=1}

🔹 i = 6 → element = 3
freqMap  = {3=3, 5=3, 2=1}

✅ Final Maps
freqMap  = {3=3, 5=3, 2=1}
indexMap = {3=0, 5=1, 2=3}

4️⃣ Find Answer Using Both Conditions
int maxFreq = 0;
int answer = -1;
int minIndex = Integer.MAX_VALUE;

Loop through freqMap
for (int key : freqMap.keySet()) {

🔹 key = 3
freq = 3
index = 0


3 > maxFreq → YES

Update:

maxFreq = 3
answer = 3
minIndex = 0

🔹 key = 5
freq = 3
index = 1


freq == maxFreq

index < minIndex → ❌ (1 > 0)

❌ Do nothing

🔹 key = 2
freq = 1


freq > maxFreq → ❌
Skip

5️⃣ Final Output
System.out.println(answer);

✅ Output:
3
