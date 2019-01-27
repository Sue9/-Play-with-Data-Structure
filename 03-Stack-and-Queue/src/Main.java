import java.util.Random;

public class Main {
	// test: how long it would cost for enqueue and dequeue with given operation count
	private static double testQueue(Queue<Integer> q, int opCount){
		long startTime = System.nanoTime();

		Random r = new Random();
		for(int i = 0; i < opCount; i++){
			q.enqueue(r.nextInt(Integer.MAX_VALUE));
		}
		for(int i = 0; i < opCount; i++){
			q.dequeue();
		}
		long endTime = System.nanoTime();

		return (endTime - startTime) / 1000000000.0;
	}
    public static void main(String[] args) {
	    int opCount = 100000;

	    ArrayQueue<Integer> arrayQ = new ArrayQueue<>();
	    double time1 = testQueue(arrayQ, opCount);
	    System.out.println("ArrayQueue, time: " + time1 + " s");

		LoopQueue<Integer> loopQ = new LoopQueue<>();
		double time2 = testQueue(loopQ, opCount);
		System.out.println("LoopQueue, time: " + time2 + " s");

    }
}
