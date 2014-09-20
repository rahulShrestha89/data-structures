/**
 * 
 * @author rahulshrestha
 *
 */
public class InfixToPostfix {

	// instantiate Stack class
	static Stack operatorStack = new Stack();

	/**
	 * Constructor
	 */
	public InfixToPostfix() {

	}

	/**
	 * Checks the expressions for balanced parentheses, braces and brackets
	 * @param infix
	 * @return true if the equations are balanced
	 */
	public boolean checkEquation(String infix){

		operatorStack.reset();
		for(int j=0;j<infix.length();j++){    // loop until the end of the line for a string (expression)
			// Check for parentheses
			if( infix.charAt(j)=='('){
				operatorStack.push(infix.charAt(j)); // push the parentheses to stack
			} 
			// Check for braces
			else if( infix.charAt(j)=='[' ){
				operatorStack.push(infix.charAt(j)); // push the braces to stack
			}
			// Check for bracket
			else if( infix.charAt(j)=='{' ){
				operatorStack.push(infix.charAt(j)); // push the bracket to stack
			}

			/* for reverse cases */
			// Check for reverse parentheses
			else if( infix.charAt(j)==')' ){
				if(operatorStack.isStackEmpty()){
					return false;
				}
				if(operatorStack.pop()!='('){
					return false;
				}
			}
			// Check for reverse braces
			else if( infix.charAt(j)==']' ){
				if(operatorStack.isStackEmpty()){
					return false;
				}
				if(operatorStack.pop()!='['){
					return false;
				}
			}
			// Check for reverse bracket
			else if( infix.charAt(j)=='}' ){
				if(operatorStack.isStackEmpty()){
					return false;
				}
				if(operatorStack.pop()!='{'){
					return false;
				}
			}
			// ignore other characters for now
		} // close for loop

		return operatorStack.isStackEmpty();

	}

	/**
	 * Performs postfix operation and returns value 
	 * @param infix
	 * @return postfix operation value 
	 *
	 * -'0' converts into int 
	 * +'0' converts into char
	 */
	
	public char postfixOperation(String infix) {
		
		operatorStack.reset();
		int firstOperand=0;
		int secondOperand=0;
		for(int j=0;j<infix.length();j++){    // loop until the end of the line for a string (expression)
			// Check for numbers 
			if( infix.charAt(j)>='0' && infix.charAt(j)<='9' ){
				operatorStack.push(infix.charAt(j));
				
			}
			//check for '+'
			else if( infix.charAt(j)=='+'){
				firstOperand = (int) operatorStack.pop() -'0';	// pop first operand
				secondOperand = (int) operatorStack.pop() -'0'; // pop second operand
				operatorStack.push((char)((firstOperand + secondOperand) +'0'));
			}
			//check for '-'
			else if( infix.charAt(j)=='-'){
				firstOperand = (int) operatorStack.pop() -'0';	// pop first operand
				secondOperand = (int) operatorStack.pop() -'0'; // pop second operand
				operatorStack.push((char)(( -firstOperand + secondOperand  ) +'0'));
			}
			//check for '*'
			else if( infix.charAt(j)=='*'){
				firstOperand = (int) operatorStack.pop()-'0';	// pop first operand
				secondOperand = (int) operatorStack.pop()-'0'; // pop second operand
				operatorStack.push((char)((firstOperand * secondOperand) +'0'));
			}
			//check for '/'
			else if( infix.charAt(j)=='/'){
				firstOperand = (int) operatorStack.pop()-'0';	// pop first operand
				secondOperand = (int) operatorStack.pop()-'0'; // pop second operand
				operatorStack.push((char)((secondOperand / firstOperand ) +'0'));
			}
			
		}        

		return operatorStack.pop();
	} // end of postfixOperation();

	/**
	 * Converts an infix expression to postfix expression
	 * @param string
	 */
	public StringBuffer infixToPostfix(String infix) {

		StringBuffer postfix = new StringBuffer();	// create a string buffer
		for(int j=0;j<infix.length();j++){    // loop until the end of the line for a string (expression)
			if(infix.charAt(j)>='0' && infix.charAt(j)<='9'){
				postfix.append(infix.charAt(j));
			}
			else if(infix.charAt(j)=='+'){
				operatorStack.push(infix.charAt(j));
			}
			else if(infix.charAt(j)=='-'){
				operatorStack.push(infix.charAt(j));
			}
			else if(infix.charAt(j)=='*'){
				operatorStack.push(infix.charAt(j));
			}
			else if(infix.charAt(j)=='/'){
				operatorStack.push(infix.charAt(j));
			}
			else if(infix.charAt(j)==')'){
				postfix.append(operatorStack.pop());
			}
			else if(infix.charAt(j)=='('){
				System.out.print("");
			}
			
		}
		while(!operatorStack.isStackEmpty()){	// clear the stack until empty
			postfix.append(operatorStack.pop());
		}
		return postfix;
		
	}	// end of infixToPostfix()
	

}	// end of class
