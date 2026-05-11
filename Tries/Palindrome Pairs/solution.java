class Solution {

    public boolean palindromePair(String[] arr) {

        int n = arr.length;

        HashMap<String, Integer> map = new HashMap<>();

        // Store string with index
        for (int i = 0; i < n; i++) {
            map.put(arr[i], i);
        }

        for (int i = 0; i < n; i++) {

            String s = arr[i];
            int len = s.length();

            for (int cut = 0; cut <= len; cut++) {

                String left = s.substring(0, cut);
                String right = s.substring(cut);

                // Case 1:
                // left palindrome
                if (isPalindrome(left)) {

                    String revRight =
                            new StringBuilder(right).reverse().toString();

                    if (map.containsKey(revRight)
                            && map.get(revRight) != i) {

                        return true;
                    }
                }

                // Case 2:
                // right palindrome
                if (cut != len && isPalindrome(right)) {

                    String revLeft =
                            new StringBuilder(left).reverse().toString();

                    if (map.containsKey(revLeft)
                            && map.get(revLeft) != i) {

                        return true;
                    }
                }
            }
        }

        return false;
    }

    private boolean isPalindrome(String s) {

        int l = 0;
        int r = s.length() - 1;

        while (l < r) {

            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }

            l++;
            r--;
        }

        return true;
    }
}