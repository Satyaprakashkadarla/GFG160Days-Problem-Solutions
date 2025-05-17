class Solution {
    public ArrayList<Integer> sortArray(int[] arr, int A, int B, int C) {
        ArrayList<Integer> result = new ArrayList<>();

        // Traverse each element in the input array
        for (int x : arr) {
            // Apply the quadratic function: A*x^2 + B*x + C
            int ans = A * x * x + B * x + C;
            result.add(ans); // Store the result in the list
        }

        // Sort the transformed list
        Collections.sort(result);

        return result; // Return the sorted list
    }
}