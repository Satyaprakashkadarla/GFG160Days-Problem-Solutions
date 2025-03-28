class Solution {
public:
    int activitySelection(vector<int> &start, vector<int> &finish) {
        int n = start.size();
        vector<pair<int, int>> activities;
                for (int i = 0; i < n; i++) {
            activities.push_back({finish[i], start[i]});
        }
                sort(activities.begin(), activities.end());
        int count = 1; 
        int lastFinishTime = activities[0].first;
        for (int i = 1; i < n; i++) {
            if (activities[i].second > lastFinishTime) {
                count++;
                lastFinishTime = activities[i].first;
            }
        }
        return count;
    }
};
