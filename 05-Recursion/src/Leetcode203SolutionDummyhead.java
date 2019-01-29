import java.util.List;

class Leetcode203SolutionDummyhead {
    public ListNode removeElements(ListNode head, int val){
        ListNode dummyHead = new ListNode( -1 );
        dummyHead.next = head;


        ListNode prev = dummyHead;
        while(prev.next != null){
            if(prev.next.val == val)
                prev.next = prev.next.next;
            else
                prev = prev.next;
        }


//        while(dummyHead.next != null){
//            if(dummyHead.next.val == val)
//                dummyHead.next = dummyHead.next.next;
//            else
//                dummyHead = dummyHead.next;
//        }

        return dummyHead.next;
    }

    public static void main (String args[]){
        int[] arr = {1,2,3,6,7,8,6};
        ListNode ln = new ListNode(arr);
        System.out.println(ln);
        ListNode res = (new Leetcode203SolutionDummyhead()).removeElements(ln, 6);
        System.out.println(res);
    }
}
