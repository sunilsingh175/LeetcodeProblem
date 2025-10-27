import java.util.*;

class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for (char c : tasks) {
            count[c - 'A']++;
        }

        Arrays.sort(count);
        int maxFreq = count[25];
        int idleSlots = (maxFreq - 1) * n;

        for (int i = 24; i >= 0 && idleSlots > 0; i--) {
            idleSlots -= Math.min(maxFreq - 1, count[i]);
        }

        idleSlots = Math.max(0, idleSlots);
        return tasks.length + idleSlots;
    }

    public static void main(String[] args) {
        Solution obj = new Solution();
        char[] tasks = {'A','A','A','B','B','B'};
        int n = 2;
        int result = obj.leastInterval(tasks, n);
        System.out.println("Minimum CPU intervals required: " + result);
    }
}
