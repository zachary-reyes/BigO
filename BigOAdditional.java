package BigO;

public class BigOAdditional {
    
    /////////////////////////////// 1. 
    
    /**
     * O(b)
     * 
     * @return the product of a and b
     */
    public static int product(int a, int b) {
        int sum = 0;
        for (int i = 0; i < b; i++) {
            sum += a;
        }
        return sum;
    }

    /////////////////////////////// 2. 

    /**
     * O(b)
     * 
     * @return a to the power of b
     */
    public static int power(int a, int b) {
        if (b < 0) {
            return 0; // error
        } else if (b == 0) {
            return 1;
        } else {
            return a * power(a, b - 1);
        }
    }

    /////////////////////////////// 3. 

    /**
     * O(1)
     * @return the remainder of dividing a by b
     */
    public static int mod(int a, int b) {
        if (b <= 0) {
            return -1;
        }
        int div = a / b;
        return a - div * b;
    }

    /////////////////////////////// 4. 

    /**
     * O(a/b)
     * @return the quotient of a & b
     */
    public static int div(int a, int b) {
        int count = 0;
        int sum = b;
        while (sum <= a) {
            sum += b;
            count++;
        }
        return count;
    }

    /////////////////////////////// 5. 

    /**
     * O(log n)
     * 
     * @return the [integer] square root of a number
     */
    public static int sqrt(int n) {
        return sqrt_helper(n, 1, n);
    }

    public static int sqrt_helper(int n, int min, int max) {
        if (max < min) return -1; // no square root

        int guess = (min + max) / 2;
        if (guess * guess == n) {   // found it!
            return guess;
        } else if (guess * guess < n) { // too low
            return sqrt_helper(n, guess + 1, max);  // try higher
        } else {    // too high
            return sqrt_helper(n, min, guess - 1);  // try lower
        }
    }

    /////////////////////////////// 6. 

    /**
     * O(sqrt(n))
     * @return the [integer] square root of a number
     */
    public static int sqrt2(int n) {
        for (int guess = 1; guess * guess <= n; guess++) {
            if (guess * guess == n) {
                return guess;
            }
        }
        return -1;
    }

    /////////////////////////////// 7. 

    /**
     * If a binary search tree is not balanced, how long might it take (worst case) to find an element in it?
     *  
     * Time Complexity: O(N), where N is the number of nodes in the tree.
     * The max time to find an element is the depth tree. The tree could be a straight list downwards and have depth n.
     */

     /////////////////////////////// 8. 

     /**
      * You are looing for a specific value in a binary tree, but the tree is not a binary search tree. What is the time complexity of this?
      *
      * Time Complexity: O(N)
      * Without any ordering property on the nodes, we might have to search through all the nodes.
      */

      /////////////////////////////// 9. 

      /**
       * How long does copying an array take??? 
       * Time Complexity: O(N^2), where N is the number of elements in the array.
       * 
       * The first call to appendToNew takes 1 copy. The second call takes 2 copies. The third call takes 3 copies. And so on. The total time will be the sum of 1 through N.
       * 
       * @return a copy of an array
       */
      public static int[] copyArray(int[] array) {
        int[] copy = new int[0];
        for (int value: array ) {
            copy = appendToNew(copy, value);
        }
        return copy;
      }

      /**
       * 
       * @return new, longer array with value appended to it
       */
      public static int[] appendToNew(int[] array, int value) {
        // copy all elements over to new array
        int[] bigger = new int[array.length + 1];
        for (int i = 0; i < array.length; i++) {
            bigger[i] = array[i];
        }

        // add new element
        bigger[bigger.length - 1] = value;
        return bigger;
      }

      /////////////////////////////// 10. 

      /**
       * 
       * Time Complexity: O(log N)
       * 
       * The runtime will be the number of digits in the number. A number with d digits can have a value up to 10 ^ d. If n = 10 ^ d, then d = log n.
       * 
       * @return the sum of the digits in a number
       * Examples: If n is 10, then 1 + 0 = 1
       */
      public static int sumDigits(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
      }

      /////////////////////////////// 11. 

      public static int numChars = 26;

      /**
       * * HONESTLY DONT EVEN KNOW
       * 
       * Prints all strings of length k where the characters are in sorted order. 
       * Generates all strings of length k, then checks if each is sorted.
       * 
       * Time Complexity: O(K * C^K), where K is the length of the string and C is the number of characters in the alphabet. It takes O(C^K) time to generate each string. Then, we need to check that each of these is sorted, which takes O(K) time.
       */
      public static void printSortedStrings(int remaining) {
        printSortedStrings(remaining, "");
      }

      public static void printSortedStrings(int remaining, String prefix) {
        if (remaining == 0) {
            if (isInOrder(prefix)) {
                System.out.println(prefix);
            }
        } else {
            for (int i = 0; i < numChars; i++) {
                char c = ithLetter(i);
                printSortedStrings(remaining - 1, prefix + c);
            }
        }
      }

      public static boolean isInOrder(String s) {
        for (int i = 1; i < s.length(); i++) {
            int prev = ithLetter(s.charAt(i - 1));
            int curr = ithLetter(s.charAt(i));
            if (prev > curr) {
                return false;
            }
        }
        return true;
      }

      public static char ithLetter(int i) {
        return (char) (((int) 'a') + i);
      }

      /////////////////////////////// 12.
      
      /**
       * HONESTLY DONT KNOW
       * 
       * Time Complexity: O(B log B + A log B)
       * First, we have to sort array b, which takes O(B log B) time. Then, for each element in A, we do binary search in O(log B) time. The second part takes O(A log B) time.
       * 
       * Computes the intersection (the number of elements in common) of two arrays.
       * Assumes that neither array has duplicates.
       * Sorts arrayB, then iterates through arrayA checking (via binary search) if each value is in arrayB
       */

       public static int intersection(int[] a, int[] b) {
        mergesort(b);       // **TODO
        int intersect = 0;

        for (int x: a) {
            if (binarySearch(b,x) >= 0) {    // **TODO
                intersect++;
            }
        }
        return intersect;
       }

    public static void main(String[] args) {
        int[] array1 = {1,2,3,4,5};
        int result 
        // = product(5,3);
        // = power(5, 3);
        // = mod(5, 3);
        // = div(5, 3);
        // = sqrt(100);
        // = sqrt2(100);
        // = copyArray(array1);
        = sumDigits(12);
    //    for (int a : array1){ System.out.println(a);}
    System.out.println(result);
    }
}
