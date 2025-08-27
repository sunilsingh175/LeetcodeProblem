
class RemoveDuplicateList {

 public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);
        head.next.next.next.next.next = new ListNode(4);
  
ListNode result = deleteDuplicates(head);
        printList(result); 
        }

 public static void printList(ListNode head) {
        ListNode curr = head;
        while(curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
        
}
     public static ListNode deleteDuplicates(ListNode head) {
        if(head == null) return null;
        ListNode prev = head;
        ListNode temp = prev.next;

        while(temp!=null)
        {
            if(prev.val == temp.val)
            {
                temp = temp.next;
                continue;
            }

            prev.next = temp;
            prev = temp;
            temp = temp.next;
        }
        prev.next = null;
        return head;
    }

}
