import java.util.*;

class Solution {
    public int leastInterval(char[] tasks, int n) {

        int[] freq = new int[26];

        // Count frequency of each task
        for (char ch : tasks) {
            freq[ch - 'A']++;
        }

        // Max Heap
        PriorityQueue<Integer> pq =
            new PriorityQueue<>(Collections.reverseOrder());

        for (int f : freq) {
            if (f > 0) {
                pq.offer(f);
            }
        }

        int time = 0;

        while (!pq.isEmpty()) {

            List<Integer> temp = new ArrayList<>();

            // Execute at most n + 1 tasks in one cycle
            for (int i = 0; i <= n; i++) {

                if (!pq.isEmpty()) {
                    int count = pq.poll();

                    if (count > 1) {
                        temp.add(count - 1);
                    }
                }

                time++;

                if (pq.isEmpty() && temp.isEmpty()) {
                    return time;
                }
            }

            // Add remaining frequencies back
            for (int count : temp) {
                pq.offer(count);
            }
        }

        return time;
    }
}