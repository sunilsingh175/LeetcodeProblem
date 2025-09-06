class Node {
    int val;
    Node next;
    Node random;
    public Node(int val) {
        this.val = val;
    }
}

public class CopyListWithRandomPointer {
    public static void main(String[] args) {
        Node head = new Node(7);
        head.next = new Node(13);
        head.next.next = new Node(11);
        head.next.next.next = new Node(10);
        head.next.next.next.next = new Node(1);

        head.next.random = head;
        head.next.next.random = head.next.next.next.next;
        head.next.next.next.random = head.next.next;
        head.next.next.next.next.random = head;

        System.out.println("Input:  [[7,null],[13,0],[11,4],[10,2],[1,0]]");

        CopyListWithRandomPointer sol = new CopyListWithRandomPointer();
        Node copied = sol.copyRandomList(head);

        System.out.print("Output: ");
        printAsLeetCodeFormat(copied);
    }

   public Node copyRandomList(Node head) {
        if (head == null) return null;

        Node curr = head;
        while (curr != null) {
            Node newNode = new Node(curr.val);
            newNode.next = curr.next;
            curr.next = newNode;
            curr = newNode.next;
        }

        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        curr = head;
        Node newHead = head.next;
        Node newCurr = newHead;
        while (curr != null) {
            curr.next = newCurr.next;
            curr = curr.next;
            if (curr != null) {
                newCurr.next = curr.next;
                newCurr = newCurr.next;
            }
        }

        return newHead;
    }


    public static void printAsLeetCodeFormat(Node head) {
        java.util.List<String> result = new java.util.ArrayList<>();
        java.util.Map<Node, Integer> indexMap = new java.util.HashMap<>();
        Node curr = head;
        int index = 0;
        while (curr != null) {
            indexMap.put(curr, index++);
            curr = curr.next;
        }
        curr = head;
        while (curr != null) {
            String randomIndex = (curr.random != null) ?
                                  String.valueOf(indexMap.get(curr.random)) : "null";
            result.add("[" + curr.val + "," + randomIndex + "]");
            curr = curr.next;
        }
        System.out.println(result);
    }
}
