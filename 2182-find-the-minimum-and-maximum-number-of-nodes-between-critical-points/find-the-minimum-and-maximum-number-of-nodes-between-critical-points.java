/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return new int[]{-1, -1};
        }

        List<Integer> criticalPts = new ArrayList<>();
        ListNode prev = null;
        ListNode curr = head;
        int pos = 0;

        while (curr != null && curr.next != null) {
            // 1. Traverse and find points
            if (prev != null) {
                // 2. Check local min and max and record position
                if ((curr.val > prev.val && curr.val > curr.next.val) ||
                    (curr.val < prev.val && curr.val < curr.next.val)) {
                    criticalPts.add(pos);
                }
            }
            prev = curr;
            curr = curr.next;
            pos++;
        }

        if (criticalPts.size() < 2) {
            return new int[]{-1, -1};
        }

        // 3. Calculate Distances
        int minDist = Integer.MAX_VALUE;
        int maxDist = criticalPts.get(criticalPts.size() - 1) - criticalPts.get(0);

        for (int i = 1; i < criticalPts.size(); i++) {
            minDist = Math.min(minDist, criticalPts.get(i) - criticalPts.get(i - 1));
        }

        // return ans
        return new int[]{minDist, maxDist};
    }
}