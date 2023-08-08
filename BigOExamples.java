package BigO;
import java.util.Arrays;

public class BigOExamples {

    /*
     *  Example 1: 
     *  Calculates and prints two results from the given integer array: the sum of all elements and the product of all elements.
     * 
     *  Time Complexity: O(N)
     */
    public static void foo(int[] array) {
        int sum = 0;
        int product = 1;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        for (int i = 0; i < array.length; i++) {
            product *= array[i];
        }
        System.out.println("Sum: " + sum + ", Product: " + product);
    }

    /*
     *  Example 2: 
     *  Prints all possible pairs of elements from the given integer array. 
     * 
     *  Time Complexity: O(N^2)
     */
    public static void printPairs(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                System.out.println(array[i] + ", " + array[j]);
            }
        }
    }

    /*
     *  Example 3: 
     *  Prints all unordered pairs of elements from the given integer array. 
     *  An unordered pair consists of two elements from the array, but it avoids printing pairs in which the same two elements are in different orders.
     * 
     *  Time Complexity: O(N^2)
     */
    public static void printUnorderedPairs(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                System.out.println(array[i] + ", " + array[j]);
            }
        }
    }

    /*
     *  Example 4: 
     *  Prints all unordered pairs of elements where the element from arrayA is smaller than the element from arrayB.
     * 
     *  Time Complexity: O(N*M)
     */
    public static void printUnorderedPairs2(int[] arrayA, int[] arrayB) {
        for (int i = 0; i < arrayA.length; i++) {
            for (int j = 0; j < arrayB.length; j++) {
                if (arrayA[i] < arrayB[j]) {
                    System.out.println(arrayA[i] + ", " + arrayB[j]);
                }
            }
        }
    }

    /*
     *  Example 5: 
     *  Prints all unordered pairs of elements from the two input integer arrays. 
     *  However, there is an additional inner loop that iterates 100000 times. This means that for each pair of elements from arrayA and arrayB, the inner loop prints the same pair 100000 times. 
     * 
     * Time Complexity: O(N*M)
     */
    public static void printUnorderedPairs3(int[] arrayA, int[] arrayB) {
        for(int i = 0; i < arrayA.length; i++) {
            for (int j = 0; j < arrayB.length; j++) {
                for (int k = 0; k < 100000; k++) {
                    System.out.println(arrayA[i] + ", " + arrayB[j]);
                }
            }
        }
    }

    /*
     *  Example 6: 
     *  Reverse the order of elements in the input integer array. 
     *  Swaps the elements at the beginning and end of the array, then the elements at the second position from the beginning and second position from the end, and so on, until it reaches the middle of the array.
     * 
     * Time Complexity: O(N)
     */
    public static void reverse(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            int other = array.length - i - 1;
            int temp = array[i];
            array[i] = array[other];
            array[other] = temp;
        }
    }

    /*
     * Example 7:
     * Which of the following are equivalent to O(N)? Why?
     * 
     * O(N + P), where P < N/2 
     * O(2 * N)
     * O(N + log N)
     * O(N + M)
     * 
     * All but the last one, since there is no established relationship between N and M
     */

     /*
      * Example 8:
      * Suppose we had an algorithm that took in an array of strings, sorted each string, and then sorted the full array. What would the runtime be?
      * 
      * Let's define new terms-and use names that are logical.
      *     Let s be the length of the longest string.
      *     Let a be the length of the array.
      * Now we can work through this in parts:
      *     Sorting each string is O(s log s).
      *     We have to do this for every string (and there are a strings),so that's O(a*s log s).
      *     Now we have to sort all the strings.There are a strings,so you'll may be inclined to say that this takes O(a log a) time. This is what most candidates would say. You should also take into account that you need to compare the strings.Each string comparison takes O(s) time.There are O(a log a) comparisons, therefore this will take O(a*s log a) time.
      * If you add up these two parts, you get O(a*s(log a + log s)). 
      * This is it.There is no way to reduce it further.
      */

    /*
     * Example 9: 
     * Sums the values of all the nodes in a balanced binary search tree
     * 
     * Time Complexity: O(N), where N is the number of nodes
     */
    public static int sum(Node node) {
       if (node == null) {
        return 0;
       } 
       return sum(node.getLeft()) + node.getData() + sum(node.getRight());
    }

    /*
     * Example 10: 
     * Checks if a number is prime by checking for divisibility on numbers less than it. It only needs to go up to the square root of n because if n is divisible by a number greater than its square root then it's divisible by something smaller than it.
     * 
     * Time Complexity: O(sqrt(N))
     */
    public static boolean isPrime(int n) {
        for (int x = 2; x * x <= n; x++) {
            if (n % x == 0) {
                return false;
            }
        }
        return true;
    }

    /*
     * Example 11: 
     * Computes n! (n factorial)
     * 
     * Time Complexity: O(N) 
     */
    public static int factorial(int n) {
        if (n < 0) {
            return -1;
        } else if (n == 0) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    /*
     * Example 12: 
     * Counts all permutations of a string
     * 
     * Time Complexity: O(N^2 * N!)
     */
    public static void permutation(String str) {
        permutation(str, "");
    }

    public static void permutation(String str, String prefix) {
        if (str.length() == 0) {
            System.out.println(prefix);
        } else {
            for (int i = 0; i < str.length(); i++) {
                String rem = str.substring(0, i) + str.substring(i + 1);
                permutation(rem, prefix + str.charAt(i));
            }
        }
    }

    /*
     * Example 13: 
     * Computes the Nth Fibonacci number.
     * 
     * Time Complexity: O(2^N)
     *  Generally speaking, when you see an algorithm with multiple recursive calls, you're looking at exponential runtime.
     */
    public static int fib(int n) {
        if (n <= 0) return 0;
        else if (n == 1) return 1;
        return fib(n - 1) + fib(n - 2);
    }

    /*
     * Example 14: 
     * Prints all Fibonacci numbers from 0 to n
     * 
     * Time Complexity: O(2^N)
     */
    public static void allFib(int n) {
        for (int i = 0; i < n; i++) {
            System.out.println(i + ": " + fib(i));
        }
    }

    /*
     * Example 15: 
     * Prints all Fibonacci numbers from 0 - n.
     * However, this time, it stores previously computed values in an integer array. If if has already been computed, it just returns the cache.
     * 
     * Time Complexity: O(N)
     * This technique, called memoization, is a very common one to optimize exponential time recursive algorithms
     */
    public static void allFib2(int n) {
        int[] memo = new int[n + 1];
        for(int i = 0; i < n; i++){
            System.out.println(i + ": "+ fib2(i, memo));
        }
    }

    public static int fib2(int n, int[] memo) {
        if (n <= 0) return 0;
        else if (n == 1) return 1;
        else if (memo[n] > 0) return memo[n];

        memo[n] = fib2(n - 1, memo) + fib2(n - 2, memo);
        return memo[n];
    }

    /*
     * Example 16: 
     * Prints the powers of 2 from 1 through n (inclusive)
     * 
     * Time Complexity: O(log N)
     */
    public static int powersOf2(int n) {
        if (n < 1) {
            return 0;
        } else if ( n == 1) {
            System.out.println(1);
            return 1;
        } else {
            int prev = powersOf2(n/2);
            int curr = prev * 2;
            System.out.println(curr);
            return curr;
        }
    }
    
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6};
        int[] array2 = {5,10,15};
        // foo(array);
        // printPairs(array);
        // printUnorderedPairs(array2);
        // printUnorderedPairs2(array2,array);
        // printUnorderedPairs3(array,array2);
        // boolean result = isPrime(30);
        // int result = factorial(5);
        int result = powersOf2(8);
        System.out.println(result);
        // permutation("abc");
        // allFib(8);
        // allFib2(8);
        
    }
}

