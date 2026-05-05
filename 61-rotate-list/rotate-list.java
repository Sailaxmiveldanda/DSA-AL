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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0) return head;
        int length = 1;
        ListNode curr = head;
        while(curr.next != null){
            length++;
            curr = curr.next;
        }
        curr.next = head;
        k = k % length;
        int steps = length - k;
        ListNode newtail = head;
        for(int i = 1; i < steps; i++){
            newtail = newtail.next;
        }
        ListNode newhead = newtail.next;
        newtail.next = null;
        return newhead;
    }
}