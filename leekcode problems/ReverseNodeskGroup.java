
class ReverseNodeskGroup {


    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null) return null;

        ListNode curr = head;
        ListNode prev = null;
        ListNode next = null;
        int c = k;
        while(curr != null && c > 0)
        {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            c--;
        }
        if(curr ==  null && c > 0){
            curr = prev;
            prev = null;
            next = null;
           while(curr != null && c > 0)
        {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
           
        } 
        }
        if(c > 0){
            return prev;
        }
        else{
        head.next = reverseKGroup(curr,k);
        }
        return prev;
    }



    public static void main(String[] args) {
        int k = 2;
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);


        ReverseNodeskGroup sol = new ReverseNodeskGroup();
        ListNode newHead = sol.reverseKGroup(head, k);

        printList(newHead);
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
