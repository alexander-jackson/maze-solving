public class Stack<E> implements IStack<E> {
    // A variable to store the data within the stack
    private ArrayList<E> Data;

    /**
     * Defines a constructor to initialise the data within the stack
     */
    public Stack() {
        this.Data = new ArrayList<E>();
    }

    /**
     * Defines a method to push an element onto the stack
     * @param Element The element to be pushed to the stack
     */
    public void Push(E Element) {
        this.Data.Add(Element);
    }

    /**
     * Defines a method to pop an element from the stack
     * @return The element that was popped
     */
    public E Pop() {
        return this.Data.Remove(this.Data.GetSize() - 1);
    }

    /**
     * Defines a method to get the element that is at the top of the stack
     * @return The element on top of the stack
     */
    public E Top() {
        return this.Data.Get(this.Data.GetSize() - 1);
    }

    /**
     * Defines a method to get the size of the stack currently
     * @return The size of the stack/number of elements on it
     */
    public int GetSize() {
        return this.Data.GetSize();
    }

    /**
     * Defines a method to check whether the stack is empty or not
     * @return True if the stack is empty and false if not
     */
    public boolean IsEmpty() {
        return this.Data.GetSize() == 0;
    }
}
