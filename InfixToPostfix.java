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
	

}
