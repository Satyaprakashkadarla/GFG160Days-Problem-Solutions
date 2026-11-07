
import java.util.*;

class Solution {
    public ArrayList<String> generateUsernames(String[] arr) {

        HashSet<String> used = new HashSet<>();
        HashMap<String, Integer> next = new HashMap<>();

        // Initially reserve all usernames
        for (String s : arr) {
            used.add(s);
        }

        ArrayList<String> ans = new ArrayList<>();

        for (String s : arr) {

            // First occurrence: keep unchanged
            if (!next.containsKey(s)) {
                ans.add(s);
                next.put(s, 1);
            } 
            else {
                int k = next.get(s);
                String candidate = s + k;

                // Find smallest available suffix
                while (used.contains(candidate)) {
                    k++;
                    candidate = s + k;
                }

                ans.add(candidate);
                used.add(candidate);

                next.put(s, k + 1);
            }
        }

        return ans;
    }
}
