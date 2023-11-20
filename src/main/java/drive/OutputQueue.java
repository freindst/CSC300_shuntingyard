package drive;
public class OutputQueue extends Queue{

    @Override
    public void enqueue(String data) {
        this.prepend(data);
    }

    @Override
    public Node dequeue() {
        Node result = this.Tail;
        this.removeTail();
        return result;
    }

    @Override
    public Node peek() {
        return this.Tail;
    }
    
}