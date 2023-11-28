package drive;
public abstract class Stack extends LinkedList {
    public abstract void push(String data);

    public abstract Node pop();

    public abstract Node peek();
}
