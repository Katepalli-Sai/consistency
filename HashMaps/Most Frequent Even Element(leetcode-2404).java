class Solution {
    public int mostFrequentEven(int[] nums) {
        int n = nums.length;
        HashMap<Integer,Integer>freqMap = new HashMap<>();
        for(int num:nums){
            if(num%2==0){
                freqMap.put(num,freqMap.getOrDefault(num,0)+1);
            }
        }
        int maxfreq = 0;
        int ans = -1;
        for(int key:freqMap.keySet()){
            int freq = freqMap.get(key);
            // if(freq>maxfreq || (freq==maxfreq)&& key<ans){
            //     maxfreq = freq;
            //     ans = key;
            // }

            if (freq > maxfreq) {
                maxfreq = freq;
                ans = key;
            }
            else if (freq == maxfreq && key<ans) {
               ans = key;
            }

        }
        return ans;

    }
}


🧩 Question: Most Frequent Even Element
Problem statement (simple words)

You are given an integer array nums.

👉 You must:

Consider only even numbers

Find the even number with the highest frequency

If there is a tie, return the smallest even number

If no even number exists, return -1

📥 Input format
nums = [array of integers]

📤 Output format
single integer (answer)

🧪 Example Input & Output
Example 1
Input:  nums = [0,1,2,2,4,4,1]
Output: 2

Why?

Even numbers → 0, 2, 4

Frequencies:

0 → 1

2 → 2

4 → 2

Max frequency = 2

Tie between 2 and 4

Smallest = 2 ✅

Example 2
Input:  nums = [4,4,4,9,2,4]
Output: 4

Example 3
Input:  nums = [29,47,21]
Output: -1


(No even numbers)

✅ Correct Java Code
class Solution {
    public int mostFrequentEven(int[] nums) {

        HashMap<Integer, Integer> freqMap = new HashMap<>();

        // Step 1: Count frequency of even numbers
        for (int num : nums) {
            if (num % 2 == 0) {
                freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
            }
        }

        int maxfreq = 0;
        int ans = -1;

        // Step 2: Find answer
        for (int key : freqMap.keySet()) {
            int freq = freqMap.get(key);

            if (freq > maxfreq) {
                maxfreq = freq;
                ans = key;
            } 
            else if (freq == maxfreq && key < ans) {
                ans = key;
            }
        }

        return ans;
    }
}

🧪 FULL DRY RUN (VERY IMPORTANT)
Input
nums = [0,1,2,2,4,4,1]

Step 1: Build frequency map (only even)

Loop through array:

num	even?	freqMap
0	yes	{0=1}
1	no	{0=1}
2	yes	{0=1, 2=1}
2	yes	{0=1, 2=2}
4	yes	{0=1, 2=2, 4=1}
4	yes	{0=1, 2=2, 4=2}
1	no	unchanged

Final:

freqMap = {0=1, 2=2, 4=2}

Step 2: Initialize
maxfreq = 0
ans = -1

Step 3: Loop over freqMap
🔁 key = 0, freq = 1
1 > 0 → true
maxfreq = 1
ans = 0

🔁 key = 2, freq = 2
2 > 1 → true
maxfreq = 2
ans = 2

🔁 key = 4, freq = 2
2 > 2 → false
2 == 2 AND 4 < 2 → false


So:

ans stays 2

🏁 Final Answer
return 2


✅ Correct

🧠 Key Logic (memorize this)

First maximize frequency, then minimize value

⏱ Complexity

Time: O(n)

Space: O(n)