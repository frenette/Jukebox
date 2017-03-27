package tests;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

public class Testing {
    Queue<Integer> testQueue = new LinkedList<>();
    
    @Test
    public void testing() {
	testQueue.add(1);
	testQueue.add(2);
	testQueue.add(3);
	testQueue.add(4);
	testQueue.add(5);
	testQueue.add(6);
	testQueue.add(7);
	testQueue.add(8);
	testQueue.add(9);
	testQueue.add(10);
	
	Iterator<Integer> testQueueIterator = testQueue.iterator();
	
	testQueue.forEach(System.out::println);
	
	System.out.println("this.testQueue.size(): " + this.testQueue.size());
	System.out.println("testQueueIterator.next(): " + testQueueIterator.next());
	System.out.println("this.testQueue.size(): " + this.testQueue.size());
	testQueueIterator.remove();
	System.out.println("this.testQueue.size() after testQueueIterator.remove(): " + this.testQueue.size());
	testQueue.forEach(System.out::println);
    }
}
