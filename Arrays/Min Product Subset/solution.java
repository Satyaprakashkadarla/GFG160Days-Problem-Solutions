import java.util.*;

class Solution {
    public int minProd(int[] arr) {
        List<Integer> neg = new ArrayList<>();
        List<Integer> pos = new ArrayList<>();
        boolean hasZero = false;

        for (int num : arr) {
            if (num < 0) neg.add(num);
            else if (num > 0) pos.add(num);
            else hasZero = true;
        }

        Collections.sort(neg);
        Collections.sort(pos);

        // If no negative numbers
        if (neg.isEmpty()) {
            if (hasZero) return 0;
            return pos.get(0); // smallest positive
        }

        // If odd number of negatives, multiply all negatives and all positives
        if (neg.size() % 2 == 1) {
            int product = 1;
            for (int n : neg) product *= n;
            for (int p : pos) product *= p;
            return product;
        }

        // Even number of negatives
        // Option 1: Use all negatives (gives positive product) + smallest positive = positive
        // Option 2: Remove the largest negative (closest to zero) to get odd count
        // Option 3: If there's a zero, we can get 0

        // Remove the largest negative (closest to zero)
        int product1 = 1;
        for (int i = 0; i < neg.size() - 1; i++) {
            product1 *= neg.get(i);
        }
        for (int p : pos) product1 *= p;

        // If we have a zero, we can get 0
        if (hasZero) {
            return Math.min(product1, 0);
        }

        // Also consider using all negatives (positive product) with smallest positive
        int product2 = 1;
        for (int n : neg) product2 *= n;
        if (!pos.isEmpty()) {
            product2 *= pos.get(0);
        }

        return Math.min(product1, product2);
    }
}