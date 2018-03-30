public class Coordinate {
    // The coordinates of the point
    private int x, y;

    /**
     * Defines a constructor for a coordinate class to store x and y values
     * @param x The x value of the coordinate
     * @param y The y value of the coordinate
     */
    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Defines a get method for the x value
     * @return Returns the x value
     */
    public int GetX() {
        return this.x;
    }

    /**
     * Defines a get method for the y value
     * @return Returns the y value
     */
    public int GetY() {
        return this.y;
    }

    /**
     * Defines a set method for the x value
     * @param x The value to set x to
     */
    public void SetX(int x) {
        this.x = x;
    }

    /**
     * Defines a set method for the y value
     * @param y The value to set y to
     */
    public void SetY(int y) {
        this.y = y;
    }

    /**
     * Defines a toString method for the Coordinate class
     * @return Returns a string format of the coordinate 
     */
    public String toString() {
        return String.format("(%d,%d)", x, y);
    }
}
