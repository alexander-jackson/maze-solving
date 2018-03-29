public interface IStack<E> {
    public void Push(E Element);
    public E Pop();
    public E Top();
    public int GetSize();
    public boolean IsEmpty();
}
