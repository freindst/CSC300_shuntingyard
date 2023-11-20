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
        String numbers = "0123456789";
        String temp = "";
        for(int i = 0; i < input.length(); i++){
            if (numbers.indexOf(input.charAt(i)) >= 0){
                temp += input.charAt(i);
            } else {
                if (temp.length()>0){
                    this.Tokens.append(temp);
                }
                temp = "";
                this.Tokens.append(Character.toString(input.charAt(i)));
            }
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
        OpStack operatorStack = new OpStack();
        Node token = this.Tokens.Head;
        while(token != null){
            if (operatorStack.IsLeftParenthesis(token.Data)) {
                operatorStack.push(token.Data);
            } else if (operatorStack.IsRightParenthesis(token.Data)) {
                // Pop operators from the stack and append to reversePolish until an opening parenthesis is encountered
                while (!operatorStack.isEmpty() && !operatorStack.IsLeftParenthesis(operatorStack.peek().Data)) {
                    ReversePolish.enqueue(operatorStack.pop().Data);
                }
                if (!operatorStack.isEmpty() && operatorStack.IsLeftParenthesis(operatorStack.peek().Data)) {
                    operatorStack.pop(); // Discard the '('
                }
            } else if (operatorStack.IsOperator(token.Data)) {
                if (token.Data.charAt(0) == '+' || token.Data.charAt(0) == '-'){
                    while(!operatorStack.isEmpty() && (operatorStack.peek().Data.charAt(0) == '*' || operatorStack.peek().Data.charAt(0) == '/')){
                        this.ReversePolish.enqueue(operatorStack.pop().Data);
                    }
                }
                operatorStack.push(token.Data);
            } else {
                // Operand
                this.ReversePolish.enqueue(token.Data);
            }
            token = token.NextNode;
    	 }
    	 while (!operatorStack.isEmpty()) {
            ReversePolish.enqueue(operatorStack.pop().Data);
        }
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
        OpStack tempstack = new OpStack();
        while(!ReversePolish.isEmpty()) {
        	String temp = ReversePolish.dequeue().Data;
        	if(tempstack.IsOperator(temp)) {
        		int x = Integer.parseInt(tempstack.pop().Data);
        		int y = Integer.parseInt(tempstack.pop().Data);
                switch (temp.charAt(0)) {
                    case '*':
                        x = y * x;
                        break;
                    case '/':
                        x = y / x;
                        break;
                    case '+':
                        x = y + x;
                        break;
                    case '-':
                        x = y - x;
                        break;
                    default:
                        break;
                }
        		tempstack.push(Integer.toString(x));
        	} else {
        		tempstack.push(temp);
        	}
        }
        return Integer.parseInt(tempstack.pop().Data);
    }

    
}
