package org.tweetqueue;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyQueueTest {
	
	private MyQueue queue;


	@Before
	public void setupQueue() {
		queue = new MyQueue();
	}

	@Test
	public void testConstruction() {
		assertTrue(queue.isEmpty());
	}

	@Test
	public void insertOneNotEmpty() {
		queue.enqueue("Kevin");
		assertFalse(queue.isEmpty());
	}
	
	@Test 
	public void enqueueTwoDequeueTwo() {
		//arrange
		String expectedFirstItem = "Kevin";
		String expectedSecondItem = "Brian";
		queue.enqueue(expectedFirstItem);
		queue.enqueue(expectedSecondItem);
		
		//act
		Object actualFirstItem = queue.dequeue();
		Object actualSecondItem = queue.dequeue();
		
		//assert
		assertEquals("first item wrong",expectedFirstItem,actualFirstItem);
		assertEquals("second item wrong",expectedSecondItem,actualSecondItem);
	}
	
	@Test
	public void dequeueLastItem() {
		//arrange
		queue.enqueue("something");
		
		//act
		queue.dequeue();
		
		//assert
		assertTrue("queue with final item dequeued should be empty",queue.isEmpty());
	}
	
	@Test
	public void enqueueNullIsFine() {
		//act
		queue.enqueue(null);
		
		//assert
		assertFalse("queue with null in it should not be empty",queue.isEmpty());
		assertNull("null should be dequeued successfully",queue.dequeue());
	}
	
	@Test(expected=IllegalStateException.class)
	public void dequeueOnEmptyQueue() {
		queue.dequeue();
	}
	
	@Test
	public void peekOnOneItem() {
		//arrange
		String expectedItem = "Kevin";
		queue.enqueue(expectedItem);
		
		//act
		Object actualItem = queue.peek();
		
		//assert
		assertEquals("peek returned wrong item",expectedItem,actualItem);
	}
	
	@Test
	public void peekDoesNotChangeQueueState() {
		//arrange
		queue.enqueue("something");
		
		//act
		queue.peek();
		
		//assert
		assertFalse("queue should not be empty",queue.isEmpty());
	}

	@Test(expected=IllegalStateException.class)
	public void peekOnEmptyQueue() {
		queue.peek();
	}
}
