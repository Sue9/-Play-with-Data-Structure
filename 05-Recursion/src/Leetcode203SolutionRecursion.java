class Leetcode203SolutionRecursion {
    public ListNode removeElements(ListNode head, int val){
        if(head == null)
            return head;

        head.next = removeElements(head.next, val);
//        if(head.val == val)
//            return head.next;
//        else{
//            return head;
//        }
        return head.val == val ? head.next : head;

    }

    public static void main (String args[]){
        int[] arr = {1,2,3,6,7,8,6};
        ListNode ln = new ListNode(arr);
        System.out.println(ln);
        ListNode res = (new Leetcode203SolutionRecursion()).removeElements(ln, 6);
        System.out.println(res);
    }
}
