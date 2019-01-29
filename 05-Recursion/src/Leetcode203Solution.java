class Leetcode203Solution {
    public ListNode removeElements(ListNode head, int val){
        //delete front of the linked list
        while(head != null && head.val == val){
//            ListNode delNode = head;
//            head = head.next;
//            delNode.next = null;
            head = head.next;
        }

        if(head == null)
            return head;

        //delete back of the linked list
        ListNode prev = head;
        while(prev.next != null){
            if(prev.next.val == val){
//                ListNode delNode = prev.next;
//                prev.next = delNode.next;
//                delNode.next = null;
                prev.next = prev.next.next;
            }
            else
                prev = prev.next;
        }

        return head;
    }
}
