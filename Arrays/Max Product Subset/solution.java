import java.math.BigInteger;

class Solution {
    public int findMaxProduct(int[] arr) {

        int n = arr.length;

        if (n == 1) {
            return arr[0];
        }

        int negCount = 0;
        int zeroCount = 0;
        int maxNegative = Integer.MIN_VALUE;

        BigInteger product = BigInteger.ONE;

        for (int x : arr) {
            if (x == 0) {
                zeroCount++;
                continue;
            }

            if (x < 0) {
                negCount++;
                maxNegative = Math.max(maxNegative, x);
            }

            product = product.multiply(BigInteger.valueOf(x));
        }

        // All zeros
        if (zeroCount == n) {
            return 0;
        }

        // One negative and rest zeros
        if (negCount == 1 && zeroCount + negCount == n) {
            return 0;
        }

        // Odd number of negatives -> remove the negative closest to 0
        if ((negCount & 1) == 1) {
            product = product.divide(BigInteger.valueOf(maxNegative));
        }

        BigInteger MOD = BigInteger.valueOf(1000000007L);

        return product.mod(MOD).intValue();
    }
}