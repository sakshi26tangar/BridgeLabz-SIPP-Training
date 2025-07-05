import java.util.*;

class SortStack {
    static void sort(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            int x = stack.pop();
            sort(stack);
            insert(stack, x);
        }
    }

    static void insert(Stack<Integer> stack, int x) {
        if (stack.isEmpty() || x > stack.peek()) {
            stack.push(x);
        } else {
            int y = stack.pop();
            insert(stack, x);
            stack.push(y);
        }
    }
}
