import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayStack<T> implements Stack<T> //from class notes
{
	private int top;
	private int capacity;
	private T[] arr;

	public ArrayStack() //constructor
	{
		capacity = 10;
		top = 0;
		arr = (T[]) new Object[capacity];
	}

	private void grow_array()
	{
		capacity *= 2;
		T[] new_arr = (T[]) new Object[capacity]; //create array twice the size of original
		
		System.arraycopy(arr, 0, new_arr, 0, arr.length); //from https://www.geeksforgeeks.org/system-arraycopy-in-java/
		
		arr = new_arr;
	}

	public void push(T item)
	{
		if (top == capacity) //if full, double array size and then add item
		{
			grow_array();
		}
		arr[top++] = item;
	}

	public T pop() throws Exception
	{
		return arr[--top];
	}

	public T peek() throws Exception
	{
		return arr[top];
	}

	public boolean empty()
	{
		return top == 0;
	}
}