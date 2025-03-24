import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public int countDays(int days, int[][] meetings) {
        // Sort the meetings by their start time
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));

        // List to hold merged intervals
        List<int[]> merged = new ArrayList<>();

        // Merge overlapping and adjacent intervals
        for (int[] meeting : meetings) {
            if (merged.isEmpty() || merged.get(merged.size() - 1)[1] < meeting[0] - 1) {
                merged.add(meeting);
            } else {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], meeting[1]);
            }
        }

        // Calculate the total number of days with meetings
        int totalMeetingDays = 0;
        for (int[] interval : merged) {
            totalMeetingDays += (interval[1] - interval[0] + 1);
        }

        // The number of days without meetings
        return days - totalMeetingDays;
    }
}
