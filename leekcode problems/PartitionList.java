

class PartitionList
 {

     public static void main(String[] args) {
      int x = 3;
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next = new ListNode(3);

          System.out.print("Before Partition: ");
         printList(head);
        PartitionList sol = new PartitionList();
        ListNode part = sol.partition(head , x);

        System.out.print(" After Partition: ");
        printList(part);
    }
   public ListNode partition(ListNode head, int x) {
        ListNode beforeHead = new ListNode(0);
        ListNode afterHead = new ListNode(0);

        ListNode before = beforeHead;
        ListNode after =afterHead;

        while(head != null){
            if(head.val < x){
                      before.next = head;
                      before = before.next;
            }
            else{
                after.next = head;
                after = after.next;
            }
            head = head.next;
        }
        after.next = null;
        before.next = afterHead.next;

        return beforeHead.next;
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
 

