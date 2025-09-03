

class RotateList {

            public static void main(String[] args) {
      int k = 2;
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
       
        RotateList sol = new RotateList();
        ListNode rotate = sol.rotateRight(head , k);

        System.out.print("  ");
        printList(rotate);
    }
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k==0)  return head;
        int length = 1;
        ListNode tail = head;

        while(tail.next != null)
        {
            tail = tail.next;
            length +=1;
        }
        tail.next = head;

        k = k % length;
        int newtailIndex = length -k;
        ListNode newtail = head;

        for(int i = 1; i < newtailIndex; i++)
        {
            newtail = newtail.next;
        }
        ListNode newHead = newtail.next;
        newtail.next = null;

        return newHead;
    }


    public static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
        System.out.println();
    }

   
}
