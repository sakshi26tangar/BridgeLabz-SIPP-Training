import java.util.*;

class StockSpan {
    static int[] calculateSpan(int[] prices) {
        Stack<Integer> stack = new Stack<>();
        int n = prices.length;
        int[] span = new int[n];

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && prices[stack.peek()] <= prices[i])
                stack.pop();
            span[i] = stack.isEmpty() ? (i + 1) : (i - stack.peek());
            stack.push(i);
        }
        return span;
    }
}
