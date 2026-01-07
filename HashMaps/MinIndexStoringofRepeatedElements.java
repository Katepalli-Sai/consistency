
import java.util.*;
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
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
        ArrayList<Integer>res = new ArrayList<>();
        for(int key:freqMap.keySet()){
            if(freqMap.get(key)>1){
                res.add(indexMap.get(key));
            }
        }
        for (int i = 0; i < res.size(); i++) {
            if (i > 0) System.out.print(" ");
            System.out.print(res.get(i));
        }
    }
}


✅ New Problem Statement

Given an array, find all repeating elements and store the minimum (first) index of each repeating element in a result array.

⚠️ Important:

Indexing is 0-based

Each repeating element appears only once in the result

We store indexes, not values

🧪 Example
arr = [10, 5, 3, 4, 3, 5, 6]

Repeating elements:

3 → first index = 2

5 → first index = 1

Expected Output (indexes):
2 1


(Order doesn’t matter unless specified)

🧠 Correct Thinking (Very Important)

We need to know two things:

How many times an element appears

Where it appeared first

So we use:

HashMap<Integer, Integer> freqMap → frequency

HashMap<Integer, Integer> indexMap → first index

ArrayList<Integer> res → store result indexes

✅ Correct Java Code (Clean & Interview-Ready)
import java.util.*;

class Main {
    public static void main(String[] args) {

        int[] arr = {10, 5, 3, 4, 3, 5, 6};

        HashMap<Integer, Integer> freqMap = new HashMap<>();
        HashMap<Integer, Integer> indexMap = new HashMap<>();

        // First pass: count frequency & store first index
        for (int i = 0; i < arr.length; i++) {
            freqMap.put(arr[i], freqMap.getOrDefault(arr[i], 0) + 1);

            // store index only first time
            if (!indexMap.containsKey(arr[i])) {
                indexMap.put(arr[i], i);
            }
        }

        ArrayList<Integer> res = new ArrayList<>();

        // Second pass: collect minimum index of repeating elements
        for (int key : freqMap.keySet()) {
            if (freqMap.get(key) > 1) {
                res.add(indexMap.get(key));
            }
        }

        // Print result
        for (int i = 0; i < res.size(); i++) {
            if (i > 0) System.out.print(" ");
            System.out.print(res.get(i));
        }
    }
}

🧪 Dry Run (Step-by-Step)
Input
arr = [10, 5, 3, 4, 3, 5, 6]

🔹 First Pass (Build Maps)
i	arr[i]	freqMap	indexMap
0	10	{10=1}	{10=0}
1	5	{10=1,5=1}	{10=0,5=1}
2	3	{…,3=1}	{…,3=2}
3	4	{…,4=1}	{…,4=3}
4	3	{3=2}	(no change)
5	5	{5=2}	(no change)
6	6	{…,6=1}	{…,6=6}
Final Maps
freqMap  = {10=1, 5=2, 3=2, 4=1, 6=1}
indexMap = {10=0, 5=1, 3=2, 4=3, 6=6}

🔹 Second Pass (Find Repeating Elements)

10 → freq=1 ❌

5 → freq=2 ✅ → add index 1

3 → freq=2 ✅ → add index 2

4 → freq=1 ❌

6 → freq=1 ❌

✅ Final Result Array
res = [1, 2]


Printed as:

1 2


(You may also see 2 1 because HashMap has no order — both are correct unless order is specified.)
