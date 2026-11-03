import java.util.PriorityQueue;

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<ListNode> pq =
            new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));

        // Step 1: Add head of every non-empty list
        for (ListNode node : lists) {
            if (node != null) {
                pq.offer(node);
            }
        }

        // Step 2: Create dummy node
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        // Step 3: Merge lists
        while (!pq.isEmpty()) {

            ListNode node = pq.poll();

            tail.next = node;
            tail = tail.next;

            // Add next node from the same list
            if (node.next != null) {
                pq.offer(node.next);
            }
        }

        return dummy.next;
    }
}