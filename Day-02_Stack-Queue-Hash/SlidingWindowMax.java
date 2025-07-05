import java.util.*;

class SlidingWindowMax {
    static List<Integer> maxInWindows(int[] nums, int k) {
        Deque<Integer> dq = new LinkedList<>();
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            while (!dq.isEmpty() && dq.peekFirst() <= i - k)
                dq.pollFirst();

            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i])
                dq.pollLast();

            dq.addLast(i);

            if (i >= k - 1)
                result.add(nums[dq.peekFirst()]);
        }

        return result;
    }
}

