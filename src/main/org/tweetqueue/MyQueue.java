package org.tweetqueue;

import java.util.ArrayList;
import java.util.List;

public class MyQueue {
	
	private List<Object> items = new ArrayList<Object>();

	public boolean isEmpty() {
		return items.size()==0;
	}

	public void enqueue(Object item) {
		this.items.add(item);
	}

	public Object dequeue() {
		guardEmptyQueue();
		return items.remove(0);
	}

	public Object peek() {
		guardEmptyQueue();
		return items.get(0);
	}

	private void guardEmptyQueue() {
		if (isEmpty()) {
			throw new IllegalStateException("Cannot dequeue an empty queue");
		}
	}

}
