package main.java.algorithm;

import java.util.Arrays;
import java.util.Stack;

/**
 * The stock span problem is a financial problem where we have a series of n daily price quotes for a stock
 * and we need to calculate the span of the stock’s price for all n days.
 * The span Si of the stock’s price on a given day i is defined as the maximum number of consecutive days just before the given day,
 * for which the price of the stock on the current day is less than its price on the given day.
 *
 * Example:
 *
 * Input: N = 7, price[] = [100 80 60 70 60 75 85]
 * Output: 1 1 1 2 1 4 6
 * Explanation: Traversing the given input span for 100 will be 1, 80 is smaller than 100 so the span is 1,
 * 60 is smaller than 80 so the span is 1, 70 is greater than 60 so the span is 2 and so on.
 * Hence the output will be 1 1 1 2 1 4 6.
 *
 * Input: N = 6, price[] = [10 4 5 90 120 80]
 * Output:1 1 2 4 5 1
 * Explanation: Traversing the given input span for 10 will be 1, 4 is smaller than 10 so the span will be 1,
 * 5 is greater than 4 so the span will be 2 and so on. Hence, the output will be 1 1 2 4 5 1.
 *
 * Inspired on the code contributed by <a href="https://www.geeksforgeeks.org/the-stock-span-problem/">Sumit Ghosh</a>
 */
public class StockSpanProblem {

    static void calculateSpan(int[] price, int days, int[] stockSpan) {
        // Create a stack and push index of first element to it
        Stack<Integer> st = new Stack<>();
        st.push(0);

        // Span value of first element is always 1, since there is no date before it.
        stockSpan[0] = 1;

        // Calculate span values for rest of the elements
        for (int idx = 1; idx < days; idx++) {

            // Pop elements from stack while stack is not
            // empty and top of stack is smaller than
            // price[idx]
            while (!st.isEmpty() && price[st.peek()] <= price[idx]) {
                st.pop();
            }

            // If stack becomes empty, then price[idx] is
            // greater than all elements on left of it, idx.e.,
            // price[0], price[1], ..price[idx-1].
            // Else price[idx] is greater than elements after top of stack
            stockSpan[idx] = (st.isEmpty()) ? (idx + 1) : (idx - st.peek());

            // Push this element to stack
            st.push(idx);
        }
    }

    // A utility function to print elements of array
    static void printArray(int[] arr) {
        System.out.print(Arrays.toString(arr));
    }

    // Driver method
    public static void main(String[] args) {
        int[] price = {10, 4, 5, 90, 120, 80};
        int days = price.length;
        int[] S = new int[days];

        // Fill the span values in array S[]
        calculateSpan(price, days, S);

        // print the calculated span values
        printArray(S);
    }
}
