package drive;

public class LinkedList {
    public Node Head;
    public Node Tail;
    public int Size;

    public LinkedList(){
        this.Head = null;
        this.Tail = null;
        this.Size = 0;
    }

    public void append(String data){
        Node newNode = new Node(data);
        if (this.Size == 0){
            this.Head = this.Tail = newNode;
        } else {
            this.Tail.NextNode = newNode;
            newNode.PreviousNode = this.Tail;
            this.Tail = newNode;
        }
        this.Size++;
    }

    public void prepend(String data){
        Node newNode = new Node(data);
        if (this.Size == 0){
            this.Head = this.Tail = newNode;
        } else {
            newNode.NextNode = this.Head;
            this.Head.PreviousNode = newNode;
            this.Head = newNode;
        }
        this.Size++;
    }

    public void removeTail(){
        if (this.Size > 1){
            Node newTail = this.Tail.PreviousNode;
            newTail.NextNode = null;
            this.Tail.PreviousNode = null;
            this.Tail = newTail;
            this.Size--;
        } else if (this.Size == 1){
            this.Tail.PreviousNode = null;
            this.Head = this.Tail = null;
            this.Size--;
        }
    }

    public void removeHead(){
        if (this.Size > 1){
            Node newHead = this.Head.NextNode;
            newHead.PreviousNode = null;
            this.Head.NextNode = null;
            this.Head = newHead;
            this.Size--;
        } else if (this.Size == 1){
            this.Head.NextNode = null;
            this.Head = this.Tail = null;
            this.Size--;
        }
    }

    public boolean isEmpty(){
        return this.Size == 0;
    }

    public int getLength(){
        return this.Size;
    }

    @Override 
    public String toString(){
        String output = "";
        Node node = this.Head;
        while(node != null){
            output += node.Data;
            node = node.NextNode;
        }
        return output;
    }
}
