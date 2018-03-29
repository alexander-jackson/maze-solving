public class ArrayList<E> {
    private int Size;
    private float ExtensionFactor;
    private E[] Data;

    /**
     * Defines a constructor for the ArrayList, which initialises the Data array,
     * sets the Size to 0 and sets the default ExtensionFactor as 1.5
     */
    @SuppressWarnings("unchecked")
    public ArrayList() {
        this.Data = (E[]) new Object[25];
        this.Size = 0;
        this.ExtensionFactor = 1.5f;
    }

    /**
     * Defines a method used to add an element to the ArrayList, automatically
     * increasing the size of the ArrayList if needed
     * @param Element The Element to be added to the ArrayList
     */
    @SuppressWarnings("unchecked")
    public void Add(E Element) {
        if (this.Size == this.Data.length) {
            // Increase the size of the array by the ExtensionFactor
            E[] Temp = (E[]) new Object[(int) Math.floor(this.Size * this.ExtensionFactor)];
            // Copy all the original items in
            for (int i = 0; i < this.Size; i++) {
                Temp[i] = this.Data[i];
            }
            // Set Data to be the temporary array
            this.Data = Temp;
        }

        // Add the element to the list
        this.Data[this.Size++] = Element;
    }

    /**
     * Defines a method to get the value of the ArrayList at a certain index
     * @param  Index The index to retrieve
     * @return       Returns the element at that index if it exists
     */
    public E Get(int Index) {
        // Check that the index is out of bounds of the array
        if (Index < 0 || this.Data.length <= Index) {
            throw new ArrayIndexOutOfBoundsException("Tried to access an index out of bounds of the array.");
        }

        // The index is safe to use
        return this.Data[Index];
    }

    /**
     * Defines a method to set the value of an index in the ArrayList
     * @param Index   The index to set
     * @param Element The value to set that index to
     */
    public void Set(int Index, E Element) {
        // Check that the index is out of bounds of the array
        if (Index < 0 || this.Data.length <= Index) {
            throw new ArrayIndexOutOfBoundsException("Tried to access an index out of bounds of the array.");
        }

        // The index is safe to use
        this.Data[Index] = Element;
    }

    /**
     * Defines a method to remove an index from the ArrayList
     * @param  Index The index to remove
     * @return       The item that was removed
     */
    public E Remove(int Index) {
        // Check that the index is out of bounds of the array
        if (Index < 0 || this.Data.length <= Index) {
            throw new ArrayIndexOutOfBoundsException("Tried to access an index out of bounds of the array.");
        }

        // The index is safe to use
        // Store the element we are removing so we can return it
        E Temp = this.Data[Index];
        // Shift all other elements ahead of it back one
        for (int i = Index; i < this.Data.length - 1; i++) {
            this.Data[i] = this.Data[i + 1];
        }

        // Decrement the size of the array
        this.Size--;
        // Return the element we removed
        return Temp;
    }

    /**
     * Defines a method to remove an element from the ArrayList
     * @param  Element The element to remove
     * @return         The item that was removed;
     */
    public E Remove(E Element) {
        // Find the element in the array
        for (int i = 0; i < this.Size; i++) {
            // Check whether this element is the one we are trying to find
            if (this.Data[i].equals(Element)) {
                // Store the element in a variable
                E Temp = this.Data[i];

                // Shift all the elements back one
                for (int j = i; j < this.Size - 1; j++) {
                    this.Data[j] = this.Data[j + 1];
                }

                // Decrement the size of the array
                this.Size--;
                // Return the element that was removed
                return Temp;
            }
        }

        // We didn't find the element, so return null
        return null;
    }

    /**
     * Defines a method to find an element in the ArrayList and return its index
     * @param  Element The element to find
     * @return         The index of the element
     */
    public int Find(E Element) {
        for (int i = 0; i < this.Size; i++) {
            if (this.Data[i].equals(Element)) return i;
        }

        return -1;
    }

    /**
     * Defines a method to display the elements of the array
     */
    public void Display() {
        for (int i = 0; i < this.Size; i++) {
            System.out.print(this.Data[i].toString() + " ");
        }
        System.out.print("\n");
    }
}
