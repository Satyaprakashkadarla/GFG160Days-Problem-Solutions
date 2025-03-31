import java.util.*;

public class Solution {
    public int activitySelection(List<Integer> start, List<Integer> finish) {
        int n = start.size();
        List<int[]> activities = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            activities.add(new int[]{finish.get(i), start.get(i)});
        }
        activities.sort(Comparator.comparingInt(a -> a[0]));
        int count = 1;
        int lastFinishTime = activities.get(0)[0];
        for (int i = 1; i < n; i++) {
            if (activities.get(i)[1] > lastFinishTime) {
                count++;
                lastFinishTime = activities.get(i)[0];
            }
        }
        return count;
    }
}
