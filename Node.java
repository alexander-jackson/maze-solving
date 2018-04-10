public class Node {
    // Defines a Node object as having a Location, its different cost values and
    // a parent Node
    private Coordinate Location;
    private int FCost, GCost, HCost;
    private Node Parent;

    /**
     * Defines a default constructor for a Node that simply initialises it with a
     * location at (0,0)
     */
    public Node() {
        this(0, 0);
    }

    /**
     * Defines a constructor for a Node that takes a coordinate for the location
     * @param C The location of the Node
     */
    public Node(Coordinate C) {
        this.Location = C;
    }

    /**
     * Defines a constructor for a Node that takes an x and y coordinate as seperate inputs
     * @param x The x coordinate of the Node
     * @param y The y coordinate of the Node
     */
    public Node(int x, int y) {
        this.Location = new Coordinate(x, y);
    }

    /**
     * Defines a Get method for the location property of the Node
     * @return Returns the Location of the Node
     */
    public Coordinate GetLocation() {
        return this.Location;
    }

    /**
     * Defines a Get method for the FCost property of the Node
     * @return Returns the FCost of the Node
     */
    public int GetFCost() {
        return this.FCost;
    }

    /**
     * Defines a Get method for the GCost property of the Node
     * @return Returns the GCost of the Node
     */
    public int GetGCost() {
        return this.GCost;
    }

    /**
     * Defines a Get method for the Parent of the Node
     * @return Returns the Parent of the Node
     */
    public Node GetParent() {
        return this.Parent;
    }

    /**
     * Defines a Set method for the FCost variable
     * @param FCost The value to set the FCost to
     */
    public void SetFCost(int FCost) {
        this.FCost = FCost;
    }

    /**
     * Defines a Set method for the GCost variable
     * @param GCost The value to set the GCost to
     */
    public void SetGCost(int GCost) {
        this.GCost = GCost;
        CalculateFCost();
    }

    /**
     * Defines a simple Set method for the Parent variable
     * @param Parent The Node to set Parent to
     */
    public void SetParent(Node Parent) {
        this.Parent = Parent;
    }

    /**
     * Defines a method to make a deep copy of a node and return it
     * @return Returns a copy of the current node with a different pointer
     */
    public Node Copy() {
        Node CopyNode = new Node(this.Location);
        CopyNode.FCost = this.FCost;
        CopyNode.GCost = this.GCost;
        CopyNode.HCost = this.HCost;
        CopyNode.Parent = this.Parent;
        return CopyNode;
    }

    /**
     * Defines a method to calculate the heuristic for the Node given
     * the Coordinate of the end
     * @param End The end point of the maze as a coordinate
     */
    public void CalculateHeuristic(Coordinate End) {
        int dx = Math.abs(this.Location.GetX() - End.GetX());
        int dy = Math.abs(this.Location.GetY() - End.GetY());
        this.HCost = 10 * (dx + dy) - 6 * Math.min(dx, dy);
        CalculateFCost();
    }

    /**
     * Defines an equals method to compare two Node objects for the same coordinate reference
     * @param  O The Object to compare it to
     * @return   Returns true if the nodes point to the same coordinate
     */
    @Override
    public boolean equals(Object O) {
        if (O == this) return true;
        if (!(O instanceof Node)) return false;

        Node N = (Node) O;
        return (this.Location.equals(N.GetLocation()));
    }

    /**
    * Defines a simple method to set the FCost of the Node to the sum of the
    * GCost and HCost values
    */
    private void CalculateFCost() {
        this.FCost = this.GCost + this.HCost;
    }
}
