class Solution {
    public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
        int n = deadline.length;
        Job[] jobs = new Job[n];
        for (int i = 0; i < n; i++) {
            jobs[i] = new Job(deadline[i], profit[i]);
        }
        Arrays.sort(jobs, (a, b) -> b.profit - a.profit);
        int maxDeadline = 0;
        for (int i = 0; i < n; i++) {
            maxDeadline = Math.max(maxDeadline, jobs[i].deadline);
        }
        boolean[] timeSlot = new boolean[maxDeadline + 1];
        int totalProfit = 0;
        int jobCount = 0;
        for (int i = 0; i < n; i++) {
            for (int j = jobs[i].deadline; j > 0; j--) {
                if (!timeSlot[j]) {  // If the time slot is free
                    timeSlot[j] = true;  // Mark this slot as taken
                    totalProfit += jobs[i].profit;
                    jobCount++;
                    break;
                }
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        result.add(jobCount);   // Number of jobs completed
        result.add(totalProfit); // Total profit
        return result;
    }
    class Job {
        int deadline;
        int profit;
        Job(int deadline, int profit) {
            this.deadline = deadline;
            this.profit = profit;
        }
    }
}
