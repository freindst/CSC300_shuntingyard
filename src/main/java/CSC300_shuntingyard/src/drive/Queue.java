package drive;
public abstract class Queue extends LinkedList {
    public abstract void enqueue(String data);

    public abstract Node dequeue();

    public abstract Node peek();
}
