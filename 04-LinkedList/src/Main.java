public class Main {

    public static void main(String[] args) {
	    LinkedList<Integer> ll = new LinkedList<>();
	    for(int i = 0; i < 5; i++){
	        ll.addFirst( i );
	        System.out.println( ll );
        }

        ll.add(2, 666);
        System.out.println( ll );

        ll.remove( 2 );
        System.out.println( ll );


    }
}
