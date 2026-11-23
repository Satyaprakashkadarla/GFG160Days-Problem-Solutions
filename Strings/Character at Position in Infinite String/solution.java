
class Solution {
    public char posInfinite(String s, int pos) {

        long len = s.length();
        java.util.ArrayList<Long> lengths = new java.util.ArrayList<>();

        lengths.add(len);

        int step = 1;

        // Calculate lengths until we reach pos
        while (len < pos) {
            len = 2 * len + step;
            lengths.add(len);
            step++;
        }

        // Traverse backwards
        for (int i = lengths.size() - 1; i >= 1; i--) {

            long prev = lengths.get(i - 1);
            long total = lengths.get(i);

            // Position belongs to the original string
            if (pos <= prev) {
                continue;
            }

            // Position belongs to inserted '$' characters
            if (pos <= prev + i) {
                return '$';
            }

            // Position belongs to the reversed string
            pos = (int)(total - pos + 1);
        }

        return s.charAt(pos - 1);
    }
}
