

class RemoveDuplicatesfromSortedListII
 {

            public static void main(String[] args) {
      
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next = new ListNode(5);

          System.out.print("Before removing : ");
         printList(head);
        RemoveDuplicatesfromSortedListII sol = new RemoveDuplicatesfromSortedListII();
        ListNode Remove = sol.deleteduplicates(head);

        System.out.print(" After removing: ");
        printList(Remove);
    }
    public ListNode deleteduplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode curr = head;


          while(curr != null)
       {
        if(curr.next != null && curr.val == curr.next.val) {
            while (curr.next != null && curr.val == curr.next.val)
           {

           curr = curr.next;
           }
            
            prev.next = curr.next;
         }
          else
            {
               prev = prev.next;
             }

        curr = curr.next;
        }

      return dummy.next;

         }

   
public static void printList(ListNode head) {
    ListNode curr = head;
    while (curr != null) {
        System.out.print(curr.val);
        if (curr.next != null) {
            System.out.print("->");
        }
        curr = curr.next;
    }
    System.out.println();
}


   
}
