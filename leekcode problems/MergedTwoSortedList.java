// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
// function used in leetcode  
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode returnNode = new ListNode(Integer.MIN_VALUE); // dummy head
        ListNode headNode = returnNode;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                returnNode.next = list1;
                list1 = list1.next;
            } else {
                returnNode.next = list2;
                list2 = list2.next;
            }
            returnNode = returnNode.next;
        }

        if (list1 == null) {
            returnNode.next = list2;
        } else {
            returnNode.next = list1;
        }

        return headNode.next;
    }
}

public class MergedTwoSortedList {
    public static void main(String[] args) {
        // Input: list1 = [1,2,4], list2 = [1,3,4]
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));

        Solution sol = new Solution();
        ListNode mergedList = sol.mergeTwoLists(list1, list2);

        // Print merged list
        printList(mergedList);
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
}
