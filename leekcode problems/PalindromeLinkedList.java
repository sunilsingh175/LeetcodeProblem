
class PalindromeLinkedList {
    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        // Step 1: Find the middle using slow & fast pointers
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: If odd length, skip the middle node
        if (fast != null) {
            slow = slow.next;
        }

        // Step 3: Reverse second half
        slow = reverseList(slow);

        // Step 4: Compare both halves
        fast = head;
        while (slow != null) {
            if (fast.val != slow.val) {
                return false;
            }
            fast = fast.next;
            slow = slow.next;
        }

        return true;
    }

    // Helper function to reverse a linked list
    private static ListNode reverseList(ListNode head) {
        ListNode prev = null, curr = head;
        while (curr != null) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }

    // ✅ Main method to test
    public static void main(String[] args) {
        // Create linked list: 1 -> 2 -> 2 -> 1
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);


        System.out.println(isPalindrome(head));  // true

      
    }
}
