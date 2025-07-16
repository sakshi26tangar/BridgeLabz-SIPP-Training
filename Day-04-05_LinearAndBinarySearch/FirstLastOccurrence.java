public class FirstLastOccurrence {
    public static int[] findFirstLast(int[] arr, int target) {
        int first = -1, last = -1;
        // Find first
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (arr[mid] >= target) r = mid - 1;
            else l = mid + 1;
            if (arr[mid] == target) first = mid;
        }

        l = 0; r = arr.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (arr[mid] <= target) l = mid + 1;
            else r = mid - 1;
            if (arr[mid] == target) last = mid;
        }

        return new int[]{first, last};
    }
}
