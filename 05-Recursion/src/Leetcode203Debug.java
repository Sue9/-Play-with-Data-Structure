class Leetcode203Debug {
    public ListNode removeElements(ListNode head, int val, int depth){
        String depthString = generateDepthString(depth);
        System.out.print(depthString);
        System.out.println("Call: remove " + val + " in " + head);

        if(head == null){
            System.out.print(depthString);
            System.out.println("Return: " + head);
            return head;
        }


        ListNode res = removeElements(head.next, val, depth + 1);
        System.out.print(depthString);
        System.out.println("After remove " + val + ": " + res);

        ListNode ret;
        if(head.val == val)
            ret = res;
        else{
            head.next = res;
            ret = head;
        }
        System.out.print(depthString);
        System.out.println("Return: " + ret);

        return ret;

    }

    private String generateDepthString(int depth){
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < depth; i++)
            res.append("--");
        return res.toString();

    }

    public static void main (String args[]){
        int[] arr = {1,2,3,6,7,8,6};
        ListNode ln = new ListNode(arr);
        System.out.println(ln);
        ListNode res = (new Leetcode203Debug()).removeElements(ln, 6, 0);
        System.out.println(res);
    }
}
