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
     * Defines a method to calculate the heuristic for the Node given
     * the Coordinate of the end
     * @param End The end point of the maze as a coordinate
     */
    public void CalculateHeuristic(Coordinate End) {
        int dx = Math.abs(this.Location.GetX() - this.End.GetX());
        int dy = Math.abs(this.Location.GetY() - this.End.GetY());
        this.HCost = 10 * (dx + dy) - 6 * Math.min(dx, dy);
    }

    /**
     * Defines a simple method to set the FCost of the Node to the sum of the
     * GCost and HCost values
     */
    public void CalculateFCost() {
        this.FCost = this.GCost + this.HCost;
    }
}
