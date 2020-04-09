public class ArrayQueue<T> implements Queue<T> //from class notes
{
	private int front;
	private int back;
	private int item_count;
	private int capacity;
	private T[] arr;

	public ArrayQueue() //constructor
	{
		capacity = 10;
		front = 0;
		back = -1;
		item_count = 0;
		arr = (T[]) new Object[capacity];
	}

	public void enqueue(T item)
	{
		++item_count;
		if (item_count == capacity)
		{
			grow_array();
		}
		arr[(++back) % (capacity)] = item;
	}

	public T dequeue() throws Exception
	{
		if (item_count == 0) //if nothing in array, throw Exception
		{
			throw new Exception("Queue is empty");
		}

		--item_count; //decrement for removing item
		return arr[(front++) % (capacity)]; 
	}
	
	public boolean empty()
	{
		return item_count == 0;
	}

	private void grow_array()
	{
		capacity *= 2;
		T[] new_arr = (T[]) new Object[capacity]; //create array twice the size of original
		
		for (int i = 0; i < arr.length; i++) //from https://algs4.cs.princeton.edu/13stacks/ResizingArrayQueue.java.html
		{
			new_arr[i] = arr[(front + i) % (arr.length)];
		}

		arr = new_arr;
	}
}
