public class NodeMap {
    // The width and the height of the mapping
    private int Width, Height;
    // An array to store the data of the Maze in Node form
    private Node[] Data;

    /**
     * Defines a constructor for the NodeMap class to initialise the variables
     * @param Width  The width of the map
     * @param Height The height of the map
     */
    public NodeMap(int Width, int Height) {
        this.Data = new Node[Width * Height];
        this.Width = Width;
        this.Height = Height;
    }

    /**
     * Defines a simple Get method to get the Node at a certain coordinate
     * @param  C The Coordinate to access
     * @return   Returns the Node at that Coordinate
     */
    public Node Get(Coordinate C) {
        return this.Get(C.GetX(), C.GetY());
    }

    /**
     * Defines a simple Get method to get the Node at a certain coordinate
     * @param  x The x coordinate of the Node
     * @param  y The y coordinate of the Node
     * @return   Returns the Node at that Coordinate
     */
    public Node Get(int x, int y) {
        return this.Data[x * this.Height + y];
    }

    /**
     * Defines a simple Set method to set the value of a Node at a Coordinate
     * @param C The Coordinate to set
     * @param N The Value to set it to
     */
    public void Set(Coordinate C, Node N) {
        this.Set(C.GetX(), C.GetY(), N);
    }

    /**
     * Defines a simple Set method to set the value of a Node at a Coordinate
     * @param x The x coordinate of the Node
     * @param y The y coordinate of the Node
     * @param N The Value to set it to
     */
    public void Set(int x, int y, Node N) {
        this.Data[x * this.Height + y] = N;
    }
}
