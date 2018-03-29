public interface IArrayList<E> {
    public void Add(E Element);
    public E Get(int Index);
    public void Set(int Index, E Element);
    public E Remove(int Index);
    public E Remove(E Element);
    public int Find(E Element);
}
