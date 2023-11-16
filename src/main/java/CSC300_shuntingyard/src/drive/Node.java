package drive;

public class Node {
    public String Data;
    public Node NextNode;
    public Node PreviousNode;

    public Node(){
        this.Data = null;
        this.NextNode = null;
        this.PreviousNode = null;
    }

    public Node(String input){
        this.Data = input;
        this.NextNode = null;
        this.PreviousNode = null;
    }
}
