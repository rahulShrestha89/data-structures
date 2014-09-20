/**
 * 
 * @author rahulshrestha
 *
 */

public class Stack {

	private char [] stackElements;  // Holds stack elements
	private int top;   // Stack top pointer

	/**
      Constructor.
      @param capacity The capacity of the stack.
	 */

	public Stack () {
		stackElements = new char[2000];
		top = 0;
	}

	/**
      The empty method checks for an empty stack.
      @return true if stack is empty.
	 */

	public boolean isStackEmpty() 
	{ 
		return top == 0; 
	}

	/**
      The push method pushes a value onto the stack.
      @param value The value to push onto the stack.
	  @exception StackOverflowException When the 
		stack is full.
	 */

	public void push(char value) 
	{
		if (top == stackElements.length)  
			throw new StackOverFlowException();
		else
		{
			stackElements[top] = value;
			top ++;           
		}         
	} // end of push()

	/** 
      The pop method pops a value off the stack.
      @return The value popped.
	  @exception EmptyStackException When the 
		stack is empty.
	 */

	public char pop()
	{
		if (isStackEmpty())
			throw new EmptyStackException();
		else
		{
			top--;
			return stackElements[top];
		}
	} // end of pop()

	/** 
      The peek method returns the value at the
      top of the stack.
      @return value at top of the stack.
		@exception EmptyStackException When the 
		stack is empty.
	 */

	char peek()
	{
		if (isStackEmpty())
			throw new EmptyStackException();
		else
		{
			return stackElements[top-1];
		}
	} // end of peek()

	/**
	 * reset stack
	 */

	public void reset(){
		top = 0;
	} // end of reset()

	

}