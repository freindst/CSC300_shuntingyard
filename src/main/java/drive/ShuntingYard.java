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
    public void process()
    {
        Node tempNode = this.Tokens.Head;
        OpStack operatorStack = new OpStack();

        while (tempNode != null) {
            String token = tempNode.Data;

            if (token.matches("0|1|2|3|4|5|6|7|8|9")) {
                this.ReversePolish.enqueue(token); // If it's a number, add it directly to the output queue
            } else if (token.matches("+|-|/|*")) {
                // If it's an operator
                while (!operatorStack.isEmpty() && ShuntingYard.hasHigherPrecedence(operatorStack.peek().Data, token)) {
                    this.ReversePolish.enqueue(operatorStack.pop()); // Pop higher precedence operators to output queue
                }
                operatorStack.push(token); // Push current operator onto the stack
            } else if (token.equals("(")) {
                operatorStack.push(token); // If it's a left bracket, push it onto the stack
            } else if (token.equals(")")) {
                // If it's a right bracket
                while (!operatorStack.isEmpty() && !operatorStack.peek().equals("(")) {
                    this.ReversePolish.enqueue(operatorStack.pop()); // Pop operators to output until left bracket
                }
                operatorStack.pop(); // Discard the left bracket
            }

            tempNode = tempNode.NextNode;
        }
        
        while (!operatorStack.isEmpty()) {
            this.ReversePolish.enqueue(operatorStack.pop()); // Pop any remaining operators to output
        }
    }
    public static boolean hasHigherPrecedence(String op1, String op2) {
        int precedenceOp1 = getPrecedence(op1);
        int precedenceOp2 = getPrecedence(op2);

        return precedenceOp1 >= precedenceOp2;
    }

    private static int getPrecedence(String operator) {
        switch (operator) {
            case "+":
            case "-":
                return 1;
            case "*":
            case "/":
                return 2;
            default:
                return 0; // If it's not a recognized operator, assign the lowest precedence
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
        //to do
        throw new Error("waiting for implement");
    }

    
}
