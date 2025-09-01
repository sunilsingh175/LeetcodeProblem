  public class removeNthNodeEnd
        {
public static void main(String[] args) {
        int n = 2;
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(6);
        head.next.next.next.next = new ListNode(9);
        head.next.next.next.next.next = new ListNode(5);
     
       

       removeNthNodeEnd sol = new removeNthNodeEnd();
        ListNode result = sol.removeNthFromEnd(head , n);

        
        printList(result);

    }
   
    
      public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode ptr1 = dummy;
        ListNode ptr2 = dummy;

       for( int i = 0; i<n; i++)
       {
        ptr2 = ptr2.next;

       }
       while(ptr2.next != null)
       {
        ptr1 = ptr1.next;
        ptr2 = ptr2.next;
       }
       ptr1.next = ptr1.next.next;
        return dummy.next;
}
       public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) System.out.print("  ");
            head = head.next;
        }
        System.out.println();
    }

}