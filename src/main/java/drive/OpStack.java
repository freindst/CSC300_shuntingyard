package drive;
public class OpStack extends Stack {
    private String Ops = "+-*/";
    private char leftParenthesis = '(';
    private char rightParenthesis = ')';

    @Override
    public void push(String data) {
        this.prepend(data);
    }

    @Override
    public Node pop() {
        Node result = this.Head;
        this.removeHead();
        return result;
    }

    @Override
    public Node peek() {
        return this.Head;
    }

    public boolean IsOperator(String s){
        if (s != null && s.length() > 0) {
            if (this.Ops.indexOf(s.charAt(0)) < 0){
                return false;
            } else {
                return true;
            }
        }
        return false;
    }

    public boolean IsLeftParenthesis(String s){
        if (s != null && s.length() > 0){
            if (this.leftParenthesis == s.charAt(0)){
                return true;
            }
        }
        return false;
    }

    public boolean IsRightParenthesis(String s){
        if (s != null && s.length() > 0){
            if (this.rightParenthesis == s.charAt(0)){
                return true;
            }
        }
        return false;
    }
}
