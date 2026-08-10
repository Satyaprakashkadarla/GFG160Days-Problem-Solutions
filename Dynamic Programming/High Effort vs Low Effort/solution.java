class Solution {
    public int maxTask(int[] h, int[] l) {
        int none = 0;
        int low = 0;
        int high = 0;

        for (int i = 0; i < h.length; i++) {
            int prevNone = none;
            int prevBest = Math.max(none, Math.max(low, high));

            // Do nothing today
            int newNone = prevBest;

            // Do low-effort task today
            int newLow = prevBest + l[i];

            // Do high-effort task today
            // Only allowed if yesterday we did nothing
            int newHigh = prevNone + h[i];

            none = newNone;
            low = newLow;
            high = newHigh;
        }

        return Math.max(none, Math.max(low, high));
    }
}