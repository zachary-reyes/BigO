package BigO;
import java.util.Arrays;

public class BigOIntro {

    ///////////////////////
    // Space Complexity  //
    ///////////////////////

    /*
     * Time Complexity:     O(n)
     * Space Complexity:    O(n)
     * 
     * Calculate the sum of all positive integers from 1 up to the given positive integer n. 
     */
    public static int sum(int n) {
        if (n <= 0) {
            return 0;
        }
        return n + sum(n-1);
    }

    /**
     * Time Complexity:     O(n)
     * Space Complexity:    O(1)
     * 
     * Calculate a sequence of pair sums based on the given integer n and return the cumulative sum of those pair sums 
     */
    public static int pairSumSequence(int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += pairSum(i, i+1);
        }
        return sum;
    }
    private static int pairSum(int i, int j) {
        return i+j;
    }

    /////////////////////////
    // Drop the Constants  //
    /////////////////////////

    /**
     * The purpose of writing these two functions is to show that sometimes its better to ignore 
     * constants in determing runtime b/c it can just lead to confusion...these are both O(N) leave it at that
     * 
     * Find the minimum and maximum values from an input array of integers and print them to the console
     */
    public static void setMinAndMax1(int[] array) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int x : array) {
            if (x < min) min = x;
            if (x > max) max = x;
        }
        System.out.println("min: " + min + ", max: " + max);
    }
    public static void setMinAndMax2(int[] array) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int x : array) {
            if (x < min) min = x;    
        }
        for (int x : array) {
            if (x > max) max = x;    
        }
        System.out.println("min: " + min + ", max: " + max);
    }

    ////////////////////////////////////////////
    // Multipart Algorithms: Add or Multiply  //
    ////////////////////////////////////////////

    /**
     * Time Complexity:     O(A + B)
     * 
     * Print the elements of two arrays to the console
     */
    public static void addTheRuntime(int[] arrayA, int[] arrayB) {
        for (int a : arrayA) {
            System.out.print(a + " ");
        }
        System.out.println();
        for (int b : arrayB) {
            System.out.print(b + " ");
        }
        System.out.println();
    }

    /**
     * Time Complexity:     O(A * B)
     * 
     * Print the cartesian product of two integer arrays arrA and arrB to the console. 
     * The cartesian product is obtained by combining each element of arrA with each element of arrB, resulting in all possible pairs.
     */
    public static void multRunTimes(int[] arrA, int[] arrB) {
        for (int a : arrA) {
            for (int b : arrB) {
                System.out.println(a + "," + b);
            }
        }
    }

    /////////////////////
    // Log N Runtimes  //
    /////////////////////

    /**
     *  Time Complexity: O(Log N) 
     *
     * Takes a sorted integer array and a target integer as input parameters.
     * The method returns the index of the target element if found in the array or -1 if the target is not present.
     */
    public static int binarySearch(int[] array, int target) {
        Arrays.sort(array);
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (array[middle] == target) {
                return middle;
            } else if (array[middle] < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return -1;
    }

    /////////////////////////
    // Recursive Runtimes  //
    /////////////////////////

    /*
     * Time Complexity: O(2^N)
     * Space Complexity: O(N)
     * 
     * Calculates the result of a specific mathematical sequence
     */
    public static int f(int n) {
        if (n <= 1) {
            return 1;
        }
        return f(n - 1) + f(n - 1);
    }

    public static void main(String[] args) {
        int[] arrayA = {12,43,16,43,87,45,9};
        int[] arrayB = {1,2,3,4,5,6,7,8,9,0};
        int result 
            // = sum(5);
            // = pairSumSequence(5);
            // = binarySearch(arrayA, 45);
            = f(4);
        // setMinAndMax1(arrayA);
        // setMinAndMax2(arrayA);
        // addTheRuntime(arrayA, arrayB);
        // multRunTimes(arrayA, arrayB);
        System.out.println("Result: " + result);
    }
}