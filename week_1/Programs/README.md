**README - Programs Folder**

**Overview**

This folder contains two Java programs that solve mathematical problems efficiently.

**Problem Statements**

**1. RemainderQuotient.java**

**Problem:** Given a dividend and a divisor, compute the quotient and remainder without using the division (/) or modulus (%) operators.

**Approach:**

 -> Uses recursion to subtract the divisor from the dividend until the dividend becomes smaller than the divisor.
  
 -> Counts the number of subtractions to determine the quotient.
  
 -> The remainder is the leftover value of the dividend.
  
 -> Time Complexity: O(N) where N is the quotient value.

**Example Test Cases:**

**Input:**
Dividend = 10
Divisor = 3

**Output:**
The quotient is: 3
The remainder is: 1






**2. TrailingZerosInFactorial.java**

**Problem:** Given a number N, find the number of trailing zeros in N! (N factorial).

**Approach:**

  -> A trailing zero is produced by a factor of 10, which comes from pairs of 2 and 5.
  
  -> Since multiples of 2 are more frequent than multiples of 5, we count the number of factors of 5 in N!.
  
  -> Uses a loop to count factors of 5, 25, 125, etc.
  
  -> Time Complexity: O(log N) due to the division by powers of 5.

**Example Test Cases:**

**Input:**
N = 10

**Output:**
The number of trailing zeros in the factorial of 10 is 2

**Compilation & Execution**

To compile the programs, use:

**javac RemainderQuotient.java
javac TrailingZerosInFactorial.java**

To run the programs, use:

**java Programs.RemainderQuotient
java Programs.TrailingZerosInFactorial**

**Notes**

    -> Ensure valid input is provided to avoid exceptions.
    
    -> The RemainderQuotient program throws an exception for a divisor of zero.
    
    -> The TrailingZerosInFactorial program handles only non-negative integers.
