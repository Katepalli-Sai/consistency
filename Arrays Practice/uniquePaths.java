import java.util.*;
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] dp = new int[n][m];
        for(int i=0;i<n;i++){
            dp[i]= 1;
        }
        for(int j=0;j<n;j++){
            dp[j] = 1;
        }
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                dp[i][j] = dp[i][j-1]+dp[i-1][j];
            }
        }
        System.out.println(dp[n-1][m-1]);
    }
}

Perfect 👍
Now I’ll explain this **problem itself** from **zero**, not the code first.
We’ll understand **what the problem is**, **why DP is needed**, and then **how the solution works**, with **clear input/output examples**.

---

# 🧩 Problem: Unique Paths in a Grid

## 🔹 Problem statement (in simple English)

You are standing at the **top-left corner** of a grid.

The grid has:

* `n` rows
* `m` columns

You want to reach the **bottom-right corner**.

### Rules:

* You can move **only right** ➡️
* You can move **only down** ⬇️
* No diagonal, no backward

### Task:

👉 **Count how many different paths** you can take to reach the destination.

---

## 📥 Input format

```
n m
```

Where:

* `n` = number of rows
* `m` = number of columns

---

## 📤 Output format

```
Number of unique paths
```

---

## 🧪 Example 1

### Input:

```
3 3
```

### Grid looks like this:

```
S  .  .
.  .  .
.  .  D
```

S = Start `(0,0)`
D = Destination `(2,2)`

---

### Possible paths (visual idea)

You must move:

* **2 times right**
* **2 times down**

Different orders = different paths.

Examples:

1. ➡️ ➡️ ⬇️ ⬇️
2. ➡️ ⬇️ ➡️ ⬇️
3. ➡️ ⬇️ ⬇️ ➡️
4. ⬇️ ➡️ ➡️ ⬇️
5. ⬇️ ➡️ ⬇️ ➡️
6. ⬇️ ⬇️ ➡️ ➡️

### Output:

```
6
```

---

## 🧠 Key idea (VERY IMPORTANT)

To reach **any cell (i, j)**, you can come from only:

* **Top cell** `(i-1, j)`
* **Left cell** `(i, j-1)`

So:

```
Number of ways to reach (i, j)
= ways from top + ways from left
```

That is the heart of the problem.

---

## 📐 Why Dynamic Programming?

Because:

* Many paths overlap
* We don’t want to calculate same paths again and again

So we **store results** in a table.

---

## 🧱 DP Table Meaning

`dp[i][j]` means:

> Number of ways to reach cell `(i, j)` from `(0,0)`

---

## 🪜 Step-by-step DP Table Filling

### Step 1: First row

You can only move **right**, so:

```
dp[0][j] = 1
```

---

### Step 2: First column

You can only move **down**, so:

```
dp[i][0] = 1
```

---

### Step 3: Remaining cells

Use formula:

```
dp[i][j] = dp[i-1][j] + dp[i][j-1]
```

---

## 🧪 Example 2 (Fully Explained)

### Input:

```
3 4
```

Grid:

```
.  .  .  .
.  .  .  .
.  .  .  .
```

---

### Step-by-step DP table

| i\j | 0 | 1 | 2 | 3  |
| --- | - | - | - | -- |
| 0   | 1 | 1 | 1 | 1  |
| 1   | 1 | 2 | 3 | 4  |
| 2   | 1 | 3 | 6 | 10 |

---

### Final answer:

```
10
```

---

## 🧠 Visual understanding

Each cell is the **sum of top and left**:

```
      1   1   1   1
      1   2   3   4
      1   3   6  10
```

---

## 🧠 One-line explanation (Interview ready)

> “Each cell’s paths depend on the number of paths from the top and left, so we build the solution using dynamic programming.”

---

## 🧪 Edge cases

| Input | Output | Reason               |
| ----- | ------ | -------------------- |
| 1 1   | 1      | Start is destination |
| 1 m   | 1      | Only right moves     |
| n 1   | 1      | Only down moves      |

---

## 🧠 Memory Tip (VERY IMPORTANT)

> **Grid problems → think top + left**

---

## 🔚 Summary

* This is a **counting paths** problem
* Use **DP table**
* Formula: `dp[i][j] = dp[i-1][j] + dp[i][j-1]`
* Time: `O(n*m)`
* Space: `O(n*m)`

---

If you want, next we can:

* Do a **manual dry run together**
* Convert this to **1D DP**
* Or solve **with recursion first**, then DP

Just tell me 👍
