package drive;

public class ShuntingYard {
    public LinkedList Tokens;

    public OutputQueue ReversePolish;

    public ShuntingYard(){
        this.Tokens = new LinkedList();
        this.ReversePolish = new OutputQueue();
    }

    //parse a math expression into a linked list
    //input: the math expression as a string
    //parsed result will stored in Tokens linked list
    public void parse(String input){
    	OpStack operatorStack = new OpStack();
    	boolean lastWasNum = false;
    	 for (int i = 0; i < input.length(); i++) {
    	        Character currentChar = input.charAt(i);

    	        if (currentChar == '(') {
    	            operatorStack.push(Character.toString(currentChar));
    	            lastWasNum = false;
    	        } else if (currentChar == ')') {
    	            // Pop operators from the stack and append to reversePolish until an opening parenthesis is encountered
    	            while (!operatorStack.isEmpty() && operatorStack.peek().Data.charAt(0) != '(') {
    	            	ReversePolish.enqueue(" ");
    	            	ReversePolish.enqueue(operatorStack.pop().Data.toString());
    	            }
    	            if (!operatorStack.isEmpty() && operatorStack.peek().Data.charAt(0) == '(') {
    	                operatorStack.pop(); // Discard the '('
    	            }
    	            lastWasNum = false;
    	        } else if (currentChar == '*' || currentChar == '/' || currentChar == '+' || currentChar == '-') {
    	            // Pop operators from the stack and append to reversePolish until the stack is empty or
    	            // the top operator has lower precedence than the current operator
    	            while (!operatorStack.isEmpty() && ShuntingYard.precedence(operatorStack.peek().Data.charAt(0)) >= ShuntingYard.precedence(currentChar)) {
    	                
    	            	ReversePolish.enqueue(" ");
    	            	ReversePolish.enqueue((operatorStack.pop().Data));
    	                
    	            }
    	            operatorStack.push(currentChar.toString());
    	            lastWasNum = false;
    	        } else {
    	            // Operand
    	        	if(!lastWasNum) {
    	        		ReversePolish.enqueue(" ");
    	        	}
    	            ReversePolish.enqueue(currentChar.toString());
    	            lastWasNum = true;
    	           // ReversePolish.enqueue(" ");
    	        }
    	 }
    	 
    	 while (!operatorStack.isEmpty()) {
    	        ReversePolish.enqueue(operatorStack.pop().toString());
    	        ReversePolish.enqueue(" ");
    	    }

    	    // Print or return the Reverse Polish Notation
    	 	Node currNode = ReversePolish.vals.Head;
    	    for(int i = 0; i < ReversePolish.getLength()-2; i++) {
    	    	
    	    	System.out.println(currNode.Data);
    	    	currNode = currNode.NextNode;
    	    }
    	}
    
    
    public static int precedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return 0; // Assume all other characters have lower precedence
        }
    }
    /*
     * 1.  While there are tokens to be read:
     * 2.        Read a token
     * 3.        If it's a number add it to queue
     * 4.        If it's an operator
     * 5.               While there's an operator on the top of the stack with greater precedence:
     * 6.                       Pop operators from the stack onto the output queue
     * 7.               Push the current operator onto the stack
     * 8.        If it's a left bracket push it onto the stack
     * 9.        If it's a right bracket 
     * 10.            While there's not a left bracket at the top of the stack:
     * 11.                     Pop operators from the stack onto the output queue.
     * 12.             Pop the left bracket from the stack and discard it
     * 13. While there are operators on the stack, pop them to the queue
     */
    //take the tokens from Tokens queue, and stored the reversed polish expression in ReversePolish queue
    public void process(){
        //to do
    }

    /*
     * 1. Tokens on queue dequeue() one by one
     * 2. Each time a number or operand dequeue(), push it to the stack.
     * 3. Each time an operator comes up, pop() operands from the stack, perform the operations,
              and push the result back to the stack.
     * 4. Finished when there are no tokens to read. 
     * 5. The final number on the stack is the result.
     */
    //process use the reverse polish format of expression to process the math result
    //output: the math result of the expression
    public int run(){
        //to do
        throw new Error("waiting for implement");
    }

    
}
