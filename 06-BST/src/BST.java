import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BST<E extends Comparable<E>> {
    private class Node{
        public E e;
        public Node left, right;

        public Node(E e){
            this.e = e;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BST(){
        root = null;
        size = 0;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void add(E e){

        root = add(root, e);

    }

    //add e into node
    private Node add(Node node, E e){

        if(node == null){
            size ++;
            return new Node(e);
        }

        //e < node.e
        if(e.compareTo(node.e) < 0){
            node.left = add(node.left, e);
        }
        else if (e.compareTo(node.e) > 0){
            node.right = add(node.right, e);
        }

        return node;
    }


    public boolean contains(E e){
        return contains(root, e);
    }


    private boolean contains(Node node, E e){
        if(node == null)
            return false;

        if(e.compareTo(node.e) == 0)
            return true;
        else if(e.compareTo(node.e) < 0)
            return contains(node.left, e);
        else
            return contains(node.right, e);
    }

    public void preOrder(){
        preOrder(root);

    }

    private void preOrder(Node node){
        if(node == null)
            return;

        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    //preOrder not recursive
    public void preOrderNR(){
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.empty()){
            Node cur = stack.pop();
            System.out.println(cur.e);
            if(cur.right != null)
                stack.push(cur.right);
            if(cur.left != null)
                stack.push(cur.left);
        }
    }

    public void inOrder(){
        inOrder(root);
    }

    private void inOrder(Node node){
        if(node == null)
            return;

        inOrder(root.left);
        System.out.println(node.e);
        inOrder(root.right);
    }

    public void postOrder(){
        postOrder(root);
    }

    private void postOrder(Node node){
        if(node == null)
            return;

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }


    public void levelOrder(){
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            Node cur = q.remove();
            System.out.println(cur.e);
            if(cur.left != null)
                ((LinkedList<Node>) q).add(cur.left);
            if(cur.right != null)
                ((LinkedList<Node>) q).add(cur.right);
        }
    }


    public E minimum(){
        if(size == 0)
            throw new IllegalArgumentException("BST is empty!");
        return minimum(root).e;
    }

    private Node minimum(Node node){
        if(node.left == null)
            return node;
        return minimum(node.left);
    }

    public E maximum(){
        if(size == 0)
            throw new IllegalArgumentException("BST is empty!");
        return maximum(root).e;
    }

    private Node maximum(Node node){
        if(node.right == null)
            return node;
        return maximum(node.right);
    }


    public E removeMin(){
        E ret = minimum();
        removeMin(root);
        return ret;
    }

    private Node removeMin(Node node){
        if(node.left == null)

    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        generateBSTString(root, 0, res);
        return res.toString();
    }

    private void generateBSTString(Node node, int depth, StringBuilder res){
        if(node == null){
            res.append(generateDepthString(depth) + "null\n");
            return;
        }

        res.append(generateDepthString(depth) + node.e + "\n");
        generateBSTString(node.left, depth + 1, res);
        generateBSTString(node.right, depth + 1, res);
    }

    private String generateDepthString(int depth){
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < depth; i++){
            res.append("--");
        }
        return res.toString();
    }

}
